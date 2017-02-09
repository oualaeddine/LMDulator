package dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.UserSessionManager;
import dz.da3sou9a.oualaeddine.lmdulator.activities.frags.ModuleCustomizePopup;
import dz.da3sou9a.oualaeddine.lmdulator.activities.modulesList.ModulesListAdapter;
import dz.da3sou9a.oualaeddine.lmdulator.activities.modulesList.ModulesListContent;
import dz.da3sou9a.oualaeddine.lmdulator.db.GenTableManager;
import dz.da3sou9a.oualaeddine.lmdulator.db.ModulesTableManager;
import dz.da3sou9a.oualaeddine.lmdulator.db.YearTableManager;
import dz.da3sou9a.oualaeddine.lmdulator.items.Annee;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;
import dz.da3sou9a.oualaeddine.lmdulator.items.Semestre;
import dz.da3sou9a.oualaeddine.lmdulator.items.User;

import static android.view.View.VISIBLE;

public class Customizer extends AppCompatActivity {
    private Button btnSave;
    private EditText specname;
    private EditText annee;

    public Customizer() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customizer);

        /**  Using RecyclerView **/

        RecyclerView recyclerView;
        final ModulesListAdapter modulesListAdapter;

        final UserSessionManager userSessionManager = new UserSessionManager(this);
        final HashMap loggedUser = userSessionManager.getUserDetails();
        final int loggedUserId = Integer.valueOf(loggedUser.get("userId").toString());

        recyclerView = (RecyclerView) findViewById(R.id.modules_list_rec);
        int currentYear = 0;
        if (userSessionManager.getSessionYear() > 0) {
            currentYear = userSessionManager.getSessionYear();
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final ModulesTableManager db = new ModulesTableManager(this);
        List<ModuleG> semesters = ModulesListContent.getModulesList(db, loggedUserId, currentYear);
        modulesListAdapter = new ModulesListAdapter(semesters, this);
        recyclerView.setAdapter(modulesListAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        specname = (EditText) findViewById(R.id.SpecName);
        annee = (EditText) findViewById(R.id.textAnnee);

        btnSave = (Button) findViewById(R.id.btnS);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNotes = new Intent(Customizer.this, Launcher.class);
                startActivity(intentNotes);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

        final ImageButton addModule = (ImageButton) findViewById(R.id.imageButtonAddModule);
        final YearTableManager Ydb = new YearTableManager(getApplicationContext());

        addModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _SPECNAME = specname.getText().toString();
                Annee newYear = new Annee(_SPECNAME);
                User finalLoggedUser = new User(loggedUserId);
                Ydb.addYear(newYear, finalLoggedUser);
                final int y = Ydb.getYearidBySpecName(_SPECNAME);
                userSessionManager.setCurrentYearId(y);
                ModuleG newModule = new ModuleG("nouveau module");
                newModule.setUserId(loggedUserId);
                FragmentTransaction manager = getSupportFragmentManager().beginTransaction();
                ModuleCustomizePopup popup = new ModuleCustomizePopup();
                popup.show(manager, null);
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        finish();
    }
}
