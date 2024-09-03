package com.ups.oop.dto;

import java.time.LocalDate;
import java.util.Date;

public class InvoiceDTO {
   private String id;
   private String serial;
   private String client;
   private Date date;
   private String productName;
   private String quantity;
   private Double totalPrice;
   private String paymentMethod;

   // Getters and Setters
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }
   public String getSerial() {
      return serial;
   }
   public void setSerial(String serial) {
      this.serial = serial;
   }
   public String getClient() {
      return client;
   }
   public void setClient(String client) {
      this.client = client;
   }

   public Date getDate() {
       return date;
   }

   public void setDate(Date date) {
       this.date = date;
   }
   public Double getTotalPrice() {
      return totalPrice;
   }
   public String getProductName() {
       return productName;
   }

   public void setProductName(String productName) {
         this.productName = productName;
   }

   public String getQuantity() {
      return quantity;
   }

   public void setQuantity(String quantity) {
      this.quantity = quantity;
   }

   public void setTotalPrice(Double totalPrice) {
      this.totalPrice = totalPrice;
   }
   public String getPaymentMethod() {
      return paymentMethod;
   }
   public void setPaymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
   }

   @Override
   public String toString() {
      return "InvoiceDTO{" +
              "id='" + id + '\'' +
              ", serial='" + serial + '\'' +
              ", client='" + client + '\'' +
              ", date=" + date +
              ", product=" + productName +
              ", totalPrice=" + totalPrice +
              ", quantity=" + quantity +
              ", paymentMethod='" + paymentMethod + '\'' +
              '}';
   }
}
