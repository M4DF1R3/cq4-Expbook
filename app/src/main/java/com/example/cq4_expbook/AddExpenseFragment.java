package com.example.cq4_expbook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class AddExpenseFragment extends DialogFragment {
    private EditText expenseName;
    private EditText expenseDate;
    private EditText expenseAmount;
    private EditText expenseComment;
    private onFragmentInteractionListener listener;
    private Expense currentlyEditExpense;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    public interface onFragmentInteractionListener {
        void onOkPressed(Expense expense);
    }

    public void editExpense (Expense expense) {
        this.currentlyEditExpense = expense;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.add_expense_fragment_layout, null);

        expenseName = view.findViewById(R.id.expense_name_edit_text);
        expenseDate = view.findViewById(R.id.expense_date_edit_text);
        expenseAmount = view.findViewById(R.id.expense_amount_edit_text);
        expenseComment = view.findViewById(R.id.expense_comment_edit_text);

        if (currentlyEditExpense != null) {
            expenseName.setText(currentlyEditExpense.getName());
            expenseAmount.setText(currentlyEditExpense.getAmount().toString());
            expenseDate.setText(currentlyEditExpense.getDate());
            expenseComment.setText(currentlyEditExpense.getComment());
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        return builder
                .setView(view)
                .setTitle("Add/Edit Expense")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (currentlyEditExpense != null) {
                            // Edit Expense
                            currentlyEditExpense.setName(expenseName.getText().toString());
                            currentlyEditExpense.setDate(expenseDate.getText().toString());
                            currentlyEditExpense.setAmount(Float.parseFloat(expenseAmount.getText().toString()));
                            currentlyEditExpense.setComment(expenseComment.getText().toString());
                        } else {
                            // Add Expense

                            String name = expenseName.getText().toString();
                            String date = expenseDate.getText().toString();
                            Float amount = Float.parseFloat(expenseAmount.getText().toString());
                            String comment = expenseComment.getText().toString();
                            System.out.println(name);
                            System.out.println(date);
                            System.out.println(comment);
                            System.out.println(amount);


                            listener.onOkPressed(new Expense(name, date, amount, comment));
                        }
                    }
                }).create();
    }
}
