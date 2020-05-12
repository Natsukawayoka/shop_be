package com.my.pro.service;

import com.my.pro.model.Pp;
import com.my.pro.utils.Pager;
import java.util.*;

import com.my.pro.model.*;
import com.my.pro.dao.*;
import com.my.pro.service.*;


public interface PpService extends BaseService<Pp>{

	/**
	 * dao层分页查询
	 */
	Pager<Pp> findPager(Pp pp);
}
