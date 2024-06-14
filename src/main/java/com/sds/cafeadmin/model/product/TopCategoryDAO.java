package com.sds.cafeadmin.model.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sds.cafeadmin.domain.TopCategory;

@Mapper
public interface TopCategoryDAO {
	
	public List selectAll();
	public TopCategory select(int topcategory_idx);

}
