package dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.UserSessionManager;
import dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi.dashboard.Dashboard;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FirstTimeSetup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time_setup);

        Button butmias = (Button) findViewById(R.id.butmias);
        Button butautre = (Button) findViewById(R.id.butautre);

        butmias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentl1 = new Intent(FirstTimeSetup.this, Dashboard.class);
                startActivity(intentl1);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
        butautre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentl2 = new Intent(FirstTimeSetup.this, Dashboard.class);
                startActivity(intentl2);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
