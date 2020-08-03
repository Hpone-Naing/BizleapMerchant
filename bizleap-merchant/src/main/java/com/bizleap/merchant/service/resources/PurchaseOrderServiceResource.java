package com.bizleap.merchant.service.resources;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bizleap.merchant.entities.PurchaseOrder;

public interface PurchaseOrderServiceResource {
	
    public @ResponseBody boolean createPurchaseOrder(HttpServletRequest request,@RequestBody PurchaseOrder purchaseOrder) throws Exception;
	
	public @ResponseBody List<PurchaseOrder> getAllPurchaseOrder(HttpServletRequest request) throws Exception;
	
	public @ResponseBody PurchaseOrder findByBoId(HttpServletRequest request, @PathVariable String boId) throws Exception;
}
