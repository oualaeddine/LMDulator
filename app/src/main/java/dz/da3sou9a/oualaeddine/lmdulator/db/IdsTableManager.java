package dz.da3sou9a.oualaeddine.lmdulator.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Ouala eddine on 08/10/2016.
 */

public class IdsTableManager extends dbManager {

    private static final String

            id_Table_Name = "Gen_tab",

    //GenTable
    unit_id = "unit_id",
            user_id = "user_id",
            year_id = "year_id",
            gen_id = "gen_id",
            module_id = "module_id",
            semester_id = "semester_id",

    //create idTab
    create_id_Table = "create table " + id_Table_Name + " ( " +
            user_id + " INTEGER NOT NULL, " +
            year_id + " INTEGER NOT NULL, " +
            semester_id + " INTEGER NOT NULL, " +
            unit_id + " INTEGER NOT NULL, " +
            module_id + " INTEGER NOT NULL, " +
            gen_id + " INTEGER NOT NULL ) ",

    id_Table_Drop = "DROP TABLE IF EXISTS " + id_Table_Name + ";";

    public IdsTableManager(Context pContext) {
        super(pContext);
    }

    public static String getCreate_Gen_Table() {
        return create_id_Table;
    }

    public void dropidTable(SQLiteDatabase db) {
        db.execSQL(id_Table_Drop);
    }

    public void addGen(String userid, String yearId, String unitId, String moduleId, String genId) {
        open();
        ContentValues value = new ContentValues();
        value.put(user_id, userid);
        value.put(year_id, yearId);
        value.put(unit_id, unitId);
        value.put(module_id, moduleId);
        value.put(gen_id, genId);
        mDb.insert(id_Table_Name, null, value);
    }

    public void deleteid(long id) {
        mDb.delete(id_Table_Name, gen_id + " = ?", new String[]{String.valueOf(id)});
    }

    public Cursor getGenById(int id) {

        close();
        return null;
    }

    public Cursor getGenByYearId(int yearId) {
        Cursor res = open().rawQuery("select * from contacts where " + year_id + " = " + yearId + "", null);
        close();
        return res;
    }
}

