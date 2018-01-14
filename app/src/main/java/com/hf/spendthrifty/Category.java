package com.hf.spendthrifty;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Hadiya on 2017-12-28.
 */

@Entity
public class Category {

    @PrimaryKey(autoGenerate = true)
    private int category_id;

    @ColumnInfo(name = "category")
    private String category;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
