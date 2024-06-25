package com.sds.cafeadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.sds.cafeadmin.domain.OrderDetail;
import com.sds.cafeadmin.domain.OrderSummary;
import com.sds.cafeadmin.model.order.OrderDetailDAO;
import com.sds.cafeadmin.model.order.OrderDetailService;
import com.sds.cafeadmin.model.order.OrderSummaryDAO;
import com.sds.cafeadmin.model.order.OrderSummaryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class OrderController {
	
	@Autowired
	private OrderSummaryDAO orderSummaryDAO;
	
	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	@Autowired
	private OrderSummaryService orderSummaryService;
	
	@GetMapping("/admin/orderlist")
	public String getOrderList(Model model) {
		
	    List<OrderSummary> orderList = orderSummaryDAO.selectByOrderStatIdx(1); // 준비중인 주문 가져오기
	    model.addAttribute("orderList", orderList);
	    log.debug("담긴 리스트는 : "+orderList);
	    
	    for (OrderSummary order : orderList) {
	        List<OrderDetail> detailList = orderDetailDAO.getDetailList(order.getOrdersummary_idx());
	        log.debug("담긴 orderdetail은 : "+detailList);
	        order.setOrderDetailList(detailList); 
	    }
		
		return "order/orderlist";
	}
	
	@GetMapping("/admin/orderfinish")
	public String getOrderFinish(Model model) {
		
	    List<OrderSummary> orderList = orderSummaryDAO.selectByOrderStatIdx(2); // 완료 주문
	    model.addAttribute("orderList", orderList);
	    log.debug("담긴 리스트는 : "+orderList);
	     
	    for (OrderSummary order : orderList) {
	        List<OrderDetail> detailList = orderDetailDAO.getDetailList(order.getOrdersummary_idx());
	        log.debug("담긴 orderdetail은 : "+detailList);
	        order.setOrderDetailList(detailList);
	    }
		
		return "order/finishlist";
	}
	


}
