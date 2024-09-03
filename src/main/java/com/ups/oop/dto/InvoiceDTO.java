package com.ups.oop.dto;

import java.time.LocalDate;

 public class InvoiceDTO {
   private String id;
   private String serial;
   private String customer;
   private LocalDate date;
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
   public String getCustomer() {
      return customer;
   }
   public void setCustomer(String customer) {
      this.customer = customer;
   }
   public LocalDate getDate() {
      return date;
   }
   public void setDate(LocalDate date) {
      this.date = date;
   }
   public Double getTotalPrice() {
      return totalPrice;
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
              ", customer='" + customer + '\'' +
              ", date=" + date +
              ", totalPrice=" + totalPrice +
              ", paymentMethod='" + paymentMethod + '\'' +
              '}';
   }
}
