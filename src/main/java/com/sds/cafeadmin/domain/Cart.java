package com.sds.cafeadmin.domain;

import lombok.Data;

@Data
public class Cart {
	private int cart_idx;
	private int ea;
	private Order order;
	private Product product;
}
