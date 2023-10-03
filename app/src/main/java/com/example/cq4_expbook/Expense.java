package com.example.cq4_expbook;

import java.time.YearMonth;

public class Expense {
    String name;
    String date;
    Float charge;
    String comment;

    public Expense(String name, String date, Float charge, String comment) {
        this.name = name;
        this.date = date;
        this.charge = charge;
        this.comment = comment;
    }

    public Expense(String name, String date, Float charge) {
        this.name = name;
        this.date = date;
        this.charge = charge;
    }
}
