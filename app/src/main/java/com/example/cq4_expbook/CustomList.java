package com.example.cq4_expbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<Expense> {
    private ArrayList<Expense> expenses;
    private Context context;
    public CustomList(Context context, ArrayList<Expense> expenses) {
        super(context, 0, expenses);
        this.expenses = expenses;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }
        Expense expense = expenses.get(position);
        TextView expenseName = view.findViewById(R.id.expense_name_edit_text);
        TextView expenseAmount = view.findViewById(R.id.expense_amount_edit_text);
        TextView expenseDate = view.findViewById(R.id.expense_date_edit_text);
        TextView expenseComment = view.findViewById(R.id.expense_comment_edit_text);

        expenseName.setText(expense.getName());
        expenseAmount.setText(expense.getAmount().toString());
        expenseDate.setText(expense.getDate());
        expenseComment.setText(expense.getComment());

        return view;
    }
}
