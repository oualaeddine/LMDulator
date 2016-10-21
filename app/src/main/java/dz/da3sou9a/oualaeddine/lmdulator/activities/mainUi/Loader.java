package dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.activities.login.LoginMain;
import dz.da3sou9a.oualaeddine.lmdulator.activities.login.SignupActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Loader extends AppCompatActivity {

    Button login, sign_up;
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        login = (Button) findViewById(R.id.button3);
        sign_up = (Button) findViewById(R.id.button4);

        login.setVisibility(View.GONE);
        sign_up.setVisibility(View.GONE);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(9000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        login.setVisibility(View.VISIBLE);
        sign_up.setVisibility(View.VISIBLE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), LoginMain.class);
                startActivity(intent);
                finish();
            }
        });
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
