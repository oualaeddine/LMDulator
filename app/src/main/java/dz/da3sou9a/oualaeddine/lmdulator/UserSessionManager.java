package dz.da3sou9a.oualaeddine.lmdulator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;


/**
 * Created by berre on 12/1/2016.
 */

public class UserSessionManager {

    SharedPreferences preferences;

    SharedPreferences.Editor editor;

    Context context;

    int PRIVATE_MODE = 0;

    private static final String PREFER_NAME = "default",

                                IS_USER_LOGIN = "IsUserLoggedIn",

                                KEY_NAME = "name",

                                USER_ID = "userId",

                                CURRENT_YEAR_ID="currentYear";

    public UserSessionManager(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(PREFER_NAME,PRIVATE_MODE);
        editor = preferences.edit();
    }

    public void createUserLoginSession(String name,int userId){
        editor.putBoolean(IS_USER_LOGIN,true);

        editor.putString(KEY_NAME,name);

        editor.putInt(USER_ID,userId);

        editor.commit();
    }

    /**public boolean checkLogin(){
        if(!this.isUserLoggedIn()){
            Intent i = new Intent(context, LoginActivity.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(i);

            return true;
        }
        return false;
    }**/

    public HashMap<String,String> getUserDetails(){
        HashMap<String,String> user = new HashMap<>();

        user.put(KEY_NAME,preferences.getString(KEY_NAME,null));
        user.put(USER_ID, String.valueOf(preferences.getInt(USER_ID,0)));

        return user;
    }

    public int getSessionYear(){
        return preferences.getInt(CURRENT_YEAR_ID,0);
    }

   /* public void logoutUser(){

        editor.clear();
        editor.commit();

        Intent intent = new Intent(context,LoginActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }*/

    public void setCurrentYearId(int yId){
        editor.putInt(CURRENT_YEAR_ID,yId);
        editor.commit();
    }
  /**  public boolean isUserLoggedIn() {
        return userLoggedIn;
    }**/
}
