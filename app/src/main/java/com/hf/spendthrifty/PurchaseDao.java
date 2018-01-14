package com.hf.spendthrifty;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.Date;
import java.util.List;

/**
 * Created by Hadiya on 2017-12-28.
 */

@Dao
public interface PurchaseDao {

    @Query("SELECT * FROM Purchase")
    LiveData<List<Purchase>> getAllPurchases();

    @Query("SELECT * FROM Purchase where purchase_id = :id")
    Purchase getItemById(String id);

//    @Query("SELECT * FROM purchase WHERE date BETWEEN :from AND :to")
//    List<Purchase> getAllPurchasesBetweenInclusive(Date from, Date to);

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    long[] insertAllPurchases(Purchase... purchases);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addPurchase(Purchase purchase);

    @Delete
    void deletePurchase(Purchase purchase);

//    @Update
//    void updatePurchase(Purchase purchase);
}
