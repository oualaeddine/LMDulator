package dz.da3sou9a.oualaeddine.lmdulator.activities.unitsList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import dz.da3sou9a.oualaeddine.lmdulator.R;

/**
 * Created by Ouala eddine on 08/10/2016.
 */

public class UnitsHolder extends RecyclerView.ViewHolder {
    private TextView unitName;
    // private ImageView icon;
    private View container;

    public UnitsHolder(View itemView) {
        super(itemView);

        unitName = (TextView) itemView.findViewById(R.id.TextViewItemModuleName);
        //  icon  = (ImageView)itemView.findViewById(R.id.moduleImg);
        container = itemView.findViewById(R.id.modules_list_rec);

    }

    public TextView getUnitName() {
        return unitName;
    }

    public void setModuleName(TextView unitName) {
        this.unitName = unitName;
    }

    //  public ImageView getIcon() {
    //       return icon;
    //   }

    // public void setIcon(ImageView icon) {
    //      this.icon = icon;
    //  }

    public View getContainer() {
        return container;
    }

    public void setContainer(View container) {
        this.container = container;
    }
}