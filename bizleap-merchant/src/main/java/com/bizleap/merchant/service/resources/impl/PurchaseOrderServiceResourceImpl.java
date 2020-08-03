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
import com.bizleap.merchant.entities.PurchaseOrder;
import com.bizleap.merchant.service.hibernate.ProductService;
import com.bizleap.merchant.service.hibernate.PurchaseOrderService;
import com.bizleap.merchant.service.resources.PurchaseOrderServiceResource;
import com.bizleap.utils.ServiceUnavailableException;

@RestController
@RequestMapping(value = {"/purchaseorder"})
public class PurchaseOrderServiceResourceImpl implements PurchaseOrderServiceResource{
		
		@Autowired
		PurchaseOrderService purchaseOrderService;
		
		@Autowired
		ProductService productService;
		
		@Override
		@RequestMapping(method = RequestMethod.POST, value = "/new")
		public @ResponseBody boolean createPurchaseOrder(HttpServletRequest request,@RequestBody PurchaseOrder purchaseOrder) throws Exception {
			try {
				String boId = purchaseOrder.getProduct().getBoId();
				Product product = productService.findByBoId(boId);
				purchaseOrder.setProduct(product);
				purchaseOrderService.savePurchaseOrder(purchaseOrder);
			} catch (IOException e) {
				return false;
			}catch (ServiceUnavailableException e) {
					return false;
			}
			return false;
		}
		
		@Override
		@RequestMapping(method = RequestMethod.GET, value = "/list")
		public @ResponseBody List<PurchaseOrder> getAllPurchaseOrder(HttpServletRequest request) throws Exception {
			return purchaseOrderService.getAll();
		}
		
		@Override
		@RequestMapping(method = RequestMethod.GET, value = "/find/{boId}")
		public @ResponseBody PurchaseOrder findByBoId(HttpServletRequest request, @PathVariable String boId) throws Exception {
			return purchaseOrderService.findByBoId(boId);
		}
}
