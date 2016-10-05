package dz.da3sou9a.oualaeddine.lmdulator.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;
import dz.da3sou9a.oualaeddine.lmdulator.items.User;


/**
 * Created by Ouala eddine on 01/10/2016.
 */

public class ModulesTableManager extends dbManager{

    private static final String

    notes_Table_Name="Notes_tab",

    //NotesTable
        module_name="module_name",
        is_tp_true="bool_tp",
        is_td_true="bool_td",
        module_unit="unit",
        note_tp="tp",
        note_td="td",
        note_controle="cont",
        cred_default="cred_default",
        module_cred="cred",
        module_moy="moyenne",
        module_id="module_id",
        unit_id = "unit_id",
        userId="id",
        year_id="year_id",

    //create NotesTab
    create_Note_Table = "create table "+notes_Table_Name+" ("+
        userId+" INT NOT NULL, "+
        module_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
        module_name+" TEXT NOT NULL, "+
        is_td_true+" INT NOT NULL, "+
        is_tp_true+" INT NOT NULL, "+
        unit_id+" INT NOT NULL, "+
        note_td+" REAL, "+
        note_tp+" REAL, "+
        note_controle+" REAL, "+
        cred_default+" INT NOT NULL, "+
        module_cred+" INT, "+
        module_moy+" REAL, " +
        year_id+" INT NOT NULL) ",

        module_Table_Drop = "DROP TABLE IF EXISTS " + notes_Table_Name + ";";

    public ModulesTableManager(Context pContext) {
        super(pContext);
    }

    public void dropModuleTable(SQLiteDatabase db) {
        db.execSQL(module_Table_Drop);
    }
    public void addModule(ModuleG module, User user) {
        open();
        ContentValues value = new ContentValues();
            value.put(userId, user.getUserId());
          //  value.put(year_id, /**TODO:find a way to sync year,module,user IDs**/());
            //value.put(unit_id, /**TODO:find a way to sync year,module,user IDs**/());
            value.put(module_name, module.getModuleName());
            value.put(is_td_true, module.isTpState());
            value.put(is_tp_true, module.isTdState());
            value.put(cred_default, module.getDefCred());
            value.put(note_td, module.getTd() );
            value.put(note_tp, module.getTp());
            value.put(note_controle, module.getCont());
            value.put(module_cred, module.getCred());
            value.put(module_moy, module.getMoy());
        mDb.insert(notes_Table_Name, null, value);
        close();
    }

    public void deleteModule(long id) {
                 mDb.delete(notes_Table_Name, module_id + " = ?", new String[] {String.valueOf(id)});
                 close();
    }

    public void editModule(ModuleG module) {
        ContentValues value = new ContentValues();
            value.put(module_name, module.getModuleName());
            value.put(is_td_true, module.isTdState());
            value.put(is_tp_true, module.isTpState());
            value.put(cred_default, module.getDefCred());
            value.put(note_td, module.getTd() );
            value.put(note_tp, module.getTp());
            value.put(note_controle, module.getCont());
            value.put(module_cred, module.getCred());
            value.put(module_moy, module.getMoy());
        mDb.update(notes_Table_Name, value, module_id  + " = ?", new String[] {String.valueOf(module.getId())});
        close();
    }
        /**TODO: fill the moethod**/

    public void getModules(int year_id)
    {
        Cursor cursor = null;

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
        {

        }
        cursor.close();
        close();
      }

    public static String getCreate_Note_Table() {
        return create_Note_Table;
    }
}
