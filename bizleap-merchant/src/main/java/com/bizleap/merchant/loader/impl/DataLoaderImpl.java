package com.bizleap.merchant.loader.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.entities.PurchaseOrder;
import com.bizleap.merchant.entities.PurchaseRecord;
import com.bizleap.merchant.loader.DataLoader;
import com.bizleap.merchant.loader.ErrorHandler;
import com.bizleap.merchant.loader.FileLoader;
import com.bizleap.utils.BizLeapUtils;

@Service
public class DataLoaderImpl implements DataLoader {

	private FileLoader fileLoader = null;
	private ErrorHandler errorHandler;

	// @Value("${application.path}")
	String path = "D:\\Bizleap-Projects\\DataFile";

	public Map<Integer, Error> errorMap;
	public int index = 1;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getFullPath(String fileName) {
		return BizLeapUtils.makePath(path, fileName);
	}

	public List<PurchaseRecord> loadPurchaseRecord() throws Exception {

		fileLoader = new FileLoaderImpl();
		fileLoader.start(getFullPath("purchaserecord.txt"));
		String dataLine = "";
		List<PurchaseRecord> purchaseRecordList = new ArrayList<PurchaseRecord>();
		PurchaseRecord purchaseRecord = null;
		while (fileLoader.hasMore()) {
			try {
				dataLine = fileLoader.getLine();
				purchaseRecord = PurchaseRecord.parsePurchaseRecord(dataLine);
				if (purchaseRecord != null) {
					purchaseRecordList.add(purchaseRecord);
				}
			} catch (Exception e) {
				e.printStackTrace();
				errorHandler.handleLoadingError(fileLoader.getLineNumber(),
						"PurchaseRecord file loading: " + e.toString(), fileLoader.getLine());
				System.exit(0);
				throw e;
			}
		}
		fileLoader.finish();
		return purchaseRecordList;
	}

	public List<Product> loadProduct() throws Exception {
		fileLoader = new FileLoaderImpl();
		fileLoader.start(getFullPath("product.txt"));
		String dataLine = "";
		List<Product> productList = new ArrayList<Product>();
		Product product = null;

		while (fileLoader.hasMore()) {
			try {
				dataLine = fileLoader.getLine();
				product = Product.parseProduct(dataLine);
				if (product != null) {
					productList.add(product);
				}
			} catch (Exception e) {
				e.printStackTrace();
				errorHandler.handleLoadingError(fileLoader.getLineNumber(), "Product file loading: " + e.toString(),
						fileLoader.getLine());
				throw e;
			}
		}
		fileLoader.finish();
		return productList;
	}

	@Override
	public List<PurchaseOrder> loadPurchaseOrder() throws Exception {

		fileLoader = new FileLoaderImpl();
		fileLoader.start(getFullPath("purchaseOrder.txt"));
		String dataLine = "";
		List<PurchaseOrder> purchaseOrderList = new ArrayList<PurchaseOrder>();
		PurchaseOrder purchaseOrder = null;

		while (fileLoader.hasMore()) {
			try {
				dataLine = fileLoader.getLine();
				purchaseOrder = PurchaseOrder.parsePurchaseOrder(dataLine);
				if (purchaseOrder != null) {
					purchaseOrderList.add(purchaseOrder);
				}
			} catch (Exception e) {
				e.printStackTrace();
				errorHandler.handleLoadingError(fileLoader.getLineNumber(),
						"PurchaseOrder file loading: " + e.toString(), fileLoader.getLine());
				throw e;
			}
		}
		fileLoader.finish();
		return purchaseOrderList;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(new DataLoaderImpl().loadPurchaseRecord());
	}
}