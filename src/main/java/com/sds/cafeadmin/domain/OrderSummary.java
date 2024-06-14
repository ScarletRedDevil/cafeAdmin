package com.sds.cafeadmin.domain;

import lombok.Data;

@Data
public class OrderSummary {
	private int ordersummary_idx;
	private Order order;
	private Paymethod paymethod;
	private String orderdate;
	private int total_buy;
	private int total_pay; //실제지불금액
}
