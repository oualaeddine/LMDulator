package dz.da3sou9a.oualaeddine.lmdulator.activities.notesTableAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import dz.da3sou9a.oualaeddine.lmdulator.R;


public class NotesHolder extends RecyclerView.ViewHolder {

    // private ImageView icon;
    private TextView moduleName, cred, moy;
    private TextView tp;
    private TextView td;
    private TextView cont;

    NotesHolder(View itemView) {
        super(itemView);

        moduleName = (TextView) itemView.findViewById(R.id.moduleName);
        cred = (TextView) itemView.findViewById(R.id.cred);
        moy = (TextView) itemView.findViewById(R.id.moy);
        tp = (TextView) itemView.findViewById(R.id.tp);
        td = (TextView) itemView.findViewById(R.id.td);
        cont = (TextView) itemView.findViewById(R.id.cont);
        //  icon  = (ImageView)itemView.findViewById(R.id.moduleImg);
    }

    TextView getModuleName() {
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



    public TextView getCred() {
        return cred;
    }

    public void setCred(TextView cred) {
        this.cred = cred;
    }

    public TextView getMoy() {
        return moy;
    }

    public void setMoy(TextView moy) {
        this.moy = moy;
    }

    public TextView getTp() {
        return tp;
    }

    public void setTp(EditText tp) {
        this.tp = tp;
    }

    public TextView getTd() {
        return td;
    }

    public void setTd(EditText td) {
        this.td = td;
    }

    public TextView getCont() {
        return cont;
    }

    public void setCont(EditText cont) {
        this.cont = cont;
    }
}