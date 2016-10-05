package dz.da3sou9a.oualaeddine.lmdulator.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import dz.da3sou9a.oualaeddine.lmdulator.items.Unit;
import dz.da3sou9a.oualaeddine.lmdulator.items.User;


/**
 * Created by Ouala eddine on 01/10/2016.
 */

public class UnitsTableManager extends dbManager{

    private static final String
    units_Table_Name="Units_Tab",
    //UnitsTable
        unit_name = "unit_name",
        cred_unit = "cred_unit",
        unit_id = "unit_id",
        unit_moy = "unit_moy",
        userId="id",
        year_id="year_id",
    //create UnitsTable
    create_Units_Table = "create table "+units_Table_Name+" ( "+
        unit_name+" TEXT NOT NULL, "+
        unit_id+" INT NOT NULL AUTOINCREMENT, "+
        cred_unit+" INT, "+
        unit_moy+" REAL, "+
        year_id+" INT NOT NULL, "+
        userId+" INT NOT NULL) ",
    //drop unitTab
        units_Table_Drop = "DROP TABLE IF EXISTS " + units_Table_Name + ";";

    public UnitsTableManager(Context pContext) {
        super(pContext);
    }

    public void dropUnitsTable(SQLiteDatabase db) {
        db.execSQL(units_Table_Drop);
    }
    public void addUnit(Unit unit, User user) {
        open();
        ContentValues value = new ContentValues();
            value.put(userId, user.getUserId());
           /// value.put(year_id, /**TODO:find a way to sync year,module,user IDs**/);
            value.put(unit_name,unit.getUnitName());
            value.put(cred_unit,unit.getUnitCred());
            value.put(unit_moy,unit.getUnitMoy());
        mDb.insert(units_Table_Name, null, value);
    }

    public void deleteUnit(long id) {
         mDb.delete(units_Table_Name, unit_id + " = ?", new String[] {String.valueOf(id)});
    }

    public void editUnit(Unit unit) {
        ContentValues value = new ContentValues();
            value.put(unit_name,unit.getUnitName());
            value.put(cred_unit,unit.getUnitCred());
            value.put(unit_moy,unit.getUnitMoy());
        mDb.update(units_Table_Name, value, userId  + " = ?", new String[] {String.valueOf(unit.getUnitId())});
    }
    /**TODO: fill the moethod**/
    public void getUnits(int userName){

        Cursor cursor = null;
        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
        {

        }
        cursor.close();
      }

    public static String getCreate_Units_Table() {
        return create_Units_Table;
    }
}
