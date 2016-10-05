package dz.da3sou9a.oualaeddine.lmdulator.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

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
        initL1();

    }

    public void initL1() {
        Button butmias = (Button) findViewById(R.id.butmias);
        Button butautre = (Button) findViewById(R.id.butautre);


        assert butmias != null;
        butmias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentl1 = new Intent(FirstTimeSetup.this, MainActivity.class);
                startActivity(intentl1);
            }
        });
        assert butautre != null;
        butautre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentl2 = new Intent(FirstTimeSetup.this, Customizer.class);
                startActivity(intentl2);
            }
        });

    }
}
