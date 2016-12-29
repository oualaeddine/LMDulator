package dz.da3sou9a.oualaeddine.lmdulator.activities.frags;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.HashMap;

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.UserSessionManager;
import dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi.Launcher;
import dz.da3sou9a.oualaeddine.lmdulator.activities.modulesList.ModulesListAdapter;
import dz.da3sou9a.oualaeddine.lmdulator.activities.notesTableAdapter.NotesListAdapter;
import dz.da3sou9a.oualaeddine.lmdulator.db.ModulesTableManager;
import dz.da3sou9a.oualaeddine.lmdulator.db.UnitsTableManager;
import dz.da3sou9a.oualaeddine.lmdulator.items.Annee;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;
import dz.da3sou9a.oualaeddine.lmdulator.items.Semestre;
import dz.da3sou9a.oualaeddine.lmdulator.items.Unit;
import dz.da3sou9a.oualaeddine.lmdulator.items.User;

/**
 * Created by Ouala eddine on 08/10/2016.
 */

public class ModuleCustomizePopup extends DialogFragment implements View.OnClickListener {

    View view;
    ModuleG newModule;
    int currentYear;
    ModulesListAdapter modulesListAdapter;
    NotesListAdapter notesmanager;
    Annee newYear;
    User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.module_customizer, container, false);

        final EditText _unit = (EditText) view.findViewById(R.id.unit);
        final EditText _semester = (EditText) view.findViewById(R.id.semester);
        final EditText _cred = (EditText) view.findViewById(R.id.cred);
        final EditText _coef = (EditText) view.findViewById(R.id.coef);
        final Switch _isTp = (Switch) view.findViewById(R.id.isTp);
        final Switch _isTd = (Switch) view.findViewById(R.id.isTd);
        final ImageView _icon = (ImageView) view.findViewById(R.id.imageButton2);
        final EditText _moduleName = (EditText) view.findViewById(R.id.editText2);

        _moduleName.setText(newModule.getModuleName());

        Button btnSave = (Button) view.findViewById(R.id.button2);
        Button btnCancel = (Button) view.findViewById(R.id.button);

        UserSessionManager userSessionManager = new UserSessionManager(getContext());

        HashMap loggedUser = userSessionManager.getUserDetails();
        final int loggedUserId = Integer.valueOf(loggedUser.get("userId").toString());

        // Toast.makeText(getBaseContext(), "userId:" + loggedUser.get("name") + "  username:" + loggedUser.get("userId"), Toast.LENGTH_LONG).show();


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("btnsave", "validate()=" + String.valueOf(validate()));
                if (validate()) {
                    Unit unit = new Unit(_unit.getText().toString());
                    UnitsTableManager udb = new UnitsTableManager(getContext());
                    udb.addUnit(unit, user,currentYear);

                    newModule.setUserId(loggedUserId);
                    newModule.setCoef(Integer.valueOf(_coef.getText().toString()));
                    newModule.setDefCred(Integer.valueOf(_cred.getText().toString()));
                    //newModule.setIcon();
                    newModule.setModuleName(_moduleName.getText().toString());
                    newModule.setTdState(_isTd.isChecked());
                    newModule.setTpState(_isTp.isChecked());
                    newModule.setUnitId(Integer.parseInt(_unit.getText().toString()));
                    newModule.setSemester(Integer.parseInt(_semester.getText().toString()));
                    newModule.setYearId(currentYear);
                    ModulesTableManager db = new ModulesTableManager(getContext());
                    db.open();
                    Log.e("popup", "newmoduleName=" + newModule.getModuleName());
                    db.addModule(newModule);
                    if(modulesListAdapter!=null) {
                        modulesListAdapter.listData.add(newModule);
                        modulesListAdapter.notifyItemInserted(modulesListAdapter.listData.size() + 1);
                    }else{
                        notesmanager.getListData().add(newModule);
                        notesmanager.notifyItemInserted(notesmanager.getListData().size() + 1);
                    }
                    Launcher.getInstance().getFrag().setSemesterMoy();
                    Launcher.getInstance().getFrag().setSemesterCred();
                    //Todo delete Toast debug line
                    Toast.makeText(getContext(), String.valueOf(newModule.getSemester()), Toast.LENGTH_LONG).show();
                    dismiss();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {

    }

    public void setModule(int currentY, ModuleG module, ModulesListAdapter modulesListAdapter, Annee newYear, User user) {
        this.modulesListAdapter = modulesListAdapter;
        newModule = module;
        currentYear = currentY;
        this.newYear = newYear;
        this.user = user;
    }
    public void setModule(int currentY, ModuleG module, Annee newYear, User user) {
        newModule = module;
        currentYear = currentY;
        this.newYear = newYear;
        this.user = user;
    }
    public void setModule(int currentY, ModuleG module, ModulesListAdapter modulesListAdapter, User user) {
        this.modulesListAdapter = modulesListAdapter;
        newModule = module;
        currentYear = currentY;
        this.user = user;
    }

    public boolean validate() {
        final EditText _cred = (EditText) view.findViewById(R.id.cred);
        final EditText _coef = (EditText) view.findViewById(R.id.coef);
        final EditText _moduleName = (EditText) view.findViewById(R.id.editText2);

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


    public void setModule(int y, ModuleG newModule, int loggedUserId) {
         this.newModule = newModule;
        currentYear = y;
        this.user = new User(loggedUserId);
    }

    public void setModule(int y, ModuleG newModule, NotesListAdapter notesManager, User user) {
        this.notesmanager = notesManager;
        this.newModule = newModule;
        currentYear = y;
        this.user = user;
    }
}
