package com.sds.cafeadmin.model.order;

import org.apache.ibatis.annotations.Mapper;

import com.sds.cafeadmin.domain.OrderStat;

@Mapper
public interface OrderStatDAO {
	public OrderStat select();

}
