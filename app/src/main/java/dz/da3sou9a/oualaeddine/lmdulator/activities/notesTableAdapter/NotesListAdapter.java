package dz.da3sou9a.oualaeddine.lmdulator.activities.notesTableAdapter;

import android.content.Context;
import android.graphics.Color;
import android.icu.text.DecimalFormat;
import android.support.annotation.ColorInt;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;
import dz.da3sou9a.oualaeddine.lmdulator.miche.Calcul;

public class NotesListAdapter extends RecyclerView.Adapter<NotesHolder> {

    private List<ModuleG> listData;
    private LayoutInflater inflater;

    public NotesListAdapter(List<ModuleG> listData, Context context) {
        this.listData = listData;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public NotesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.notes_table_row, parent, false);

        return new NotesHolder(view);
    }

    @Override
    public void onBindViewHolder(NotesHolder holder, int position) {
        ModuleG item = listData.get(position);
        TextView tp = holder.getTp(),
                td = holder.getTd(),
                moy = holder.getMoy(),
                cont = holder.getCont(),
                cred = holder.getCred();
        double
                _tp = item.getTp(),
                _td = item.getTd(),
                _cont = item.getCont(),
                _moy = Calcul.moyModule(item);
        int
                _cred = Calcul.credModule(item);
        int
                red = Color.parseColor("#EF5350"),
                green = Color.parseColor("#66BB6A"),
                orange = Color.parseColor("#ffa726");

        holder.getModuleName().setText(item.getModuleName());
        tp.setText("" + _tp);
        float moyenne = (float) (Math.floor(_moy*100)/100);
        moy.setText(""+moyenne);
        td.setText("" + _td);
        cred.setText("" + _cred);

        cont.setText("" + _cont);
        if (_tp < 10) {
            tp.setBackgroundColor(red);
        } else {
            tp.setBackgroundColor(orange);
        }
        if (_td < 10) {
            td.setBackgroundColor(red);
        } else {
            td.setBackgroundColor(orange);
        }
        if (_cont < 10) {
            cont.setBackgroundColor(red);
        } else {
            cont.setBackgroundColor(orange);
        }
        if (_cred < item.getDefCred()) {
            cred.setBackgroundColor(red);
        } else {
            cred.setBackgroundColor(orange);
        }
        if (_moy < 10) {
            moy.setBackgroundColor(red);
        } else {
            moy.setBackgroundColor(green);
        }

        //int cred = Calcul.credModule(item);
        //  holder.getCred().setText(cred);
        //  double moy = Calcul.moyModule(item);
        // holder.getMoy().setText(String.valueOf(moy));
        //holder.getCont().setText((int) item.getCont());
        //holder.getIcon().setImageResource(item.getIcon());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public ModuleG getModule(int position) {
        return listData.get(position);
    }

    public List<ModuleG> getListData() {
        return listData;
    }
}
