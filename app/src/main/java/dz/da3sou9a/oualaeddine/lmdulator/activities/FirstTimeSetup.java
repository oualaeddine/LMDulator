package dz.da3sou9a.oualaeddine.lmdulator.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import dz.da3sou9a.oualaeddine.lmdulator.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FirstTimeSetup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time_setup);

        //   final Serializable loggedUserId =  getIntent().getSerializableExtra("loggedUserId");
        //  final Serializable loggedUserName =  getIntent().getSerializableExtra("loggedUserName");
        SharedPreferences preferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        int loggedUserId = preferences.getInt("userId", 99);
        String loggedUserName = preferences.getString("userName", "noUser");
        Toast.makeText(getBaseContext(), "userId:" + loggedUserId + "  username:" + loggedUserName, Toast.LENGTH_LONG).show();

        Button butmias = (Button) findViewById(R.id.butmias);
        Button butautre = (Button) findViewById(R.id.butautre);


        assert butmias != null;
        butmias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentl1 = new Intent(FirstTimeSetup.this, MainActivity.class);
                //     intentl1.putExtra("userId", loggedUserId);
                //    intentl1.putExtra("loggedUserName", loggedUserName);
                startActivity(intentl1);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
        assert butautre != null;
        butautre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentl2 = new Intent(FirstTimeSetup.this, Customizer.class);
                //  intentl2.putExtra("userId", loggedUserId);
                //intentl2.putExtra("loggedUserName", loggedUserName);
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
