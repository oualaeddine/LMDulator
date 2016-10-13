package dz.da3sou9a.oualaeddine.lmdulator.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;


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
            semester = "semester",
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
            coef = "coef",

    //create NotesTab
    create_Note_Table = "CREATE TABLE \"" + notes_Table_Name + "\" ( " +
            "`" + module_id + "` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
            "`" + userId + "` INTEGER NOT NULL, " +
            "`" + year_id + "` INTEGER NOT NULL, " +
            "`" + semester + "` INTEGER NOT NULL, " +
            "`" + unit_id + "` INTEGER NOT NULL, " +
            "`" + module_name + "` TEXT NOT NULL, " +
            "`" + coef + "` INTEGER NOT NULL, " +
            "`" + cred_default + "` INTEGER NOT NULL, " +
            "`" + is_td_true + "` INTEGER NOT NULL, " +
            "`" + is_tp_true + "` INTEGER NOT NULL, " +
            "`" + note_controle + "` REAL, " +
            "`" + note_tp + "` REAL, " +
            "`" + note_td + "` REAL ) ",

        module_Table_Drop = "DROP TABLE IF EXISTS " + notes_Table_Name + ";";

    public ModulesTableManager(Context pContext) {
        super(pContext);
    }

    public static String getCreate_Note_Table() {
        return create_Note_Table;
    }

    public void dropModuleTable(SQLiteDatabase db) {
        db.execSQL(module_Table_Drop);
    }

    public void addModule(ModuleG module) {
        open();
        ContentValues value = new ContentValues();
        value.put(userId, module.getUserId());
        value.put(year_id, module.getYearId());
        value.put(unit_id, module.getUnitId());
        value.put(semester, module.getSemester());
            value.put(module_name, module.getModuleName());
        value.put(cred_default, module.getDefCred());
            value.put(is_td_true, module.isTpState());
            value.put(is_tp_true, module.isTdState());
        value.put(note_td, module.getTd());
            value.put(note_tp, module.getTp());
            value.put(note_controle, module.getCont());
        mDb.insert(notes_Table_Name, null, value);
        close();
    }

    public void deleteModule(long id) {
                 mDb.delete(notes_Table_Name, module_id + " = ?", new String[] {String.valueOf(id)});
                 close();
    }

    public void editModule(ModuleG module) {
        ContentValues value = new ContentValues();
        value.put(unit_id, module.getUnitId());
        value.put(semester, module.getSemester());
            value.put(module_name, module.getModuleName());
            value.put(cred_default, module.getDefCred());
        value.put(is_td_true, module.isTpState());
        value.put(is_tp_true, module.isTdState());
        value.put(note_td, module.getTd());
            value.put(note_tp, module.getTp());
            value.put(note_controle, module.getCont());
        mDb.update(notes_Table_Name, value, module_id  + " = ?", new String[] {String.valueOf(module.getId())});
        close();
    }

    /**TODO: fill the moethod**/

    public List<ModuleG> getModules(int userid, int yearid)
    {
        List<ModuleG> modulesList = new LinkedList<>();
        Cursor cursor = open().rawQuery("select * from " + notes_Table_Name + " where " + year_id + " = '" + yearid + "' AND " + userId + " = '" + userid + "'", null);
        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
        {
            String _moduleName = cursor.getString(cursor.getColumnIndex(module_name));
            boolean _is_tp_true, _is_td_true, _cred;
            int _is_tp = Integer.valueOf(cursor.getString(cursor.getColumnIndex(is_tp_true)));
            _is_tp_true = _is_tp == 1;
            int _is_td = Integer.valueOf(cursor.getString(cursor.getColumnIndex(is_td_true)));
            _is_td_true = _is_td == 1;

            int _semester = Integer.valueOf(cursor.getString(cursor.getColumnIndex(semester)));
            int _unit_id = Integer.valueOf(cursor.getString(cursor.getColumnIndex(unit_id)));
            int _userId = Integer.valueOf(cursor.getString(cursor.getColumnIndex(userId)));
            int _year_id = Integer.valueOf(cursor.getString(cursor.getColumnIndex(year_id)));
            int _coef = Integer.valueOf(cursor.getString(cursor.getColumnIndex(coef)));
            int _cred_def = Integer.valueOf(cursor.getString(cursor.getColumnIndex(cred_default)));
            int _credState = Integer.valueOf(cursor.getString(cursor.getColumnIndex(module_cred)));
            _cred = _credState == 1;
            int _module_id = Integer.valueOf(cursor.getString(cursor.getColumnIndex(module_id)));

            double _note_tp = Double.parseDouble(cursor.getString(cursor.getColumnIndex(note_tp)));
            double _note_td = Double.parseDouble(cursor.getString(cursor.getColumnIndex(note_td)));
            double _note_controle = Double.parseDouble(cursor.getString(cursor.getColumnIndex(note_controle)));
            double _module_moy = Double.parseDouble(cursor.getString(cursor.getColumnIndex(module_moy)));

            ModuleG newModule = new ModuleG(_is_tp_true, _is_td_true, _cred, _note_controle, _note_tp, _module_moy, _note_td, _coef, _userId, _unit_id, _year_id, _semester, _module_id, _cred_def, _moduleName);

            modulesList.add(newModule);
        }
        cursor.close();
        close();
        return modulesList;
    }
}
