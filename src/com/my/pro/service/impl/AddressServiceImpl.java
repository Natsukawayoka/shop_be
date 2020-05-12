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
import com.my.pro.model.Address;
import com.my.pro.utils.Pager;
import com.my.pro.service.AddressService;
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

@Service("addressServiceImpl")
public class AddressServiceImpl extends BaseServiceImpl<Address> implements AddressService{
	 
	@Autowired
	private AddressDao addressDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<Address> findPager(Address address) {
		return addressDao.findPager(address);
	}
	

	

}
