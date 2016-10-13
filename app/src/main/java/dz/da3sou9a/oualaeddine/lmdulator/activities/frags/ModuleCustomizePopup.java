package dz.da3sou9a.oualaeddine.lmdulator.activities.frags;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.db.ModulesTableManager;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;

/**
 * Created by Ouala eddine on 08/10/2016.
 */

public class ModuleCustomizePopup extends DialogFragment implements View.OnClickListener {

    View view;
    ModuleG newModule;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.module_customizer, container, false);

        final Spinner _unit = (Spinner) view.findViewById(R.id.spinner);
        final Spinner _semester = (Spinner) view.findViewById(R.id.spinner2);
        final EditText _cred = (EditText) view.findViewById(R.id.cred);
        final EditText _coef = (EditText) view.findViewById(R.id.coef);
        final Switch _isTp = (Switch) view.findViewById(R.id.isTp);
        final Switch _isTd = (Switch) view.findViewById(R.id.isTd);
        final ImageView _icon = (ImageView) view.findViewById(R.id.imageButton2);
        final EditText _moduleName = (EditText) view.findViewById(R.id.editText2);

        _moduleName.setText(newModule.getModuleName());

        Button btnSave = (Button) view.findViewById(R.id.button2);
        Button btnCancel = (Button) view.findViewById(R.id.button);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {

                    newModule.setCoef(Integer.valueOf(_coef.getText().toString()));
                    newModule.setDefCred(Integer.valueOf(_cred.getText().toString()));
                    //newModule.setIcon();
                    newModule.setModuleName(_moduleName.getText().toString());
                    newModule.setTdState(_isTd.isChecked());
                    newModule.setTpState(_isTp.isChecked());
/**
 Customizer customizer = (Customizer) getActivity();
 Log.e("e","before addModuleToRecycler");
 customizer.addModuleToRecycler(newModule);
 Log.e("e","called addModuleToRecycler");
 **/
                    ModulesTableManager db = new ModulesTableManager(getContext());
                    db.open();
                    db.addModule(newModule);
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

    public void setModule(ModuleG module) {
        newModule = module;
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
}
