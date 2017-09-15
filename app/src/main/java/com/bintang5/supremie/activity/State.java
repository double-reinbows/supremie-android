package com.bintang5.supremie.activity;


import java.util.ArrayList;

import utils.responses.GETResponseStock;

/**
 * Keeps key variables in memory.
 */
public class State  {

    private static State instance;

    private String diningMethod = null;

    private String brand = null;

    private Integer chooseMieFragmentId = null;

    private Integer quantityMie = null;

    private Integer mieId = null;

    private int[] drinkQuantities = null;

    private int[] toppingQuantities = null;

    private Integer pedasLevel = null;

    private int[] pedasPrices;

    private Integer grandTotal = null;

    private GETResponseStock allStock = null;

    ArrayList toppings = null;
    ArrayList drinks = null;

    public int getPedasPrice(int i) {
        return pedasPrices[i];
    }

    private State() {
        pedasPrices = new int[4];
        pedasPrices[0] = 0;
        pedasPrices[1] = 1000;
        pedasPrices[2] = 2000;
        pedasPrices[3] = 3000;
        toppings = new ArrayList();
//        mies = new ArrayList();
        drinks = new ArrayList();
    }

    public static State getInstance() {
        if (instance == null) {
            instance = new State();
        }
        return instance;
    }

    public void clear() {
        brand = null;
        chooseMieFragmentId = null;
        quantityMie = null;
        mieId = null;
        drinkQuantities = null;
        toppingQuantities = null;
        pedasLevel = null;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setChooseMieFragmentId(Integer chooseMieFragmentId, Integer quantityMie) {
        this.chooseMieFragmentId = chooseMieFragmentId;
        this.quantityMie = quantityMie;
    }

    public void setMieId(Integer mieId) {
        this.mieId = mieId;
    }

    public Integer getChooseMieFragmentId() {
        return chooseMieFragmentId;
    }

    public Integer getMieId() {
        return mieId;
    }

    public Integer getQuantityMie() {
        return quantityMie;
    }

    public int[] getDrinkQuantities() {
        return drinkQuantities;
    }

    public int[] getToppingQuantities() {
        return toppingQuantities;
    }

    public void setDrinkQuantity(Integer id, Integer quantity) {
        this.drinkQuantities[id] = quantity;
    }

    public void initDrinkQuantities(int size) {
        drinkQuantities = new int[size];
    }

    public void setToppingQuantity(Integer id, Integer quantity) {
        this.toppingQuantities[id] = quantity;
    }

    public void initToppingQuantities(int size) {
        toppingQuantities = new int[size];
    }

    public Integer getPedasLevel() {
        return pedasLevel;
    }

    public void setPedasLevel(Integer pedasLevel) {
        this.pedasLevel = pedasLevel;
    }

    public void setDiningMethod(String diningMethod) {
        this.diningMethod = diningMethod;
    }

    public String getDiningMethod() {
        return diningMethod;
    }

    public void setGrandTotal(Integer grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Integer getGrandTotal() {
        return grandTotal;
    }

    public Boolean isOrderDataSetup() {
        if (drinks == null) {
            return false;
        } else {
            return true;
        }
    }

    public void deleteOrderData() {
//        mies = null;
        drinks = null;
        toppings = null;
    }

    public ArrayList getToppings() {
        return toppings;
    }

//    public ArrayList getMies() {
//        return mies;
//    }

    public ArrayList getDrinks() {
        return drinks;
    }

    public void setToppings(ArrayList toppings) {
        this.toppings = toppings;
    }

//    public void setMies(ArrayList mies) {
//        this.mies = mies;
//    }

    public void setDrinks(ArrayList drinks) {
        this.drinks = drinks;
    }

    public void setAllStock(GETResponseStock allStock) {
        this.allStock = allStock;
    }

    public GETResponseStock getAllStock() {
        return allStock;
    }
}