package dz.da3sou9a.oualaeddine.lmdulator.activities.notesRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;

/**
 * Created by Ouala eddine on 21/10/2016.
 */

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyViewHolder> {

    List<ModuleG> data = Collections.EMPTY_LIST;
    private LayoutInflater inflator;

    public ViewAdapter(Context context, List<ModuleG> data) {
        Log.e("inside","inside ViewAdapter constructor");
        inflator = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.notes_table_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ModuleG module = data.get(position);
        //Todo:set colors
        holder.moduleName.setText(module.getModuleName());
        holder.moduleName.setBackgroundColor(module.getColor());
        //holder.cred.setText(module.getCred());

        //holder.tp.setEnabled(module.isTpState());
        //if (module.isTpState()) holder.tp.setText((int) module.getTp());

        //holder.td.setEnabled(module.isTdState());
        //if (module.isTdState()) holder.td.setText((int) module.getTd());

        //holder.moy.setText((int) module.getMoy());//TODO:set text decimal

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView moduleName, cred, moy;
        EditText tp, td, cont;

        public MyViewHolder(View itemView) {
            super(itemView);

            moduleName = (TextView) itemView.findViewById(R.id.moduleName);
            cred = (TextView) itemView.findViewById(R.id.cred);
            moy = (TextView) itemView.findViewById(R.id.moy);
            tp = (EditText) itemView.findViewById(R.id.tp);
            td = (EditText) itemView.findViewById(R.id.td);
            cont = (EditText) itemView.findViewById(R.id.cont);
        }
    }
}
