package com.example.cq4_expbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddExpenseFragment.onFragmentInteractionListener {
    private ArrayList<Expense> expenseData;
    private ListView expenseList;
    private ArrayAdapter<Expense> expenseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expenseData = new ArrayList<Expense>();

        expenseList = findViewById(R.id.expense_list);
        expenseAdapter = new CustomList(this, expenseData);
    }

    @Override
    public void onOkPressed(Expense expense) {
        expenseList.add(expense);

    }
}