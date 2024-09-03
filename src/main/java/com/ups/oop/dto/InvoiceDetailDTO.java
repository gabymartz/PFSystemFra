package com.ups.oop.dto;

 public class InvoiceDetailDTO {
   private String serial;
   private String customer;
   private String branch;
   private String store;
   private String productName;
   private Double productPrice;
   private Integer quantity;
   private Integer total;
   private Double interestRate;
   private String supplier;
   private String paymentMethod;

   // Getters and Setters
   public String getSerial() {
      return serial;
   }
   public void setSerial(String serial) {
      this.serial = serial;
   }
   public String getCustomer() {
      return customer;
   }
   public void setCustomer(String customer) {
      this.customer = customer;
   }
   public String getBranch() {
      return branch;
   }
   public void setBranch(String branch) {
      this.branch = branch;
   }
   public String getStore() {
      return store;
   }
   public void setStore(String store) {
      this.store = store;
   }
   public String getProductName() {
      return productName;
   }
   public void setProductName(String productName) {
      this.productName = productName;
   }
   public Double getProductPrice() {
      return productPrice;
   }
   public void setProductPrice(Double productPrice) {
      this.productPrice = productPrice;
   }
   public Integer getQuantity() {
      return quantity;
   }
   public void setQuantity(Integer quantity) {
      this.quantity = quantity;
   }
   public Integer getTotal() {
      return total;
   }
   public void setTotal(Integer total) {
      this.total = total;
   }
   public Double getInterestRate() {
      return interestRate;
   }
   public void setInterestRate(Double interestRate) {
      this.interestRate = interestRate;
   }
   public String getSupplier() {
      return supplier;
   }
   public void setSupplier(String supplier) {
      this.supplier = supplier;
   }
   public String getPaymentMethod() {
      return paymentMethod;
   }
   public void setPaymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
   }

   @Override
   public String toString() {
      return "InvoiceDetailDTO{" +
              "serial='" + serial + '\'' +
              ", customer='" + customer + '\'' +
              ", branch='" + branch + '\'' +
              ", store='" + store + '\'' +
              ", productName='" + productName + '\'' +
              ", productPrice=" + productPrice +
              ", quantity=" + quantity +
              ", total=" + total +
              ", interestRate=" + interestRate +
              ", supplier='" + supplier + '\'' +
              ", paymentMethod='" + paymentMethod + '\'' +
              '}';
   }
}
