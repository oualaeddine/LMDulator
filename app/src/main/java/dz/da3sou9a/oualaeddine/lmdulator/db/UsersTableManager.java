package dz.da3sou9a.oualaeddine.lmdulator.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import dz.da3sou9a.oualaeddine.lmdulator.items.User;


/**
 * Created by Ouala eddine on 01/10/2016.
 */

public class UsersTableManager extends DbHandler{


    private static final String
        users_Table_Name="Users_tab",
    //usersTable
        userName="user_name",
        password="password",
        userId="id",
    //create usersTab
    create_Users_Table = "CREATE TABLE \"" + users_Table_Name + "\" ( `" +
            userId + "` INTEGER NOT NULL UNIQUE, `" +
            userName + "` TEXT NOT NULL UNIQUE, `" +
            password + "` TEXT NOT NULL, PRIMARY KEY(`" + userId + "`) )",
    //drop userstab
        users_Table_Drop = "DROP TABLE IF EXISTS " + users_Table_Name + ";";

    public UsersTableManager(Context pContext) {
        super(pContext);
    }

    public static String getCreate_Users_Table() {
        return create_Users_Table;
    }

    public void dropUsersTable(SQLiteDatabase db) {
        db.execSQL(users_Table_Drop);
    }

    public void addUser(User user) {
        open();
        ContentValues value = new ContentValues();
        value.put(userName, user.getUserName());
        value.put(password, user.getPassword());
        open().insert(users_Table_Name, null, value);


        //ou

        open().insert(users_Table_Name, null, value);

    }

/** Todo:check deleteUser method**/
    public void deleteUser(long id) {
            open().delete(users_Table_Name, userId + " = ?", new String[] {String.valueOf(id)});
    }

    public void editUser(User user) {
        ContentValues value = new ContentValues();
        value.put(userName, user.getUserName());
        value.put(password, user.getPassword());
        open().update(users_Table_Name, value, userId  + " = ?", new String[] {String.valueOf(user.getUserId())});
    }

    public Cursor getUserById(int id) {
        Cursor res =  open().rawQuery( "select * from contacts where "+userId+" = "+id+"", null );
        return res;
   }

    public Cursor getUserName(String user_name) {
        Cursor res =  open().rawQuery( "select * from contacts where "+userName+" = "+user_name+"", null );
        return res;
   }
}
