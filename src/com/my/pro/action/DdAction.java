package com.my.pro.action;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.my.pro.utils.Pager;
import com.opensymphony.xwork2.ModelDriven;
import java.util.*;

import com.my.pro.model.*;
import com.my.pro.dao.*;
import com.my.pro.dto.DdDto;
import com.my.pro.service.*;


@Controller("ddAction")
@Scope("prototype")
public class DdAction extends BaseAction implements ModelDriven<Dd>{
	
	private static final long serialVersionUID = 1L;
	private static long orderNum = 0l;    
    private static String date ;    
    @Autowired
	private AddressService addressService;
    private Integer status;
   	@Autowired
   	private PlService plService;
    
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	@Autowired
	private UserService userService;
	@Autowired
	private GoodsService goodsService;
	//==========model==============
	  private Dd dd;
		@Override
		public Dd getModel() {
			if(dd==null) dd = new Dd();
			return dd;	
		}
		
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private DdService ddService;
	
	private String ids;
	
	private Integer userId;
	
	//依赖注入 end  dao/service/===
	@Autowired
	private CarService carService;
	
	//-------------------------华丽分割线---------------------------------------------
	
	//============自定义参数start=============
	
	//============自定义参数end=============

	
	//-------------------------华丽分割线---------------------------------------------
	
	//============文件上传start=======================================================
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	private File file;
	//提交过来的file的名字
    private String fileFileName;
    //提交过来的file的MIME类型
    private String fileContentType;
    public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	 //============文件上传end=========================================================
	public String jsonAction() {
		  // dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据
		  jsonMap.clear();
		  jsonMap.put("success", true);
		  return JSON_TYPE;
	}
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============公=======共=======方=======法==========区=========start============//
	/**
	 * 列表分页查询
	 */
	public String dd(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Dd where 1=1 ");
		if(dd!=null && dd.getCode() !=null && !"".equals(dd.getCode())){
			sb.append("  and code like :realName ");
			alias.put("realName", "%" +dd.getCode()+ "%" );
		}
		sb = sb.append("order by id desc");
		Pager<Dd> pagers = ddService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", dd);
		return SUCCESS;
    }
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String add(){
		return SUCCESS;
	}
	
