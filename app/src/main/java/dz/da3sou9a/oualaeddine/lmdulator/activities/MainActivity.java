package dz.da3sou9a.oualaeddine.lmdulator.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dz.da3sou9a.oualaeddine.lmdulator.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initL1();
    }

    public Button butl1,butl2,butl3,butm1,butm2;
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
                Intent intentl1 = new Intent(MainActivity.this,NotesTable.class);
                startActivity(intentl1);
            }
        });
        butl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentl2 = new Intent(MainActivity.this, NotesTable.class);
                startActivity(intentl2);
            }
        });
        butl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentl3 = new Intent(MainActivity.this,NotesTable.class);
                startActivity(intentl3);
            }
        });
        butm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentm1 = new Intent(MainActivity.this,NotesTable.class);
                startActivity(intentm1);
            }
        });
        butm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentm2 = new Intent(MainActivity.this,NotesTable.class);
                startActivity(intentm2);
            }
        });


    }
}

