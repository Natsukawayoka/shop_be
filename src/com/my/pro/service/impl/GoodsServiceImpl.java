/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年04月14日 21时44分16秒
 */
package com.my.pro.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.my.pro.model.Goods;
import com.my.pro.utils.Pager;
import com.my.pro.service.GoodsService;
import java.util.*;

import com.my.pro.model.*;
import com.my.pro.dao.*;
import com.my.pro.service.*;



@Service("goodsServiceImpl")
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService{
	 
	@Autowired
	private GoodsDao goodsDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<Goods> findPager(Goods goods) {
		return goodsDao.findPager(goods);
	}
	@Override
	public List<Goods> list() {
		return goodsDao.list2();
	}
	

	

}
