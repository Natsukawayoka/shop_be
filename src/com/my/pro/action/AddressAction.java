package com.my.pro.action;

import java.util.HashMap;
import org.springframework.beans.BeanUtils;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
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
import com.my.pro.dto.AddressDTO;
import com.my.pro.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * 
 */

@Controller("addressAction")
@Scope("prototype")
public class AddressAction extends BaseAction implements ModelDriven<Address>{
	
	private static final long serialVersionUID = 1L;


	
	//==========model==============
	  private Address address;
		@Override
		public Address getModel() {
			if(address==null) address = new Address();
			return address;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private AddressService addressService;
	
	//依赖注入 end  dao/service/===
	
	//-------------------------华丽分割线---------------------------------------------
	
	//============自定义参数start=============
	
	//============自定义参数end=============

	
	//-------------------------华丽分割线---------------------------------------------
	
	//============文件上传start=======================================================
	
	
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
	 * 列表分页查询 and isDelete = 0 
	 * 
	 */
	public String address(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Address where 1=1 ");
		sb = sb.append("order by id desc");
		Pager<Address> pagers = addressService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", address);
		return SUCCESS;
    }
	
	public String list(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Address where 1=1 and user.id ="+address.getUser().getId());
		sb = sb.append("order by id desc");
		List<Address> pagers = addressService.listByAlias(sb.toString(),alias);
		jsonMap.put("addressesList",pagers);
		return JSON_TYPE;
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
		User user = new User();
		user.setId(address.getUser().getId());
		if(!isEmpty(address.getName())){
			address.setName(new String(address.getName().getBytes("ISO-8859-1"), "UTF-8"));
		}
		if(!isEmpty(address.getDz())){
			address.setDz(new String(address.getDz().getBytes("ISO-8859-1"), "UTF-8"));
		}
		address.setUser(user);
		address.setIsMr(0);
		addressService.save(address);
		return JSON_TYPE;
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		Address n = addressService.getById(address.getId());
		
		AddressDTO AD = new AddressDTO();
		BeanUtils.copyProperties(n, AD);
		System.out.println(n.getUser());
		jsonMap.put("address",AD);
		return JSON_TYPE;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		Address n = addressService.getById(address.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
    
	/**
	 * 执行修改
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String exUpdate() throws UnsupportedEncodingException{
		Address n = addressService.getById(address.getId());
		if(!isEmpty(address.getName())){
			address.setName(new String(address.getName().getBytes("ISO-8859-1"), "UTF-8"));
		}
		if(!isEmpty(address.getDz())){
			address.setDz(new String(address.getDz().getBytes("ISO-8859-1"), "UTF-8"));
		}
		BeanUtils.copyProperties(address, n, getNullPropertyNames(address));
		addressService.update(n);
		return JSON_TYPE;
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		addressService.delete(address.getId());
		//n.setIsDelete(1);
		return JSON_TYPE;
	}
	
	public String mr(){
//		addressService.delete(address.getId());
		//n.setIsDelete(1);
		Address n = addressService.getById(address.getId());
		    Map<String,Object> alias = new HashMap<String,Object>();
			StringBuffer sb = new StringBuffer();
			sb = sb.append("from Address where 1=1 and user.id ="+n .getUser().getId());
			sb = sb.append("order by id desc");
			List<Address> pagers = addressService.listByAlias(sb.toString(),alias);
			if(!isEmpty(pagers)){
				
				for (Address add: pagers){
					add.setIsMr(0);
					addressService.update(add);
				}
				
			}
			n.setIsMr(1);
			addressService.update(n);
		return JSON_TYPE;
	}
	
	//=============公=======共=======方=======法==========区=========end============//
	
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============自=======定=======义=========方=======法==========区=========start============//
	
	
	
	
	//=============自=======定=======义=========方=======法==========区=========end============//
		
	
	
}
