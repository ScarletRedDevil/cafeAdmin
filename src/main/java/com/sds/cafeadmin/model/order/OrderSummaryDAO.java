package com.sds.cafeadmin.model.order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sds.cafeadmin.domain.OrderSummary;

@Mapper
public interface OrderSummaryDAO {
	
	public void insert(OrderSummary orderSummary);
    public List<OrderSummary> selectByOrderStatIdx(int stat);
    public void updateOrderStat(OrderSummary orderSummary);
    
    //
    public OrderSummary selectByOrderSummaryIdx(int ordersummary_idx);

}
