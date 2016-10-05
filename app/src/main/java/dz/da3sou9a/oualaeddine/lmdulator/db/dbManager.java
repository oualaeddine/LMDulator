package dz.da3sou9a.oualaeddine.lmdulator.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Ouala eddine on 01/10/2016.
 */

public class dbManager {

        protected SQLiteDatabase mDb = null;
        protected DbHandler mHandler = null;

        public dbManager(Context pContext) {
            this.mHandler = new DbHandler(pContext);
        }

        public SQLiteDatabase open() {
            mDb = mHandler.getWritableDatabase();
            return mDb;
        }

        public void close() {
            mDb.close();
        }

        public SQLiteDatabase getDb() {
            return mDb;
        }
}


