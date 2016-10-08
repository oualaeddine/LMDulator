package dz.da3sou9a.oualaeddine.lmdulator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableRow;

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.activities.modulesList.ModulesListAdapter;
import dz.da3sou9a.oualaeddine.lmdulator.activities.modulesList.ModulesListContent;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;

import static android.view.View.VISIBLE;

public class Customizer extends AppCompatActivity {
    private TableRow modulesList;
    private Button btnSave, btnEditModules;
    private EditText specname,annee,nbrModulesS1,nbrModulesS2,credAnnuelMin,credS1min,credS2min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customizer);

/**
        ArrayList<ModuleG> modules = new ArrayList<ModuleG>();

        ModuleG module1 = new ModuleG("module1");
        ModuleG module2 = new ModuleG("module2");
        ModuleG module3 = new ModuleG("module3");

        modules.add(0, module1);
        modules.add(1, module3);
        modules.add(module2);
 Log.e("after filling the list", String.valueOf(modules.size()));

        ModulesListViewAdapter moduleAdapter = new ModulesListViewAdapter(modules);
        ListView modulesListView = (ListView) findViewById(R.id.listViewModules);
        modulesListView.setAdapter(moduleAdapter);

 LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 55*modules.size());
 modulesListView.setLayoutParams(layoutParams);

 View lisContainer = findViewById(R.id.linearLayoutListContainer);

 LinearLayout.LayoutParams layoutParamsContainer = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 55*(modules.size()+1));
 lisContainer.setLayoutParams(layoutParamsContainer);
 **/


        /**  Using RecyclerView **/

        RecyclerView recyclerView;
        final ModulesListAdapter modulesListAdapter;

        recyclerView = (RecyclerView) findViewById(R.id.modules_list_rec);
        //LayoutManager LinearLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        modulesListAdapter = new ModulesListAdapter(ModulesListContent.getModulesList(), this);
        recyclerView.setAdapter(modulesListAdapter);





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


        final EditText content = (EditText) findViewById(R.id.content);
        final ImageButton addModule = (ImageButton) findViewById(R.id.imageButtonAddModule);

        addModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModuleG newModule = new ModuleG(content.getText().toString());

                modulesListAdapter.listData.add(newModule);
                modulesListAdapter.notifyItemInserted(modulesListAdapter.listData.size() - 1);

            }
        });
    }


    /**  class ModulesListViewAdapter extends BaseAdapter {

        ArrayList<ModuleG> moduleGItemsArrayList = new ArrayList<ModuleG>();

        public ModulesListViewAdapter(ArrayList<ModuleG> moduleGItemsArrayList) {
            this.moduleGItemsArrayList = moduleGItemsArrayList;
     Log.e("Adapter constructor", String.valueOf(this.moduleGItemsArrayList.size()));

        }

        @Override
        public int getCount() {

            return moduleGItemsArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return moduleGItemsArrayList.get(position).getModuleName();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = getLayoutInflater();

            View view1 = inflater.inflate(R.layout.modules_listview_item, null);

            TextView moduleName = (TextView) view1.findViewById(R.id.content);

            moduleName.setText(moduleGItemsArrayList.get(i).getModuleName());

            return view1;
        }
        }**/
}
