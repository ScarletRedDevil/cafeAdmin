package com.sds.cafeadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sds.cafeadmin.model.product.TopCategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProductController {
	
	@Autowired
	private TopCategoryService topCategoryService;

	//상품등록 페이지
	@GetMapping("/admin/product/registform")
	public String getProductRegistForm(Model model) {
		
		log.debug("등록폼 호출 ");
		
		List topList = topCategoryService.selectAll();
		
		model.addAttribute("topList", topList);

		return "product/regist";
	}
}
