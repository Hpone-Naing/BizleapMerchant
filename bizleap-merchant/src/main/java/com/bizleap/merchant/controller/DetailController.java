package com.bizleap.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.json.simple.JSONObject;
import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.entities.PurchaseOrder;
import com.bizleap.merchant.service.hibernate.ProductService;
import com.bizleap.merchant.service.hibernate.PurchaseOrderService;
import com.bizleap.utils.Parser;
import com.bizleap.utils.ServiceUnavailableException;

@Controller
public class DetailController {

	@Autowired
	ProductService productService;

	@Autowired
	PurchaseOrderService purchaseOrderService;

	@RequestMapping(value = "detail/{entityType}", method = RequestMethod.GET)
	public String detail(@RequestParam("input") String input, @PathVariable("entityType") String entityType,
			Model model) throws ServiceUnavailableException {
		
		JSONObject json = Parser.parseJSon(input);

		if (json == null) {
			model.addAttribute("status", "Error");
			return "detail";
		}

		String boId = (String) json.get("boId");

		switch (entityType) {
		case "PRODUCT":
			Product product = productService.findByBoId(boId);
			model.addAttribute("product", product);
			break;

		case "PURCHASEORDER":
			PurchaseOrder purchaseorder = purchaseOrderService.findByBoId(boId);
			model.addAttribute("purchaseorder", purchaseorder);
			break;

		default:
			break;
		}
		return "detail";
	}
}
