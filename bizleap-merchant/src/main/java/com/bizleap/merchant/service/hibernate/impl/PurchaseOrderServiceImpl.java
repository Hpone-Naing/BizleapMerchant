package com.bizleap.merchant.service.hibernate.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bizleap.common.domain.AbstractEntity;
import com.bizleap.merchant.dao.PurchaseOrderDao;
import com.bizleap.merchant.entities.PurchaseOrder;
import com.bizleap.merchant.enums.EntityType;
import com.bizleap.merchant.service.hibernate.PurchaseOrderService;
import com.bizleap.utils.ServiceUnavailableException;

@Service
@Transactional(readOnly = true)
public class PurchaseOrderServiceImpl extends AbstractServiceImpl implements PurchaseOrderService {

	@Autowired
	private PurchaseOrderDao purchaseOrderDao;

	@Transactional(readOnly = false)
	public void savePurchaseOrder(PurchaseOrder purchaseOrder) throws IOException, ServiceUnavailableException {
		purchaseOrderDao.save(purchaseOrder);
	}

	@Transactional(readOnly = true)
	public List<AbstractEntity> getAllEntity() throws ServiceUnavailableException {
		List<PurchaseOrder> purchaseOrderList = purchaseOrderDao.getAll("from PurchaseOrder");
		if (!CollectionUtils.isEmpty(purchaseOrderList)) {
			List<AbstractEntity> entityList = new ArrayList<AbstractEntity>();
			entityList.addAll(getAll());
			return entityList;
		}
		return null;
	}

	public List<PurchaseOrder> getAll() throws ServiceUnavailableException {
		List<PurchaseOrder> purchaseOrderList = purchaseOrderDao.getAll("from PurchaseOrder purchaseorder");
		if (!CollectionUtils.isEmpty(purchaseOrderList)) {
			return purchaseOrderList;
		}
		return null;
	}

	public PurchaseOrder findByBoId(String boId) throws ServiceUnavailableException {
		String query = "from PurchaseOrder purchaseorder where purchaseorder.boId=:dataInput";
		List<PurchaseOrder> purchaseOrderList = purchaseOrderDao.findByString(query, boId);
		if (!CollectionUtils.isEmpty(purchaseOrderList)) {
			return purchaseOrderList.get(0);
		}
		return null;
	}
	public String getNextBoId() {
		return getNextBoId(EntityType.PURCHASEORDER);
	}

	@Override
	public long getCount() {
		return purchaseOrderDao.getCount("select count(purchaseorder) from PurchaseOrder purchaseorder");
	}
}
