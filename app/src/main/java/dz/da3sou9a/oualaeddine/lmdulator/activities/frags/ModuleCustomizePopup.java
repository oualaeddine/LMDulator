package dz.da3sou9a.oualaeddine.lmdulator.activities.frags;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import dz.da3sou9a.oualaeddine.lmdulator.R;
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
        TextView moduleName = (TextView) view.findViewById(R.id.textView3);
        moduleName.setText(newModule.getModuleName());
        return view;
    }

    @Override
    public void onClick(View view) {
        EditText cred = (EditText) view.findViewById(R.id.editText3);

    }

    public void setModule(ModuleG module) {
        newModule = module;
    }
}
