package com.example.cq4_expbook;

import java.time.YearMonth;

public class Expense {
    String name;
    String date;
    Float amount;
    String comment;

    public Expense(String name, String date, Float amount, String comment) {
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.comment = comment;
    }

    public Expense(String name, String date, Float amount) {
        this.name = name;
        this.date = date;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public Float getAmount() {
        return amount;
    }

    public String getComment() {
        return comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
