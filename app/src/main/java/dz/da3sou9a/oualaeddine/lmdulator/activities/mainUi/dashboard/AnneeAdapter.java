package dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi.dashboard;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.UserSessionManager;
import dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi.mainTable.activity.MainActivity;
import dz.da3sou9a.oualaeddine.lmdulator.db.YearTableManager;
import dz.da3sou9a.oualaeddine.lmdulator.items.Annee;

class AnneeAdapter extends RecyclerView.Adapter<AnneeAdapter.MyViewHolder> {

    private Context mContext;
    private List<Annee> annees;
    private static int currentYearPosition;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, count;
        ImageView thumbnail, overflow;

        MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    AnneeAdapter(Context mContext, List<Annee> annees) {
        this.mContext = mContext;
        this.annees = annees;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        int[] covers = new int[]{
                R.drawable.year2,
        };
        currentYearPosition = position;
        final Annee annee = annees.get(position);
        holder.title.setText(annee.getSpecName());
        Log.e("specname", annee.getSpecName());
        //holder.count.setText(annee.() + " songs");
        // loading annee cover2 using Glide library
        annee.setThumbnail(covers[0]);//todo : covers[posistion]
        Glide.with(mContext).load(annee.getThumbnail()).into(holder.thumbnail);
        final Context context = Dashboard.getInstance();
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserSessionManager userSessionManager = new UserSessionManager(context);
                userSessionManager.setCurrentYearId(annee.getYearId());
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });
        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    private class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                /*case R.id.action_add_favourite: {
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                }*/
                case R.id.action_play_next: {
                    Toast.makeText(mContext, "Supprimée! :D", Toast.LENGTH_SHORT).show();
                    deletCurrentYear();
                    Intent intent = new Intent(Dashboard.getInstance(), Dashboard.class);
                    Dashboard.getInstance().startActivity(intent);
                    return true;
                }
                default: {
                }
            }
            return false;
        }
    }

    private void deletCurrentYear() {
        YearTableManager db = new YearTableManager(Dashboard.getInstance());
        db.deleteYear(annees.get(currentYearPosition).getYearId());
    }

    @Override
    public int getItemCount() {
        return annees.size();
    }
}
