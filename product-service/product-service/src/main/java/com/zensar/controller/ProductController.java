package com.zensar.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.entity.CouponDto;
import com.zensar.entity.Product;
import com.zensar.services.ProductService;

@RestController
@RequestMapping("/product-api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private RestTemplate restTemplate;


	@PostMapping("/products")
	public Product insertProduct(@RequestBody Product product) {
		
		String couponCode = product.getCouponCode();
		
		
		ResponseEntity<CouponDto> responseEntity = restTemplate.getForEntity("http://localhost:8585/coupon-api/coupons/"+couponCode, CouponDto.class);
		
		CouponDto couponDto=responseEntity.getBody();
		
		System.out.println(couponDto);
		
		product.setPrice(product.getPrice()-50);
		
		return productService.insertProduct(product);
		
		
	
	}

}


