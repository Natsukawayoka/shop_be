package com.my.pro.dao;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年04月14日 21时44分16秒
 */
import com.my.pro.utils.Pager;
import com.my.pro.base.BaseDao;
import java.util.*;

import com.my.pro.model.*;
import com.my.pro.dao.*;
import com.my.pro.service.*;




public interface PpDao extends BaseDao<Pp>{
	
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	Pager<Pp> findPager(Pp pp);
}
