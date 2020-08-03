package com.bizleap.merchant.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bizleap.merchant.entities.Product;
import com.bizleap.merchant.services.impl.RandomProductGenerator;

public class MapManipulator {

	private List<Product> productList;
	private List<String> putProductKeyList;
	private HashMap<String, Product> productMap = new HashMap<>();;
	private static MapManipulator instance = null;
	private static int productSize = 1000;
	//private Object lock = new Object();
	
	static {
		getInstance();
	}

	private MapManipulator() {
	}

	public static MapManipulator getInstance() {
		if (instance == null) {
			instance = new MapManipulator();
			RandomProductGenerator randomProductGenerator = new RandomProductGenerator();
			instance.setProductList(randomProductGenerator.getProductList(productSize));
		}
		return instance;
	}

	public boolean containInMap(String boId) {
		return (boId != null) && getPutProductKeyList().contains(boId);
	}

	public void putIntoMap(Product product, String threadName, long callCount) {
		if (product != null && getProductMap() != null) {
			if (getPutProductKeyList().add(product.getBoId())) {
				//synchronized (this) {
					getProductMap().put(product.getBoId(), product);
				//}
				showAction("Putting: " + product.getBoId(), threadName, callCount);
			} else {
				showAction("----------PUTTING FAILED: " + product.getBoId(), threadName, callCount);
			}
		}
	}

	public Product getFromMap(String boId, String threadName, long callCount) {
		if (boId != null) {
				if (getProductMap().get(boId) != null) {
					showAction("Getting: " + boId, threadName, callCount);
				} else {
					showAction("----------GETTING FAILED: " + boId, threadName, callCount);
				}
			}
		return null;
	}

	public void removeFromMap(String boId, String threadName, long callCount) {
		if (boId != null) {
			if (getPutProductKeyList().remove(boId)) {
				//synchronized (this) {
					getProductMap().remove(boId);
				//}
				showAction("Removing: " + boId, threadName, callCount);
			} else {
				showAction("----------REMOVING FAILED: " + boId, threadName, callCount);
			}
		}
	}

	/*
	 * public void removeFromMap(Product product, String threadName, long
	 * callCount){ if(product != null) {
	 * if(getPutProductKeyList().remove(product.getBoId())) {
	 * getProductMap().remove(product.getBoId()); showAction("Removing: " +
	 * product.getBoId(), threadName, callCount); } else {
	 * showAction("----------REMOVING FAILED: " + product.getBoId(), threadName,
	 * callCount); } } }
	 */

	/*
	 * public Product getFromMap(Product product, String threadName, long
	 * callCount){ if(product != null) { if(getProductMap().get(product.getBoId())
	 * != null) { showAction("Getting: " + product.getBoId(), threadName,
	 * callCount); } else { showAction("----------GETTING FAILED: " +
	 * product.getBoId(), threadName, callCount); } } return null; }
	 */
	public Product getRandomProductFromList() {
		if (getProductList() == null) {
			return null;
		}
		int randomNumber = (int) (Math.random() * getProductList().size());
		Product product = getProductList().get(randomNumber);
		return product;
	}

	public Product getRandomProductFromMap() {
		if (getPutProductKeyList().size() <= 0) {
			return null;
		}
		int index = (int) (Math.random() * getPutProductKeyList().size());
		// System.out.println("Product key list size: " +
		// getPutProductKeyList().size());
		// System.out.println("Random index: " + index);
		Product product = getProductMap().get(getPutProductKeyList().get(index));
		// System.out.println("Product: " + product);
		return product;
	}

	public String getRandomKey() {
		int randomNumber = (int) (Math.random() * getPutProductKeyList().size());
		String key = getPutProductKeyList().get(randomNumber);
		return key;
	}

	public void showAction(String action, String threadName, long callCount) {
		// System.out.println("Keys of productMap after "+ action + ": " +
		// getProductMap().getKeys().size());
		System.out.println(threadName + " Call Count" + callCount + " " + action + " " + getProductMap().size());
	}

	public HashMap<String, Product> getProductMap() {
		if (productMap == null) {
			productMap = new HashMap<>();
		}
		return productMap;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public void setProductMap(HashMap<String, Product> productMap) {
		this.productMap = productMap;
	}

	public List<String> getPutProductKeyList() {
		if (putProductKeyList == null) {
			putProductKeyList = new ArrayList<>();
		}
		return putProductKeyList;
	}

	public void setPutProductKeyList(List<String> putProductKeyList) {
		this.putProductKeyList = putProductKeyList;
	}
}
