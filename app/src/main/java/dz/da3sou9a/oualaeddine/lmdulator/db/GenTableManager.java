package dz.da3sou9a.oualaeddine.lmdulator.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import dz.da3sou9a.oualaeddine.lmdulator.items.Gen;
import dz.da3sou9a.oualaeddine.lmdulator.items.User;

/**
 * Created by Ouala eddine on 01/10/2016.
 */

public class GenTableManager extends dbManager{

    private static final String

    gen_Table_Name="Gen_tab",

    //GenTable
    year_moy = "year_moy",
    cred_year = "cred_year",
    userId="id",
    year_id="year_id",
    gen_id = "gen_id",

    //create GenTab
    create_Gen_Table = "create table "+gen_Table_Name+" ( "+
        userId+" INT NOT NULL, "+
        year_id+" INT NOT NULL, "+
        year_moy+" REAL, "+
        cred_year+" INT, "+
        gen_id+" INTEGER PRIMARY KEY AUTOINCREMENT) ",

        gen_Table_Drop = "DROP TABLE IF EXISTS " + gen_Table_Name + ";";

    public GenTableManager(Context pContext) {
        super(pContext);
    }

    public void dropGenTable(SQLiteDatabase db) {
        db.execSQL(gen_Table_Drop);
    }
    public void addGen(String user_id,String yearId,String yearMoy,String credYear) {
        open();
        ContentValues value = new ContentValues();
            value.put(userId, user_id);
            value.put(year_id, yearId);
            value.put(year_moy, yearMoy);
            value.put(cred_year, credYear);
        mDb.insert(gen_Table_Name, null, value);
    }

    public void deleteGen(long id) {
         mDb.delete(gen_Table_Name, gen_id + " = ?", new String[] {String.valueOf(id)});
    }

    public void editGen(Gen gen,User user) {
        ContentValues value = new ContentValues();
            value.put(userId, user.getUserId());
          // TODO: value.put(year_id, );
            value.put(year_moy, gen.getYearMoy());
            value.put(cred_year, gen.getYearCred());
        mDb.update(gen_Table_Name, value, gen_id  + " = ?", new String[] {String.valueOf(gen.getGenId())});
        close();
    }
    public Cursor getGenById(int id){
        Cursor res =  open().rawQuery( "select * from contacts where "+userId+" = "+id+"", null );
        close();
        return res;
   }
    public Cursor getGenByYearId(int yearId){
        Cursor res =  open().rawQuery( "select * from contacts where "+year_id+" = "+yearId+"", null );
        close();
        return res;
   }

    public static String getCreate_Gen_Table() {
        return create_Gen_Table;
    }
}
