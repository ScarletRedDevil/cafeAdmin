package com.sds.cafeadmin.model.product;

import java.util.List;

import com.sds.cafeadmin.domain.TopCategory;

public interface TopCategoryService {
	
	public List selectAll();
	public TopCategory select(int topcategory_idx);

}
