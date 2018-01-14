package com.hf.spendthrifty;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    private PurchasesListViewModel purchasesListViewModel;
    private PurchaseRecyclerViewAdapter purchaseRecyclerViewAdapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddPurchaseActivity.class));
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        purchaseRecyclerViewAdapter = new PurchaseRecyclerViewAdapter(new ArrayList<Purchase>(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(purchaseRecyclerViewAdapter);

        purchasesListViewModel = ViewModelProviders.of(this).get(PurchasesListViewModel.class);
        purchasesListViewModel.getPurchases().observe(MainActivity.this, new Observer<List<Purchase>>() {
            @Override
            public void onChanged(@Nullable List<Purchase> purchaseList) {
                purchaseRecyclerViewAdapter.addPurchases(purchaseList);
            }
        });
    }

    @Override
    public boolean onLongClick(View view) {
        Purchase purchase = (Purchase) view.getTag();
        purchasesListViewModel.deletePurchase(purchase);
        return true;
    }
}
