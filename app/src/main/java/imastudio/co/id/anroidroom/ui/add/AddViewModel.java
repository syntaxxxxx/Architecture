package imastudio.co.id.anroidroom.ui.add;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import imastudio.co.id.anroidroom.db.DbApp;
import imastudio.co.id.anroidroom.db.model.ModelPeserta;

/**
 * Created by macbook on 3/9/18.
 */

public class AddViewModel extends AndroidViewModel {
    //TODO Call DBAPP
    private DbApp db;

    public AddViewModel(@NonNull Application application) {
        super(application);
        //TODO Panggil Database
        db = DbApp.getDatabase(this.getApplication());
    }

    public void addPeserta(ModelPeserta modelPeserta) {
        new addAsyncTask(db).execute(modelPeserta);
    }

    private class addAsyncTask extends AsyncTask<ModelPeserta, Void, Void> {
        private DbApp db;

        public addAsyncTask(DbApp db) {
            this.db = db;
        }

        @Override
        protected Void doInBackground(ModelPeserta... userModels) {
            db.itemAndPesertaModel().addPeserta(userModels[0]);
            return null;
        }
    }
}

