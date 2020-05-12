package com.my.pro.service;

import com.my.pro.model.Car;
import com.my.pro.utils.Pager;
import java.util.*;

import com.my.pro.model.*;
import com.my.pro.dao.*;
import com.my.pro.service.*;


public interface CarService extends BaseService<Car>{

	/**
	 * dao层分页查询
	 */
	Pager<Car> findPager(Car car);

	void delete2(Integer id);
}
