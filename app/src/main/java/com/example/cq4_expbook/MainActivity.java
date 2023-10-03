package com.example.cq4_expbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
        expenseList.setAdapter(expenseAdapter);

        final FloatingActionButton addButton = findViewById(R.id.add_expense);
        addButton.setOnClickListener(v -> {
            new AddExpenseFragment().show(getSupportFragmentManager(), "ADD_EXPENSE");
        });
        setUpListViewListener();
    }

    @Override
    public void onOkPressed(Expense expense) {
        System.out.println("SDussy");
        expenseData.add(expense);
        expenseAdapter.notifyDataSetChanged();
    }

    private void setUpListViewListener() {
        expenseList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//              Long click on a item and it will edit
                Context context = getApplicationContext();

                // Create new AddCityFragment and show it to user
                AddExpenseFragment editExpenseFragment = new AddExpenseFragment();
                editExpenseFragment.show(getSupportFragmentManager(), "EDIT_EXPENSE");
                editExpenseFragment.editExpense(expenseData.get(i));

                expenseAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}