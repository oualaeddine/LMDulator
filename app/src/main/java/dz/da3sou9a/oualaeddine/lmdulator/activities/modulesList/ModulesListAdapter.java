package dz.da3sou9a.oualaeddine.lmdulator.activities.modulesList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;

/**
 * Created by Ouala eddine on 08/10/2016.
 */

public class ModulesListAdapter extends RecyclerView.Adapter<ModulesHolder> {


    public List<ModuleG> listData;
    private LayoutInflater inflater;


    public ModulesListAdapter(List<ModuleG> listData, Context context) {
        this.listData = listData;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public dz.da3sou9a.oualaeddine.lmdulator.activities.modulesList.ModulesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.modules_listview_item, parent, false);

        return new ModulesHolder(view);
    }

    @Override
    public void onBindViewHolder(dz.da3sou9a.oualaeddine.lmdulator.activities.modulesList.ModulesHolder holder, int position) {
        ModuleG item = listData.get(position);
        holder.getModuleName().setText(item.getModuleName());
        //holder.getIcon().setImageResource(item.getIcon());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


    /**  //this method adds object to recyclerview
     public void addModule(ModuleG moduleG){
     listData.add(moduleG);
     int position = listData.size()-1;
     notifyItemInserted(position);
     }**/
}
