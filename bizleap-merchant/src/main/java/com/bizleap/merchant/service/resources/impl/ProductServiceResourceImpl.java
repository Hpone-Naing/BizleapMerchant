package com.bizleap.merchant.service.resources.impl;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.service.hibernate.ProductService;
import com.bizleap.merchant.service.resources.ProductServiceResource;
import com.bizleap.utils.ServiceUnavailableException;

@RestController
@RequestMapping(value = {"/product"})
public class ProductServiceResourceImpl implements ProductServiceResource{
	
	@Autowired
	ProductService productService;
	
	@Override
	@RequestMapping(method = RequestMethod.POST, value = "/new")
	public @ResponseBody boolean createProduct(HttpServletRequest request,@RequestBody Product product) throws Exception {
		try {
			productService.saveProduct(product);
		} catch (IOException e) {
			return false;
		}catch (ServiceUnavailableException e) {
				return false;
		}
		return false;
	}
	
	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public @ResponseBody List<Product> getAllProduct(HttpServletRequest request) throws Exception {
		return productService.getAll();
	}
	
	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/find/{boId}")
	public @ResponseBody Product findByBoId(HttpServletRequest request, @PathVariable String boId) throws Exception {
		return productService.findByBoId(boId);
	}
}
