package dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import dz.da3sou9a.oualaeddine.lmdulator.R;

public class NticActivity extends AppCompatActivity {

    public Button butl1, butl2, butl3, butm1, butm2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        butl1 = (Button) findViewById(R.id.buttonL1);
        butl2 = (Button) findViewById(R.id.buttonL2);
        butl3 = (Button) findViewById(R.id.buttonL3);
        butm1 = (Button) findViewById(R.id.buttonm1);
        butm2 = (Button) findViewById(R.id.buttonm2);

        butl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLauncher();
            }
        });
        butl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLauncher();
            }
        });
        butl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLauncher();
            }
        });
        butm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLauncher();
            }
        });
        butm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLauncher();
            }
        });
    }

    void startLauncher() {
        Class c;
        c = Launcher.class;
        startActivity(new Intent(NticActivity.this, c));
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);

    }
}

