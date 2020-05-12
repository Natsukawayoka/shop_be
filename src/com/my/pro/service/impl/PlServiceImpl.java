/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 *
 */
 package com.my.pro.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.my.pro.model.Pl;
import com.my.pro.utils.Pager;
import com.my.pro.service.PlService;
import java.util.*;

import com.my.pro.model.*;
import com.my.pro.dao.*;
import com.my.pro.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * 
 */

@Service("plServiceImpl")
public class PlServiceImpl extends BaseServiceImpl<Pl> implements PlService{
	 
	@Autowired
	private PlDao plDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<Pl> findPager(Pl pl) {
		return plDao.findPager(pl);
	}
	

	

}
