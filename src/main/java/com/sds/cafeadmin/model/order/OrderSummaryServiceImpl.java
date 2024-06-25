package com.sds.cafeadmin.model.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.cafeadmin.domain.OrderDetail;
import com.sds.cafeadmin.domain.OrderSummary;

@Service
public class OrderSummaryServiceImpl implements OrderSummaryService{

	@Autowired
	private OrderSummaryDAO orderSummaryDAO;
	
	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	public List<OrderSummary> selectByOrderStatIdx(int stat) {
		return orderSummaryDAO.selectByOrderStatIdx(stat);
	}

	@Override
	public void updateOrderStat(OrderSummary orderSummary) {
		orderSummaryDAO.updateOrderStat(orderSummary);
	}
	
    @Override
    public OrderSummary selectByOrderSummaryIdx(int ordersummary_idx) {
        return orderSummaryDAO.selectByOrderSummaryIdx(ordersummary_idx);
    }

	@Override
	public List<OrderDetail> getDetailList(int ordersummary_idx) {
		return orderDetailDAO.getDetailList(ordersummary_idx);
	}

	
}
