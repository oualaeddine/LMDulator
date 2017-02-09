package dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi.mainTable.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.Switch;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.UserSessionManager;
import dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi.components.RecyclerItemClickListener;
import dz.da3sou9a.oualaeddine.lmdulator.activities.notesTableAdapter.NotesListAdapter;
import dz.da3sou9a.oualaeddine.lmdulator.activities.notesTableAdapter.NotesListContent;
import dz.da3sou9a.oualaeddine.lmdulator.db.ModulesTableManager;
import dz.da3sou9a.oualaeddine.lmdulator.db.UnitsTableManager;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;
import dz.da3sou9a.oualaeddine.lmdulator.items.Semestre;
import dz.da3sou9a.oualaeddine.lmdulator.items.Unit;
import dz.da3sou9a.oualaeddine.lmdulator.items.User;
import dz.da3sou9a.oualaeddine.lmdulator.miche.Calcul;


public class FragmentTwo extends Fragment {
    View rootView;
    private RecyclerView recyclerView;
    private int loggedUserId = 1, year = 1;
    private NotesListAdapter notesListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_tableau_notes, null);
        initSession();
        initFragContent();
        initFab();
        return rootView;
    }

    void initSession() {
        UserSessionManager userSessionManager = new UserSessionManager(getContext());
        //final HashMap loggedUser = userSessionManager.getUserDetails();
        //loggedUserId = Integer.valueOf(loggedUser.get("userId").toString());
        year = userSessionManager.getSessionYear();
    }

    private void initFab() {
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addModule(getContext());
            }
        });
    }

    void initFragContent() {
        ModulesTableManager db = new ModulesTableManager(getContext());
        db.open();
        List<ModuleG> modules = NotesListContent.getModulesList(db, loggedUserId, year);
        List<ModuleG> modulesS2 = modulesInSem(2, modules);
        notesListAdapter = new NotesListAdapter(modulesS2, getContext());

        recyclerView = (RecyclerView) rootView.findViewById(R.id.units_list_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(notesListAdapter);
        recyclerViewOnTouch(recyclerView, notesListAdapter, getContext());
        setSemesterMoy(2);
        setSemesterCred(2);
    }

    private void recyclerViewOnTouch(final RecyclerView recyclerView, final NotesListAdapter notesListAdapter, final Context context) {
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, final int position) {
                        showPopupEditNote(position, context, notesListAdapter);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do whatever
                        // Intent intent = new Intent(context, PieChartFrag.class);
                        //startActivity(intent);
                    }
                })
        );
    }


    /**************************************************************************************************/
    public void setSemesterMoy(int semester) {
        TableRow tableRowMoy;
        tableRowMoy = (TableRow) rootView.findViewById(R.id.MoyCredTR);

        TextView tvTextMoy = (TextView) tableRowMoy.findViewById(R.id.textMoyS);
        TextView tvMoy = (TextView) tableRowMoy.findViewById(R.id.moyS);
        List<ModuleG> modules;
        modules = notesListAdapter.getListData();

        Semestre s1 = getSemester(semester, (LinkedList<ModuleG>) modules);
        double moy = 0;
        if (s1.getNbUnit() != 0) {
            moy = Calcul.moySemester(s1);
        }
        String u = "" + Math.floor(moy * 100) / 100;
        tvMoy.setText(u);
        int red = Color.parseColor("#EF5350");
        int def = Color.parseColor("#66BB6A");
        if (moy < 10) {
            tvMoy.setBackgroundColor(red);
            tvTextMoy.setBackgroundColor(red);
        } else {
            tvMoy.setBackgroundColor(def);
            tvTextMoy.setBackgroundColor(def);
        }
    }

    public void setSemesterCred(int semester) {
        TableRow tableRowCred;
        tableRowCred = (TableRow) rootView.findViewById(R.id.MoyCredTR);

        TextView tvTextCred = (TextView) tableRowCred.findViewById(R.id.textCredTotalS);
        TextView tvCred = (TextView) tableRowCred.findViewById(R.id.credS);
        List<ModuleG> modules;
        modules = notesListAdapter.getListData();

        Semestre s = getSemester(semester, (LinkedList<ModuleG>) modules);
        int cred = 0;
        if (s.getNbUnit() != 0) {
            cred = Calcul.credSemester(s);
        }
        String u = "" + cred;
        tvCred.setText(u);
        int red = Color.parseColor("#EF5350");
        int def = Color.parseColor("#66BB6A");
        if (cred < Calcul.defCredSemester(s)) {
            tvCred.setBackgroundColor(red);
            tvTextCred.setBackgroundColor(red);
        } else {
            tvCred.setBackgroundColor(def);
            tvTextCred.setBackgroundColor(def);
        }
    }

    private Semestre getSemester(int semesterid, LinkedList<ModuleG> modules) {
        Semestre s1 = new Semestre(semesterid);
        for (ModuleG module : modules) {
            if (module.getSemester() == semesterid) {
                s1.setSemester(getUnits(modules));
            }
        }
        return s1;
    }

    private LinkedList<Unit> getUnits(LinkedList<ModuleG> modules) {

        LinkedList<Unit> u = new LinkedList<>();
        Unit[] un = new Unit[11];
        for (int i = 0; i < un.length; i++) {
            un[i] = new Unit(i);
        }
        for (ModuleG module : modules) {
            for (int j = 1; j < un.length; j++) {
                if (module.getUnitId() == j) {
                    un[j].addModule(module);
                }
            }
        }

        Collections.addAll(u, un);

        return u;
    }

    private List<ModuleG> modulesInSem(int i, List<ModuleG> modules) {
        List<ModuleG> x = new LinkedList<>();
        for (ModuleG module : modules) {
            if (module.getSemester() == i)
                x.add(module);
        }
        return x;
    }

    /**************************************************************************************************/
    public void refreshItems() {
        notesListAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(notesListAdapter);
        setSemesterCred(2);
        setSemesterMoy(2);
    }

    private void addModule(Context context) {

        final Dialog popUpWindow = new Dialog(context);
        popUpWindow.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {

            }
        });
        LayoutInflater factory = LayoutInflater.from(context);
        final View myView = factory.inflate(R.layout.module_customizer, null);

        Button btnSave = (Button) myView.findViewById(R.id.button2);
        Button btnCancel = (Button) myView.findViewById(R.id.button);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validate(myView)) {
                    addModuleTodDb(myView);
                    refreshItems();
                    popUpWindow.dismiss();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshItems();
                popUpWindow.dismiss();
            }
        });
        LinearLayout layout = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(params);
        layout.addView(myView);
        myView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        popUpWindow.setContentView(layout);
        popUpWindow.show();
    }

    public void addModuleTodDb(View view) {

        User user = new User(loggedUserId);

        EditText _unit = (EditText) view.findViewById(R.id.unit);
        EditText _semester = (EditText) view.findViewById(R.id.semester);
        EditText _cred = (EditText) view.findViewById(R.id.cred);
        EditText _coef = (EditText) view.findViewById(R.id.coef);
        Switch _isTp = (Switch) view.findViewById(R.id.isTp);
        Switch _isTd = (Switch) view.findViewById(R.id.isTd);
        EditText _moduleName = (EditText) view.findViewById(R.id.editText2);

        Unit unit = new Unit(_unit.getText().toString());
        ModuleG newModule = new ModuleG(_moduleName.getText().toString());

        UnitsTableManager udb = new UnitsTableManager(getContext());
        udb.addUnit(unit, user, year);

        newModule.setUserId(loggedUserId);
        newModule.setCoef(Integer.valueOf(_coef.getText().toString()));
        newModule.setDefCred(Integer.valueOf(_cred.getText().toString()));
        newModule.setModuleName(_moduleName.getText().toString());
        newModule.setTdState(_isTd.isChecked());
        newModule.setTpState(_isTp.isChecked());
        newModule.setUnitId(Integer.parseInt(_unit.getText().toString()));
        newModule.setSemester(Integer.parseInt(_semester.getText().toString()));
        newModule.setYearId(year);
        ModulesTableManager db = new ModulesTableManager(getContext());
        db.open();
        db.addModule(newModule);
        refreshItems();
    }


    public boolean validate(View view) {
        final EditText _cred = (EditText) view.findViewById(R.id.cred);
        final EditText _coef = (EditText) view.findViewById(R.id.coef);
        final EditText _moduleName = (EditText) view.findViewById(R.id.editText2);
        final EditText _semester = (EditText) view.findViewById(R.id.semester);

        boolean valid = true;
        try {
            String name = _moduleName.getText().toString();

            if (name.isEmpty()) {
                _moduleName.setError("you must enter the module name");
                valid = false;
            } else {
                _moduleName.setError(null);
            }
        } catch (Exception e) {
            _moduleName.setError("you must enter the module name");
            valid = false;
        }

        try {
            int cred = Integer.valueOf(_cred.getText().toString());
            if (cred == 0 || cred < 1 || cred > 10) {
                _cred.setError("between 1 and 10");
                valid = false;
            } else {
                _cred.setError(null);
            }
        } catch (Exception e) {
            _cred.setError("enter valid number");
            valid = false;
        }
        try {
            int sem = Integer.valueOf(_semester.getText().toString());
            if (sem < 1 || sem > 2) {
                _semester.setError("1 or 2");
                valid = false;
            } else {
                _semester.setError(null);
            }
        } catch (Exception e) {
            _semester.setError("enter valid number");
            valid = false;
        }

        try {
            int coef = Integer.valueOf(_coef.getText().toString());
            if (coef == 0 || coef < 1 || coef > 10) {
                _coef.setError("between 1 and 10");
                valid = false;
            } else {
                _coef.setError(null);
            }
        } catch (Exception e) {
            _coef.setError("enter valid number");
            valid = false;
        }
        return valid;
    }

    private void showPopupEditNote(final int position, final Context context, final NotesListAdapter notesListAdapter) {

        final ModuleG module = notesListAdapter.getModule(position);
        final Dialog popUpWindow = new Dialog(context);
        popUpWindow.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {

            }
        });
        LayoutInflater factory = LayoutInflater.from(context);
        View myView = factory.inflate(R.layout.edit_notes_popup, null);

        LinearLayout layout = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(params);
        layout.addView(myView);
        final EditText tp, td, control;
        TextView moduleNametv;
        moduleNametv = (TextView) myView.findViewById(R.id.textView3);
        tp = (EditText) myView.findViewById(R.id.note_tp);
        td = (EditText) myView.findViewById(R.id.note_td);
        control = (EditText) myView.findViewById(R.id.note_control);

        Space sp1 = (Space) myView.findViewById(R.id.sp1);
        Space sp2 = (Space) myView.findViewById(R.id.sp2);
        moduleNametv.setText(module.getModuleName());
        sp1.setVisibility(View.GONE);
        sp2.setVisibility(View.GONE);
        if (!module.isTdState()) {
            td.setVisibility(View.GONE);
            sp1.setVisibility(View.GONE);
        }
        if (!module.isTpState()) {
            tp.setVisibility(View.GONE);
            sp2.setVisibility(View.GONE);
        }
        String tpv = "" + module.getTp();
        String tdv = "" + module.getTd();
        String contd = "" + module.getCont();
        tp.setText(tpv);
        td.setText(tdv);
        control.setText(contd);
        Button confirm = (Button) myView.findViewById(R.id.button5);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate(tp, td, control)) {
                    module.setCont(Double.parseDouble(control.getText().toString()));
                    if (module.isTdState()) {
                        module.setTd(Double.parseDouble(td.getText().toString()));
                    } else {
                        module.setTd(0);
                    }
                    if (module.isTpState()) {
                        module.setTp(Double.parseDouble(tp.getText().toString()));
                    } else {
                        module.setTp(0);
                    }
                    module.setMoy(Calcul.moyModule(module));
                    module.setCred(Calcul.credModule(module));

                    ModulesTableManager db = new ModulesTableManager(context);
                    db.open();
                    db.addModule(module);
                        /*setSemesterMoy(sem);
                        setSemesterCred(sem);*/
                    refreshItems();
                    popUpWindow.dismiss();
                }
            }

            private boolean validate(EditText tp, EditText td, EditText cont) {
                boolean valid = true;

                double _tp = Double.valueOf(tp.getText().toString());
                if (_tp < 0 || _tp > 20 || tp.getText().toString().equals("")) {
                    tp.setError("valeur entre 0 and 20");
                    valid = false;
                }
                double _td = Double.valueOf(td.getText().toString());
                if (_td < 0 || _td > 20 || td.getText().toString().equals("")) {
                    td.setError("valeur entre 0 and 20");
                    valid = false;
                }
                double _cont = Double.valueOf(cont.getText().toString());
                if (_cont < 0 || _cont > 20 || cont.getText().toString().equals("")) {
                    cont.setError("valeur entre 0 and 20");
                    valid = false;
                }
                return valid;
            }
        });

        myView.setLayoutParams(new LinearLayout.LayoutParams(500, LinearLayout.LayoutParams.WRAP_CONTENT));
        popUpWindow.setContentView(layout);
        popUpWindow.show();
    }
}
