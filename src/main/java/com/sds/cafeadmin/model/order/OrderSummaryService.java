package com.sds.cafeadmin.model.order;

import java.util.List;

import com.sds.cafeadmin.domain.OrderDetail;
import com.sds.cafeadmin.domain.OrderSummary;

public interface OrderSummaryService {
	public List<OrderSummary> selectByOrderStatIdx(int stat);
	public void updateOrderStat(OrderSummary orderSummary);
    public OrderSummary selectByOrderSummaryIdx(int ordersummary_idx);
    public List<OrderDetail> getDetailList(int ordersummary_idx);
}
