package com.my.pro.service;

import com.my.pro.model.Lb;
import com.my.pro.utils.Pager;
import java.util.*;

import com.my.pro.model.*;
import com.my.pro.dao.*;
import com.my.pro.service.*;


public interface LbService extends BaseService<Lb>{

	/**
	 * dao层分页查询
	 */
	Pager<Lb> findPager(Lb lb);
}
