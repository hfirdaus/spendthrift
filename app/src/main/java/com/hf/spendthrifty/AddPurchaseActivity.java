package com.hf.spendthrifty;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Hadiya on 2018-01-13.
 */

public class AddPurchaseActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private Date date;
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;

    private EditText amountEditText;
    private EditText placeEditText;
    private EditText categoryEditText;

    private AddPurchaseViewModel addPurchaseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_purchase);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        amountEditText = findViewById(R.id.amount);
        placeEditText = findViewById(R.id.place);
        categoryEditText = findViewById(R.id.category);

        calendar = Calendar.getInstance();
        addPurchaseViewModel = ViewModelProviders.of(this).get(AddPurchaseViewModel.class);

        datePickerDialog = new DatePickerDialog(this, AddPurchaseActivity.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (amountEditText.getText() == null ||
                        placeEditText.getText() == null ||
                        categoryEditText.getText() == null ||
                        date == null)
                    Toast.makeText(AddPurchaseActivity.this, "Missing fields", Toast.LENGTH_SHORT).show();
                else {
                    addPurchaseViewModel.addPurchase(new Purchase(
                            Integer.parseInt(amountEditText.getText().toString()),
                            date,
                            placeEditText.getText().toString(),
                            categoryEditText.getText().toString()
                    ));
                    finish();
                }
            }
        });


        findViewById(R.id.dateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        date = calendar.getTime();
    }


}