package com.sds.cafeadmin.model.order;

import java.util.List;

import com.sds.cafeadmin.domain.OrderDetail;

public interface OrderDetailService {
	public List<OrderDetail> getOrderDetails(int ordersummary_idx);
}
