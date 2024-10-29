package com.tech.test.msmusicsearch.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Price {

    private double value;
    private String currency;

    public Price() {}

    public Price(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public double getvalue() {
        return value;
    }

    public void setvalue(double value) {
        this.value = value;
    }

    public String getcurrency() {
        return currency;
    }

    public void setcurrency(String currency) {
        this.currency = currency;
    }
}
