package com.sds.cafeadmin.domain;

import lombok.Data;

@Data
public class Cart {
	private int cart_idx;
	private int ea;
	private Ordernum ordernum;
	private Product product;
}
