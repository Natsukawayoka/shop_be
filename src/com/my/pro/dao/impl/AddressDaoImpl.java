package com.my.pro.dao.impl;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 *
 */
 import org.springframework.stereotype.Repository;
import com.my.pro.model.Address;
import com.my.pro.utils.Pager;
import com.my.pro.base.impl.BaseDaoImpl;
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

@Repository
public class AddressDaoImpl extends BaseDaoImpl<Address> implements AddressDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<Address> findPager(Address address) {
		if(address.getId() !=null && !"".equals(address.getId() )){
	    	   String hql = "from Address";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +address.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Address where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}
	
}
