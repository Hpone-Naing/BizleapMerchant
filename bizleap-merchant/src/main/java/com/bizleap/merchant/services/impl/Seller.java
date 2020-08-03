package com.bizleap.merchant.services.impl;

import com.bizleap.merchant.entities.PurchaseRecord;
import com.bizleap.merchant.loader.DataLoader;
import com.bizleap.merchant.loader.impl.DataLoaderImpl;

public class Seller {

	double flowerInitialOrder = 22500;
	double fruitInitialOrder = 800000;
	double candyBarInitialOrder = 66000;
	private DataLoader dataLoader;

	public void restock() throws Exception{
				 
		 dataLoader=new DataLoaderImpl();
		 for(PurchaseRecord purchaseRecord:dataLoader.loadPurchaseRecord()) {
			 switch(purchaseRecord.getItem().getProductType()) {
			 case FLOWER:
				 flowerInitialOrder -= purchaseRecord.getItem().getQuanitity();
				 if(flowerInitialOrder <= 100) 
					 System.out.println(purchaseRecord.getCustomer().getBuyProductDate());
			 break;
			 case FRUIT:
				 fruitInitialOrder -= purchaseRecord.getItem().getQuanitity();
				 if(fruitInitialOrder <= 500) 
					 System.out.println(purchaseRecord.getCustomer().getBuyProductDate());
			break;
			default:
					candyBarInitialOrder -= purchaseRecord.getItem().getQuanitity();
				 if(candyBarInitialOrder <= 300) 
					 System.out.println(purchaseRecord.getCustomer().getBuyProductDate());
		    break;
				 
			 }				 
		 } 
	 }

//	public static void main(String[] args) throws Exception {
//		new Seller().restock();
//	}
}
