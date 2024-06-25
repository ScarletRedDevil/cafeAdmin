package com.sds.cafeadmin.model.product;

import org.apache.ibatis.annotations.Mapper;

import com.sds.cafeadmin.domain.Psize;

@Mapper
public interface PsizeDAO {
	public void insert(Psize psize);
}
