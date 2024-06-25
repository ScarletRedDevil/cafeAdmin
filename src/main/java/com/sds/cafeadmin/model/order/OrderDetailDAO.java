package com.sds.cafeadmin.model.order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sds.cafeadmin.domain.OrderDetail;

@Mapper
public interface OrderDetailDAO {
	public void insert(OrderDetail orderDetail);
	List<OrderDetail> getDetailList(int ordersummary_idx);
}
