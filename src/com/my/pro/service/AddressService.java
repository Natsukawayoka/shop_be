package com.my.pro.service;

import com.my.pro.model.Address;
import com.my.pro.utils.Pager;
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
public interface AddressService extends BaseService<Address>{

	/**
	 * dao层分页查询
	 */
	Pager<Address> findPager(Address address);
}
