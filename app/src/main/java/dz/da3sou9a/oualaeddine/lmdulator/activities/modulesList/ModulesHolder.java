package dz.da3sou9a.oualaeddine.lmdulator.activities.modulesList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import dz.da3sou9a.oualaeddine.lmdulator.R;

/**
 * Created by Ouala eddine on 08/10/2016.
 */

public class ModulesHolder extends RecyclerView.ViewHolder {
    private TextView moduleName;
    // private ImageView icon;
    private View container;

    public ModulesHolder(View itemView) {
        super(itemView);

        moduleName = (TextView) itemView.findViewById(R.id.TextViewItemModuleName);
        //  icon  = (ImageView)itemView.findViewById(R.id.moduleImg);
        container = itemView.findViewById(R.id.modules_list_rec);

    }

    public TextView getModuleName() {
        return moduleName;
    }

    public void setModuleName(TextView moduleName) {
        this.moduleName = moduleName;
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