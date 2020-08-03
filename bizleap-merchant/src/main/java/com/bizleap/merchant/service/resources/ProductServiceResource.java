package com.bizleap.merchant.service.resources;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bizleap.merchant.entities.Product;

public interface ProductServiceResource {

	public @ResponseBody boolean createProduct(HttpServletRequest request,@RequestBody Product product) throws Exception;
	
	public @ResponseBody List<Product> getAllProduct(HttpServletRequest request) throws Exception;
	
	public @ResponseBody Product findByBoId(HttpServletRequest request, @PathVariable String boId) throws Exception;
}
