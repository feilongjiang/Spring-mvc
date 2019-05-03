package com.example.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Product;
import form.ProductForm;
@Controller
public class ProductController {
	private static final Log logger = LogFactory.getLog(ProductController.class);
	
	@RequestMapping(value="/product_input")
	public String inputProduct() {
		logger.info("inputProduct called");
		return "ProductForm";
	}
	@RequestMapping(value="/product_save")
	public String saveProdcut(ProductForm productForm,Model model) {
		logger.info("saveProduct called");
		// no need to create and instantiate a ProductForm
		//create Product
		Product product = new Product();
		product.
	}
}
