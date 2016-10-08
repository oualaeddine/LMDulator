package dz.da3sou9a.oualaeddine.lmdulator.activities.unitsList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.items.Unit;

/**
 * Created by Ouala eddine on 08/10/2016.
 */

public class UnitsListAdapter extends RecyclerView.Adapter<UnitsHolder> {


    public List<Unit> listData;
    private LayoutInflater inflater;


    public UnitsListAdapter(List<Unit> listData, Context context) {
        this.listData = listData;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public UnitsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.modules_listview_item, parent, false);

        return new UnitsHolder(view);
    }

    @Override
    public void onBindViewHolder(UnitsHolder holder, int position) {
        Unit item = listData.get(position);
        holder.getUnitName().setText(item.getUnitName());
        //holder.getIcon().setImageResource(item.getIcon());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

}
