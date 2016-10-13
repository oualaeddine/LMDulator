package dz.da3sou9a.oualaeddine.lmdulator.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.Toast;

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.activities.frags.ModuleCustomizePopup;
import dz.da3sou9a.oualaeddine.lmdulator.activities.modulesList.ModulesListAdapter;
import dz.da3sou9a.oualaeddine.lmdulator.activities.modulesList.ModulesListContent;
import dz.da3sou9a.oualaeddine.lmdulator.db.ModulesTableManager;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;

import static android.view.View.VISIBLE;

public class Customizer extends AppCompatActivity {
    private TableRow modulesList;
    private Button btnSave, btnEditModules;
    private EditText specname, annee, nbrUnitsS1, nbrUnitsS2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customizer);

        /**  Using RecyclerView **/

        RecyclerView recyclerView;
        final ModulesListAdapter modulesListAdapter;

        SharedPreferences preferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        final int loggedUserId = preferences.getInt("userId", 99);
        String loggedUserName = preferences.getString("userName", "noUser");
        int currentYear = 1;
        Toast.makeText(getBaseContext(), "userId:" + loggedUserId + "  username:" + loggedUserName, Toast.LENGTH_LONG).show();

        recyclerView = (RecyclerView) findViewById(R.id.modules_list_rec);
        //LayoutManager LinearLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ModulesTableManager db = new ModulesTableManager(this);
        modulesListAdapter = new ModulesListAdapter(ModulesListContent.getModulesList(db, loggedUserId, currentYear), this);
        recyclerView.setAdapter(modulesListAdapter);

        /** end using recyclerView**/
        /**
         final int loggedUserId = (int) getIntent().getSerializableExtra("loggedUserId");
         final String loggedUserName = (String) getIntent().getSerializableExtra("loggedUserName");
         **/

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
        nbrUnitsS1 = (EditText) findViewById(R.id.nbrUnitS1);
        nbrUnitsS2 = (EditText) findViewById(R.id.nbrUnitS2);

        btnEditModules = (Button) findViewById(R.id.buttoneditmodule);
        btnEditModules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                modulesList = (TableRow) findViewById(R.id.listModules);
                if (modulesList.getVisibility() == VISIBLE) {
                    modulesList.setVisibility(View.GONE);
                } else {
                    modulesList.setVisibility(VISIBLE);
                }
            }
        });

        btnSave = (Button) findViewById(R.id.btnS);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNotes = new Intent(Customizer.this, Launcher.class);
/**
 intentNotes.putExtra("userId", loggedUserId);
 intentNotes.putExtra("loggedUserName", loggedUserName);
 **/
                startActivity(intentNotes);


                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

        final EditText content = (EditText) findViewById(R.id.content);
        final ImageButton addModule = (ImageButton) findViewById(R.id.imageButtonAddModule);

        addModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModuleG newModule = new ModuleG(content.getText().toString());
                newModule.setUserId(loggedUserId);
                //modulesListAdapter.listData.add(newModule);
                //modulesListAdapter.notifyItemInserted(modulesListAdapter.listData.size() - 1);
                FragmentTransaction manager = getSupportFragmentManager().beginTransaction();
                ModuleCustomizePopup popup = new ModuleCustomizePopup();
                popup.setModule(newModule);
                popup.show(manager, null);
            }
        });
    }
/**
 public void addModuleToRecycler(ModuleG module) {
 ModulesListAdapter modulesListAdapter = new ModulesListAdapter(ModulesListContent.getModulesList(), this);
 modulesListAdapter.listData.add(module);
 Log.e("e","inside addModuleToRecycler");
 modulesListAdapter.notifyItemInserted(modulesListAdapter.listData.size() - 1);
 }
 **/
}
