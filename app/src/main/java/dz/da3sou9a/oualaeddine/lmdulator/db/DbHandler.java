package dz.da3sou9a.oualaeddine.lmdulator.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ouala eddine on 29/09/2016.
 */

public class DbHandler extends SQLiteOpenHelper{

     private static final String
             db_NAME = "vort3x.db";

    public DbHandler(Context context) {
        super(context, db_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        createTables(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createTables (SQLiteDatabase db) {
        db.execSQL(ModulesTableManager.getCreate_Note_Table());
        db.execSQL(GenTableManager.getCreate_Gen_Table());
        db.execSQL(UnitsTableManager.getCreate_Units_Table());
        db.execSQL(UsersTableManager.getCreate_Users_Table());
        db.execSQL(YearTableManager.getCreate_Year_Table());
    }
    public SQLiteDatabase open() {
       SQLiteDatabase mdb = this.getWritableDatabase();
        return mdb;
    }
    public String getDb_NAME() {
        return db_NAME;
    }
}
