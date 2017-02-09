package dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.UserSessionManager;
import dz.da3sou9a.oualaeddine.lmdulator.activities.login.LoginMain;
import dz.da3sou9a.oualaeddine.lmdulator.activities.login.SignupActivity;
import dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi.dashboard.Dashboard;

public class Loader extends AppCompatActivity {

    //Button login, sign_up;
    Intent intent;
    Button btnGo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);
        btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserSessionManager userSessionManager = new UserSessionManager(Loader.this);
                userSessionManager.createUserLoginSession("default", 1);
                intent = new Intent(Loader.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
/**
 * login = (Button) findViewById(R.id.button3);
 * sign_up = (Button) findViewById(R.id.button4);
 * <p>
 * login.setVisibility(View.GONE);
 * sign_up.setVisibility(View.GONE);
 * <p>
 * login.setVisibility(View.VISIBLE);
 * sign_up.setVisibility(View.VISIBLE);
 * <p>
 * login.setOnClickListener(new View.OnClickListener() {
 *
 * @Override public void onClick(View view) {
 * intent = new Intent(getApplicationContext(), LoginMain.class);
 * startActivity(intent);
 * finish();
 * }
 * });
 * sign_up.setOnClickListener(new View.OnClickListener() {
 * @Override public void onClick(View view) {
 * intent = new Intent(getApplicationContext(), SignupActivity.class);
 * startActivity(intent);
 * finish();
 * }
 * });
 */