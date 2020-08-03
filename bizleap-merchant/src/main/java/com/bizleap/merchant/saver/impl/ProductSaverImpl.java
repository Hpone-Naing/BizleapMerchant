package com.bizleap.merchant.saver.impl;

import com.bizleap.merchant.saver.ProductSaver;
import com.bizleap.merchant.service.hibernate.ProductService;
import com.bizleap.merchant.service.jdbc.ProductServiceJdbc;
import com.bizleap.merchant.service.jdbc.impl.ProductServiceJdbcImpl;
import com.bizleap.merchant.entities.Product;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSaverImpl implements ProductSaver{

	@Autowired
	private ProductService productService;
	
	private ProductServiceJdbc productServiceJdbc;

	private List<Product> productList;

	public ProductSaverImpl() {
		if (productServiceJdbc == null)
			productServiceJdbc = new ProductServiceJdbcImpl();
	}

	public List<Product> getProductList() {
		if (productList == null)
			productList = new ArrayList<Product>();
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	@Override
	public void save() throws Exception {
		if (productList != null) {
			for (Product product : productList) {
				productService.saveProduct(product);
			}
		}
	}	
}
