package com.tech.test.msmusicsearch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price {

    @JsonProperty("valor")
    private double value;
    @JsonProperty("moneda")
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
