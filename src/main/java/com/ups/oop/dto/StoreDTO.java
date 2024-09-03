package com.ups.oop.dto;

public class StoreDTO {
    private Long id;
    private String storeName;
    private String storeLocation;

    public StoreDTO(Long id, String storeName, String storeLocation) {
        this.id = id;
        this.storeName = storeName;
        this.storeLocation = storeLocation;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStoreName() {
        return storeName;
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getStoreLocation() {
        return storeLocation;
    }
    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    @Override
    public String toString() {
        return "StoreDTO{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", storeLocation='" + storeLocation + '\'' +
                '}';
    }
}
