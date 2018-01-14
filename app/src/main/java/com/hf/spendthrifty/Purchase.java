package com.hf.spendthrifty;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

/**
 * Created by Hadiya on 2017-12-28.
 */

@Entity
/*(foreignKeyrrrs = @ForeignKey(entity =  Category.class,
                                            parentColumns = "category_id",
                                            childColumns = "category_id"))*/
public class Purchase {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "purchase_id")
    private int purchaseId;

    @ColumnInfo(name = "amount_cents")
    private int amountCents;

    @TypeConverters(Converter.class)
    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "place")
    private String place;

//    @ColumnInfo(name = "category_id")
//    private int categoryId;

    @ColumnInfo(name = "category")
    private String category;

    public Purchase(int amountCents, Date date, String place, String category) {
        this.amountCents = amountCents;
        this.date = date;
        this.place = place;
        this.category = category;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getAmountCents() {
        return amountCents;
    }

    public void setAmountCents(int amountCents) {
        this.amountCents = amountCents;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
