package com.my.pro.service;

import com.my.pro.model.Dd;
import com.my.pro.utils.Pager;
import java.util.*;

import com.my.pro.model.*;
import com.my.pro.dao.*;
import com.my.pro.service.*;


public interface DdService extends BaseService<Dd>{

	/**
	 * dao层分页查询
	 */
	Pager<Dd> findPager(Dd dd);

	Dd save2(Dd d);
}
