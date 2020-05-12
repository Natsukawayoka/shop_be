package com.my.pro.dao.impl;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 *
 */
 import org.springframework.stereotype.Repository;
import com.my.pro.model.Pl;
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
public class PlDaoImpl extends BaseDaoImpl<Pl> implements PlDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<Pl> findPager(Pl pl) {
		if(pl.getId() !=null && !"".equals(pl.getId() )){
	    	   String hql = "from Pl";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +pl.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Pl where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}
	
}
