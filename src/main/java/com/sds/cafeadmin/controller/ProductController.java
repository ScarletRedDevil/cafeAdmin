package com.sds.cafeadmin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sds.cafeadmin.domain.Product;
import com.sds.cafeadmin.domain.Psize;
import com.sds.cafeadmin.model.product.ImageService;
import com.sds.cafeadmin.model.product.ProductService;
import com.sds.cafeadmin.model.product.TopCategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProductController {
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ImageService imageService;

	//상품등록 페이지
	@GetMapping("/admin/product/registform")
	public String getProductRegistForm(Model model) {
		
		log.debug("등록폼 호출 ");
		
		List topList = topCategoryService.selectAll();
		
		model.addAttribute("topList", topList);

		return "product/regist";
	}
	
	//상품 목록요청 처리
		@GetMapping("/admin/product/list")
		public String getList(Model model) {
			//3단계: 목록 가져오기
			List productList = productService.selectAll();
			
			//4단계: 결과 저장
			model.addAttribute("productList", productList);
			
			return "/product/list";
		}
	
	//상품 업로드 요청 처리 (파일이 포함되어 있다)
		@PostMapping("/admin/product/regist") 
		public String regist(Product product, @RequestParam("size_name") String[] size_name, Model model) {
			log.debug("하위 카테고리 "+product.getSubCategory().getSubcategory_idx());
			log.debug("상품명 "+product.getProduct_name());
			log.debug("가격 "+product.getPrice());
			log.debug("상세설명 "+product.getDetail());
			log.debug("사이즈 수는 "+size_name.length);
			
			//서비스에게 Product DTO를 전달하기 전에사이즈 배열을 Product DTO안으로 밀어넣어서 한꺼번에 갖고 다니자!!
			
			List<Psize> psizeList = new ArrayList();
			for(String s : size_name) {
				Psize psize = new Psize(); //empty DTO
				psize.setSize_name(s);
				//아직 서비스에 의한 insert 이전 시점이므로, 부모에 대한 정보는 없는 상태이다
				psizeList.add(psize);
			}
			
//			imageService.save(product); //여기서 만일 에러가 난다면 GlobalExceptionHandler 가 처리
			log.debug("imageservice 여기서 동작");
			model.addAttribute("product", product);
			
			
			product.setPsizeList(psizeList);
			
			productService.regist(product); 
			
			return "redirect:/admin/product/list";
		}
}
