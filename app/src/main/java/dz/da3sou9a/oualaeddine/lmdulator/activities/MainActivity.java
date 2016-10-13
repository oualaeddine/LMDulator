package dz.da3sou9a.oualaeddine.lmdulator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import dz.da3sou9a.oualaeddine.lmdulator.R;

public class MainActivity extends AppCompatActivity {

    public Button butl1, butl2, butl3, butm1, butm2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initL1();
    }

    public void initL1()
    {
        butl1 =(Button) findViewById(R.id.buttonL1);
        butl2 =(Button) findViewById(R.id.buttonL2);
        butl3 =(Button) findViewById(R.id.buttonL3);
        butm1 =(Button) findViewById(R.id.buttonm1);
        butm2 =(Button) findViewById(R.id.buttonm2);

        butl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentl1 = new Intent(MainActivity.this, Launcher.class);
                startActivity(intentl1);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
        butl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentl2 = new Intent(MainActivity.this, Launcher.class);
                startActivity(intentl2);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
        butl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentl3 = new Intent(MainActivity.this, Launcher.class);
                startActivity(intentl3);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
        butm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentm1 = new Intent(MainActivity.this, Launcher.class);
                startActivity(intentm1);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
        butm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentm2 = new Intent(MainActivity.this, Launcher.class);
                startActivity(intentm2);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });


    }
}

