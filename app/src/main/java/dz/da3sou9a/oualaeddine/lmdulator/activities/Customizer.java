package dz.da3sou9a.oualaeddine.lmdulator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;

import dz.da3sou9a.oualaeddine.lmdulator.R;

import static android.view.View.VISIBLE;

public class Customizer extends AppCompatActivity {
    private TableRow modulesList;
    private Button btnSave, btnEditModules;
    private EditText specname,annee,nbrModulesS1,nbrModulesS2,credAnnuelMin,credS1min,credS2min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customizer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        specname=(EditText)findViewById(R.id.SpecName);
        annee=(EditText)findViewById(R.id.textAnnee);

        credAnnuelMin=(EditText)findViewById(R.id.credMinAnnee);
        credS1min=(EditText)findViewById(R.id.credS1min);
        credS2min=(EditText)findViewById(R.id.credS2min);

        btnEditModules = (Button) findViewById(R.id.buttoneditmodule);
        btnEditModules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modulesList = (TableRow) findViewById(R.id.listModules);
                modulesList.setVisibility(VISIBLE);


            }
        });


        btnSave = (Button) findViewById(R.id.btnS);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNotes = new Intent(Customizer.this, Launcher.class);
                //       Semestre s1,s2;Annee year;
                //        s1=new Semestre(1);
                //        s2=new Semestre(2);

//                s1.setSemesterCred(Integer.parseInt(credS1min.getText().toString()));
                //          s2.setSemesterCred(Integer.parseInt(credS2min.getText().toString()));

                //         year = new Annee(annee.getText().toString(),s1,s2);
                //         year.setCred(Integer.parseInt(credAnnuelMin.getText().toString()));

                //          intentNotes.putExtra("year", (Serializable) year);

                startActivity(intentNotes);
            }
        });


    }


}
