package dz.da3sou9a.oualaeddine.lmdulator.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
        try {
            db.execSQL(ModulesTableManager.getCreate_Note_Table());
            Log.e("db","notes db created");
        } catch (Exception e) {
            Log.e("create modules tab", e.toString());
            Log.e("create modules tab", e.getMessage());
            Log.e("create modules tab", String.valueOf(e.getCause()));
        }
        db.execSQL(GenTableManager.getCreate_Gen_Table());
        db.execSQL(UnitsTableManager.getCreate_Units_Table());
        db.execSQL(UsersTableManager.getCreate_Users_Table());
        db.execSQL(YearTableManager.getCreate_Year_Table());
    }
    public SQLiteDatabase open() {
        return this.getWritableDatabase();
    }
    public String getDb_NAME() {
        return db_NAME;
    }
}
