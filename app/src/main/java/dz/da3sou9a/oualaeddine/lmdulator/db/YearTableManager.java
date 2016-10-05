package dz.da3sou9a.oualaeddine.lmdulator.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import dz.da3sou9a.oualaeddine.lmdulator.items.Annee;
import dz.da3sou9a.oualaeddine.lmdulator.items.User;


/**
 * Created by Ouala eddine on 01/10/2016.
 */

public class YearTableManager extends dbManager{
    private static final String
    Annee_Table_Name="Annee_tab",
    //AnneeTable
    spec_name="spec_name",
    anneName="year_name",
    year_id="year_id",
    cred_min_annee="cred_min_year",
    cred_min_s1="cred_min_s1",
    cred_min_s2="cred_min_s2",
    userId="id",

    //create YearTab
    create_Year_Table = "create table "+Annee_Table_Name+" ("+
    year_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
    spec_name+" TEXT NOT NULL, "+
    anneName+" TEXT NOT NULL, "+
    cred_min_annee+" INT NOT NULL, "+
    cred_min_s1+" INT NOT NULL, "+
    cred_min_s2+" INT NOT NULL, "+
    userId+" INT NOT NULL) ",
    //drop yeartab
    year_Table_Drop = "DROP TABLE IF EXISTS " + Annee_Table_Name + ";";

    public YearTableManager(Context pContext) {
        super(pContext);
    }

    public void dropUsersTable(SQLiteDatabase db) {
        db.execSQL(year_Table_Drop);
    }
    public void addYear(Annee annee, User user) {
        open();
        ContentValues value = new ContentValues();
            value.put(userId, user.getUserId());
            value.put(spec_name, annee.getSpecName());
            value.put(anneName, annee.getAnneeName());
            value.put(cred_min_annee, annee.getCredMinAnnee());
            value.put(cred_min_s1, annee.getCredMinS1());
            value.put(cred_min_s2, annee.getCredMinS2());
        mDb.insert(Annee_Table_Name, null, value);
    }

    public void deleteYear(long id) {
         mDb.delete(Annee_Table_Name, year_id + " = ?", new String[] {String.valueOf(id)});
    }

    public void editYear(Annee annee) {
        ContentValues value = new ContentValues();
            value.put(spec_name, annee.getSpecName());
            value.put(anneName, annee.getAnneeName());
            value.put(cred_min_annee, annee.getCredMinAnnee());
            value.put(cred_min_s1, annee.getCredMinS1());
            value.put(cred_min_s2, annee.getCredMinS2());
        mDb.update(Annee_Table_Name, value, year_id  + " = ?", new String[] {String.valueOf(annee.getYearId())});

    }

    public Annee selectYear() {

        return null;
    }
     public Cursor getYearById(int id){
        Cursor res =  open().rawQuery( "select * from contacts where "+year_id+" = "+id+"", null );
        return res;
   }
      public Cursor getYearBySpecName(int specName){
        Cursor res =  open().rawQuery( "select * from contacts where "+spec_name+" = "+specName+"", null );
        return res;
   }
       public Cursor getGen(int yearId){
        Cursor res =  open().rawQuery( "select * from contacts where "+year_id+" = "+yearId+"", null );
        return res;
   }

    public static String getCreate_Year_Table() {
        return create_Year_Table;
    }
}
