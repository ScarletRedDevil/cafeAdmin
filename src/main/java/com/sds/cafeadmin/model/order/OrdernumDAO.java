package com.sds.cafeadmin.model.order;

import org.apache.ibatis.annotations.Mapper;

import com.sds.cafeadmin.domain.Ordernum;

@Mapper
public interface OrdernumDAO {
	int insertOrdernum();
	int updateOrdernum();
	Ordernum selectLastOrdernum();
}
