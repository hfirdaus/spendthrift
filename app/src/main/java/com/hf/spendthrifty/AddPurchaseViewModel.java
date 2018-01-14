package com.hf.spendthrifty;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;

/**
 * Created by Hadiya on 2018-01-14.
 */

public class AddPurchaseViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    public AddPurchaseViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getAppDatabase(this.getApplication());

    }

    public void addPurchase(final Purchase purchase) {
        new addAsyncTask(appDatabase).execute(purchase);
    }

    private static class addAsyncTask extends AsyncTask<Purchase, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final Purchase... params) {
            db.PurchaseDao().addPurchase(params[0]);
            return null;
        }

    }
}