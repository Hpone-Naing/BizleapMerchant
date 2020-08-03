package com.bizleap.merchant.saver;

import java.util.List;

import com.bizleap.merchant.entities.Product;

public interface ProductSaver {

    public void save() throws Exception;
	public void setProductList(List<Product> productList);
	
}
