package com.sds.cafeadmin.domain;
import lombok.Data;

@Data
public class Psize {
	private int psize_idx;
	private String size_name;
	private Product product; //부모 참조
}
