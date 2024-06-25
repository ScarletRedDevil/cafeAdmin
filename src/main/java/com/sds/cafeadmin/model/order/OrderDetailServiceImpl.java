package com.sds.cafeadmin.model.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.cafeadmin.domain.OrderDetail;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	
	@Autowired
	private OrderDetailDAO orderDetailDAO;

	public List<OrderDetail> getOrderDetails(int ordersummary_idx) {
		
		return orderDetailDAO.getDetailList(ordersummary_idx);
	}

}
