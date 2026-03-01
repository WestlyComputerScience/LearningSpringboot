package com.johnteacher.quickstart.Postman;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    // If no marker annotation, then variable name is the implied value
    // Postman looks for the names exactly (i.e. if c-name, then need JSON of c-name)
    // Note: this is case-sensitive
//    @JsonProperty("c-name") // reference this as the customer name
//    private String customerName;
//    @JsonProperty("p-name")
//    private String productID;
//    @JsonProperty("quantity")
//    private int quantity;

    // Accessors are getter and setter methods
    // Need these so when postman sends in an order JSON file the class can receive and store it.
    // Also it's so the class can then pull up this information when necessary.

//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public String getProductID() {
//        return productID;
//    }
//
//    public void setProductID(String productID) {
//        this.productID = productID;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    @Override
//    public String toString() {
//        return "customerName: " + customerName + ", productID: " + productID + ", quantity: " + quantity;
//    }
}
