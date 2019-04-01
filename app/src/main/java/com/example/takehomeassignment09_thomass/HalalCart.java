package com.example.takehomeassignment09_thomass;

public class HalalCart {

    private String item;
    private int price;
    private boolean whiteSauce;
    private boolean redSauce;

    public HalalCart() {
    }

    public HalalCart(String item, int price, boolean whiteSauce, boolean redSauce) {
        this.item = item;
        this.price = price;
        this.whiteSauce = whiteSauce;
        this.redSauce = redSauce;
    }

    @Override
    public String toString() {
        return "HalalCart" + "\n" +
                "Item: " + item + "\n" +
                "Price: $" + price + "\n" +
                "WhiteSauce: " + whiteSauce + "\n" +
                "RedSauce: " + redSauce;
    }


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isWhiteSauce() {
        return whiteSauce;
    }

    public void setWhiteSauce(boolean whiteSauce) {
        this.whiteSauce = whiteSauce;
    }

    public boolean isRedSauce() {
        return redSauce;
    }

    public void setRedSauce(boolean redSauce) {
        this.redSauce = redSauce;
    }


}