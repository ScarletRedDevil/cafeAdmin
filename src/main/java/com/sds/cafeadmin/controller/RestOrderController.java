package com.sds.cafeadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sds.cafeadmin.domain.OrderDetail;
import com.sds.cafeadmin.domain.OrderSummary;
import com.sds.cafeadmin.model.order.OrderDetailDAO;
import com.sds.cafeadmin.model.order.OrderSummaryDAO;
import com.sds.cafeadmin.model.order.OrderSummaryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestOrderController {
	
	@Autowired
	private OrderSummaryDAO orderSummaryDAO;
	
	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	@Autowired
	private OrderSummaryService orderSummaryService;
	
	@PutMapping("/admin/orderlist/{ordersummary_idx}")
	public ResponseEntity<?> completeOrder(@PathVariable("ordersummary_idx") int ordersummary_idx) {
	    OrderSummary order = orderSummaryDAO.selectByOrderSummaryIdx(ordersummary_idx);
	    if (order == null) {
	        return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
	    }
	    order.getOrderstat().setOrderstat_idx(2);
	    orderSummaryDAO.updateOrderStat(order);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/admin/orderdetail/{ordersummary_idx}")
	public List<OrderDetail> getDetailList(Model model,@PathVariable("ordersummary_idx") int ordersummary_idx) {
		List<OrderDetail> orderDetailList=orderSummaryService.getDetailList(ordersummary_idx);
		
		return orderDetailList;
	}
	@GetMapping("/admin/getorderlist")
	public List<OrderSummary> getOrder() {
		List<OrderSummary> orderList = orderSummaryService.selectByOrderStatIdx(1);
		
		return orderList;
	}

}
