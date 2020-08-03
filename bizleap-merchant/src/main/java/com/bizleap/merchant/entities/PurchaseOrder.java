package com.bizleap.merchant.entities;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.bizleap.common.domain.AbstractEntity;

@Entity
@Table(name = "purchaseorder")
public class PurchaseOrder extends AbstractEntity {

		@Temporal(TemporalType.DATE)
		private Date purchaseDate;
		
		@Column(name = "price")
		private double price;
		
		@Column(name = "amount")
		private double amount;
		
		@Column(name = "quantity")
		private int quantity;
		
		@ManyToOne(cascade = CascadeType.ALL)
		private Product product;

		public PurchaseOrder() {
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public Date getPurchaseDate() {
			return purchaseDate;
		}

		public void setPurchaseDate(Date purchaseDate) {
			this.purchaseDate = purchaseDate;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		/*public static PurchaseOrder parsePurchaseOrder(String dataLine) {
			PurchaseOrder order = new PurchaseOrder();
			String[] tokens = dataLine.split(",");
			order.setId(Long.parseLong(tokens[0].trim()));
			order.setBoId(tokens[1].trim());
			order.setPurchaseDate(java.sql.Date.valueOf(LocalDate.parse((tokens[2].trim()))));
			order.setPrice(Double.parseDouble(tokens[3].trim()));
			order.setQuantity(Integer.parseInt(tokens[4].trim()));
			order.setAmount(Double.parseDouble(tokens[5].trim()));
			order.setProduct(new Product().boId(tokens[6].trim()));
			return order;
		}*/
		
		public static PurchaseOrder parsePurchaseOrder(String dataLine) {
			PurchaseOrder order = new PurchaseOrder();
			String[] tokens = dataLine.split(",");
			order.setBoId(tokens[0]);
			order.setPurchaseDate(java.sql.Date.valueOf(LocalDate.parse((tokens[1].trim()))));
			order.setPrice(Double.parseDouble(tokens[2].trim()));
			order.setQuantity(Integer.parseInt(tokens[3].trim()));
			order.setAmount(Double.parseDouble(tokens[4].trim()));
			order.setProduct(new Product().boId(tokens[5].trim()));
			return order;
		}
		
		@Override
		public String toString() {
			return new StringBuffer(super.toString())
									  .append("PurchaseDate: "+ getPurchaseDate())
									  .append("Price: " + getPrice())
									  .append("Amount: " + getAmount())
									  .append("Quantity:" + getQuantity())
									  .append("Product:" + getProduct())								  
									  .toString();
		}
}