	/**
	 * 执行添加
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String exAdd() throws UnsupportedEncodingException{
		HttpServletRequest request = getRequest();
		
		User user = userService.getById(userId);
		//先查询这个人有没有默认地址
		List<Address> ads = addressService.listByAlias("from Address where isMr = 1  and user.id ="+userId,null);
		
		if (isEmpty(ads)){
			jsonMap.put("res", 0);//没有默认地址
			return "json";
		}else{
			//查看购物车有东西吗
			
			List<Car> listByAlias = carService.listByAlias("from Car where selected = 1 and  user.id="+userId,null );
			if (isEmpty(listByAlias)){
				jsonMap.put("res", 1);//购物车没有选中
				return "json";
			}else{
				Address s = ads.get(0);
				for (Car car : listByAlias){
					Dd d = new Dd();
					d.setAddress(s.getDz());
					d.setCode(getOrderNo());
					d.setCreateTime(new Date());
					d.setGoods(car.getGoods());
					d.setName(s.getName());
					d.setNum(car.getNum());
					d.setPhone(s.getPhone());
					Double valueOf = Double.valueOf(car.getPrice());
					d.setNum(car.getNum());
					double df = 0.0;
					BigDecimal b = new BigDecimal(valueOf*car.getNum());   
					df = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
					d.setPrice(df);
					d.setStatus(0);
					d.setUser(user);
					 Dd ddd = ddService.save2(d);
					carService.delete(car.getId());
					
					//修改商品数量
					Goods goods = car.getGoods();
					goods.setNum(goods.getNum()+car.getNum());
					goodsService.update(goods);
				}
				
			}
			
			
		}
	
		jsonMap.put("res", 2);//购物车没有选中
		return "json";
	}
	
	////订单状态 0 已支付待发货 1 已发货 2.申请退款 3 已退款 4 已收货 5 已评价
	public String userList(){
		HttpServletRequest request = getRequest();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"";
		List<DdDto> dds = new ArrayList<DdDto>();
		Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		if(dd.getStatus() != -1){
			sb = sb.append("from Dd where 1=1 and user.id= "+userId +" and status = "+dd.getStatus());
		}else{
			sb = sb.append("from Dd where 1=1 and user.id= "+userId );
		}
		
		if(dd!=null && dd.getCode() !=null && !"".equals(dd.getCode())){
			sb.append("  and code like :realName ");
			alias.put("realName", "%" +dd.getCode()+ "%" );
		}
		sb = sb.append("order by id desc");
		List<Dd> pagers = ddService.listByAlias(sb.toString(),alias);
		if(!isEmpty(pagers)){
			for(Dd d :pagers){
				DdDto do2 = new DdDto();
				String string = basePath+d.getGoods().getUrl1();
				String replaceAll;
				try {
					replaceAll = string.replaceAll("\\\\", "/").replaceAll("shop", "");
					do2.setPpUrl(replaceAll);
					do2.setCode(d.getCode());
					do2.setDdId(d.getId());
					do2.setDj(String.valueOf(d.getGoods().getPrice()));
					do2.setPrice(String.valueOf(d.getPrice()));
					do2.setTitle(d.getGoods().getTitle());
					do2.setAddress(d.getAddress());
					do2.setName(d.getName());
					do2.setPhone(d.getPhone());
					do2.setNum(d.getNum());
					do2.setStatus(d.getStatus());
					do2.setId(d.getId());
					do2.setSpId(d.getGoods().getId());
					//判断这个商品是否已经评价了
					List<Pl> listByAlias = plService.listByAlias("from Pl where user.id = "+userId + " and goods.id = "+d.getGoods().getId(), null);
					if (org.springframework.util.CollectionUtils.isEmpty(listByAlias)){
						do2.setIsPj(0);
					}else{
						do2.setIsPj(1);
					}
					dds.add(do2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		jsonMap.put("dds", dds);
		return "json";
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		Dd n = ddService.getById(dd.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		Dd n = ddService.getById(dd.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
    
	/**
	 * 执行修改
	 * @return
	 */
	public String exUpdate(){
		Dd n = ddService.getById(dd.getId());
		ddService.update(n);
		ActionContext.getContext().put("url", "/dd_dd.do");
		return "redirect";
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		ddService.delete(dd.getId());
		ActionContext.getContext().put("url", "/dd_dd.do");
		return "redirect";
	}
	
	//订单状态 0 已支付待发货 1 已发货 2.申请退款 3 已退款 4 已收货 5 已评价
	public String fh(){
		Dd byId = ddService.getById(dd.getId());
		byId.setStatus(1);
		ddService.update(byId);
		ActionContext.getContext().put("url", "/dd_dd.do");
		return "redirect";
	}
	public String tk(){
		Dd byId = ddService.getById(dd.getId());
		byId.setStatus(3);
		ddService.update(byId);
		ActionContext.getContext().put("url", "/dd_dd.do");
		return "redirect";
	}
	
	public String sh(){
		Dd byId = ddService.getById(dd.getId());
		byId.setStatus(4);
		ddService.update(byId);
		return "json";
	}
	
	public String sqtk(){
		Dd byId = ddService.getById(dd.getId());
		byId.setStatus(2);
		ddService.update(byId);
		return "json";
	}
	
	public String delete2(){
		ddService.delete(dd.getId());
		
		return "json";
	}
	//=============公=======共=======方=======法==========区=========end============//
	
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============自=======定=======义=========方=======法==========区=========start============//
	
	
	
	
	//=============自=======定=======义=========方=======法==========区=========end============//
		/** 时间戳生成订单号*/
	public static synchronized String getOrderNo() {    
        String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());    
        if(date==null||!date.equals(str)){    
            date = str;    
            orderNum  = 0l;    
        }    
        orderNum ++;    
        long orderNo = Long.parseLong((date)) * 10000;    
        orderNo += orderNum;;    
        return orderNo+"";    
    }    
	
}
