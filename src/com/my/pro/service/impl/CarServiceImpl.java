/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年04月14日 21时44分15秒
 */
package com.my.pro.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.my.pro.model.Car;
import com.my.pro.utils.Pager;
import com.my.pro.service.CarService;
import java.util.*;

import com.my.pro.model.*;
import com.my.pro.dao.*;
import com.my.pro.service.*;



@Service("carServiceImpl")
public class CarServiceImpl extends BaseServiceImpl<Car> implements CarService{
	 
	@Autowired
	private CarDao carDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<Car> findPager(Car car) {
		return carDao.findPager(car);
	}
	@Override
	public void delete2(Integer id) {
		// TODO Auto-generated method stub
		carDao.delete(id);
	}
	

	

}
