package dz.da3sou9a.oualaeddine.lmdulator.activities.frags;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dz.da3sou9a.oualaeddine.lmdulator.R;

/**
 * Created by Ouala eddine on 08/10/2016.
 */

public class ModuleCustomizePopup extends DialogFragment implements View.OnClickListener {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.module_customizer, container, false);
        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
