package com.bizleap.merchant.service.hibernate.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bizleap.common.domain.AbstractEntity;
import com.bizleap.merchant.dao.ProductDao;
import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.enums.EntityType;
import com.bizleap.merchant.service.hibernate.AbstractService;
import com.bizleap.merchant.service.hibernate.ProductService;
import com.bizleap.utils.ServiceUnavailableException;

@Service
@Transactional(readOnly = true)	
public class ProductServiceImpl extends AbstractServiceImpl implements ProductService, AbstractService {
		
	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional(readOnly = false)
	public void saveProduct(Product product) throws IOException, ServiceUnavailableException {
		if (product.isBoIdRequired()) {
			product.setBoId(getNextBoId());
		}
		productDao.save(product);
	}

	@Transactional(readOnly = true)
	public List<AbstractEntity> getAllEntity() throws ServiceUnavailableException {
		List<Product> productList = productDao.getAll("from Product");
		if (!CollectionUtils.isEmpty(productList)) {
			List<AbstractEntity> entityList = new ArrayList<AbstractEntity>();
			entityList.addAll(getAll());
			return entityList;
		}
		return null;
	}

	public List<Product> getAll() throws ServiceUnavailableException {
		List<Product> productList = productDao.getAll("from Product product");
		if (!CollectionUtils.isEmpty(productList)) {
			return productList;
		}
		return null;
	}

	public Product findByBoId(String boId) throws ServiceUnavailableException {

		String query = "from Product product where product.boId=:dataInput";
		List<Product> productList = productDao.findByString(query, boId);
		if (!CollectionUtils.isEmpty(productList)) {
			return productList.get(0);
		}
		return null;
	}

	public String getNextBoId() {
		return getNextBoId(EntityType.PRODUCT);
	}

	@Override
	public long getCount() {
		return productDao.getCount("select count(product) from Product product");
	}
}
