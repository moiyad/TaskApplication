package com.example.pc.taskapplication;

/**
 * Created by PC on 2018-03-12.
 */

public class Currency {

    private String base;
    private String date;
    private Rates rates;

    public Currency(String base, String date, Rates rates) {
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Rates getRates() {
        return rates;
    }

}
