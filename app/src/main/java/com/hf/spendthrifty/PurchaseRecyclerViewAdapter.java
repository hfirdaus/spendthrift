package com.hf.spendthrifty;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Hadiya on 2017-12-30.
 */

public class PurchaseRecyclerViewAdapter extends RecyclerView.Adapter<PurchaseRecyclerViewAdapter.PurchaseRecyclerViewHolder> {

    private List<Purchase> purchases;
    private View.OnLongClickListener longClickListener;

    public PurchaseRecyclerViewAdapter(List<Purchase> purchases, View.OnLongClickListener longClickListener) {
        this.purchases = purchases;
        this.longClickListener = longClickListener;
    }

    @Override
    public PurchaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PurchaseRecyclerViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final PurchaseRecyclerViewHolder holder, int position) {
        Purchase purchase = purchases.get(position);
//        holder.amountTextView.setText(String.valueOf(purchase.getAmountCents()));
        holder.amountTextView.setText("Dummy amount");
        holder.placeTextView.setText(purchase.getPlace());
        holder.dateTextView.setText(purchase.getDate().toLocaleString().substring(0,11));
        holder.categoryTextView.setText(purchase.getCategory());
        holder.itemView.setTag(purchase);
        holder.itemView.setOnLongClickListener(longClickListener);
    }
    @Override
    public int getItemCount() {
        return purchases.size();
    }

    public void addPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
        notifyDataSetChanged();
    }

    static class PurchaseRecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView amountTextView;
        private TextView placeTextView;
        private TextView dateTextView;
        private TextView categoryTextView;

        PurchaseRecyclerViewHolder(View view) {
            super(view);
            amountTextView = (TextView) view.findViewById(R.id.amountTextView);
            placeTextView = (TextView) view.findViewById(R.id.placeTextView);
            dateTextView = (TextView) view.findViewById(R.id.dateTextView);
            categoryTextView = (TextView) view.findViewById(R.id.categoryTextView);
        }
    }
}
