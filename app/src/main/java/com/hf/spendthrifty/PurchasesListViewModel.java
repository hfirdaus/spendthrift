package com.hf.spendthrifty;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Hadiya on 2017-12-30.
 */

public class PurchasesListViewModel extends AndroidViewModel {

    private final LiveData<List<Purchase>> purchases;

    private AppDatabase appDatabase;

    public PurchasesListViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getAppDatabase(this.getApplication());

        purchases = appDatabase.PurchaseDao().getAllPurchases();
    }

    public LiveData<List<Purchase>> getPurchases() {
        return purchases;
    }

    public void deletePurchase(Purchase purchase) {
        new deleteAsyncTask(appDatabase).execute(purchase);
    }

    private static class deleteAsyncTask extends AsyncTask<Purchase, Void, Void> {

        private AppDatabase db;

        deleteAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(Purchase... purchases) {
            db.PurchaseDao().deletePurchase(purchases[0]);
            return null;
        }
    }
}
