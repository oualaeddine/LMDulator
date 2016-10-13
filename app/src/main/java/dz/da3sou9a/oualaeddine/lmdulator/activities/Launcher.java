package dz.da3sou9a.oualaeddine.lmdulator.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import dz.da3sou9a.oualaeddine.lmdulator.R;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class Launcher extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_launcher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        try {
            int loggedUserId = (int) getIntent().getSerializableExtra("userId");
            String loggedUserName = (String) getIntent().getSerializableExtra("loggedUserName");
            String LoggedUserId = (String) getIntent().getSerializableExtra("password");
            Log.e("user id from intent = ", String.valueOf(loggedUserId));
            Log.e("user id sent to toast", LoggedUserId);
            Toast.makeText(getBaseContext(), "userId:" + loggedUserId + "  username:" + loggedUserName, Toast.LENGTH_LONG).show();
        } catch (NullPointerException e) {
            Toast.makeText(getBaseContext(), "enjoy!", Toast.LENGTH_LONG).show();
        }

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        if (mViewPager != null) {
            mViewPager.setAdapter(mSectionsPagerAdapter);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(mViewPager);
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //TODO:create goodby intent
            moveTaskToBack(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.launcher, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        View rootView, recapView;
        TableLayout table;
        TableRow tabRow;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static NotesTable.PlaceholderFragment newInstance(int sectionNumber) {
            NotesTable.PlaceholderFragment fragment = new NotesTable.PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            recapView = inflater.inflate(R.layout.fragment_notes_recap, container, false);
            rootView = inflater.inflate(R.layout.fragment_tableau_notes, container, false);

            TextView credTot = (TextView) rootView.findViewById(R.id.credS);
            TextView moyS = (TextView) rootView.findViewById(R.id.moyS);


            /**  TODO Annee annee =  modul.year; //jabt annee
             Semestre s1 = annee.getS1();//jbadt menha
             Semestre s2 = annee.getS2();//les semestres
             List unitsS1 = s1.getSemester();//jbadt mn les semestrs
             List unitsS2 = s2.getSemester();//les listes des unités
             //kifah dork ndir bah njbd les modules?
             **/
            table = (TableLayout) rootView.findViewById(R.id.tableauNotes);
            tabRow = new TableRow(getContext());
            TextView moduleName = new TextView(getContext());
            EditText moduleTp = new EditText(getContext());
            EditText moduleTd = new EditText(getContext());
            EditText moduleCont = new EditText(getContext());
            TextView moduleMoy = new TextView(getContext());
            TextView moduleCred = new TextView(getContext());

            LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, (float) 1.0);
            LayoutParams layoutParams = new LayoutParams(MATCH_PARENT, WRAP_CONTENT, (float) 1.0);

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                /** for(Object next :unitsS1)
                 {
                 for (ModuleG next2 :((Unit) next).getUnitModulesList()){**/

                 tabRow.addView(moduleName);
                 tabRow.addView(moduleTp);
                 tabRow.addView(moduleTd);
                 tabRow.addView(moduleCont);
                 tabRow.addView(moduleCred);
                 tabRow.addView(moduleMoy);

                 tabRow.setLayoutParams(layoutParams);

                 moduleName.setLayoutParams(lp);
                 moduleTp.setLayoutParams(lp);
                 moduleTd.setLayoutParams(lp);
                 moduleCont.setLayoutParams(lp);
                 moduleCred.setLayoutParams(lp);
                 moduleMoy.setLayoutParams(lp);

                moduleCont.setText("00");
                moduleCred.setText("00");
                moduleMoy.setText("00");
                moduleTd.setText("00");
                moduleName.setText("ouala");
                table.addView(tabRow);/**
                 }
                 }**/

                return rootView;
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                /** for(Object next :unitsS2)
                 {
                 for (ModuleG next2 :((Unit) next).getUnitModulesList()){**/

                 tabRow.addView(moduleName);
                 tabRow.addView(moduleTp);
                 tabRow.addView(moduleTd);
                 tabRow.addView(moduleCont);
                 tabRow.addView(moduleCred);
                 tabRow.addView(moduleMoy);

                 tabRow.setLayoutParams(layoutParams);

                 moduleName.setLayoutParams(lp);
                 moduleTp.setLayoutParams(lp);
                 moduleTd.setLayoutParams(lp);
                 moduleCont.setLayoutParams(lp);
                 moduleCred.setLayoutParams(lp);
                 moduleMoy.setLayoutParams(lp);

                moduleCont.setText("00");
                moduleCred.setText("00");
                moduleMoy.setText("00");
                moduleTd.setText("00");
                moduleName.setText("ouala");
                 table.addView(tabRow);
//TODO: set the colors


                /**
                 }
                 }
                 **/
                return rootView;
            } else {
                return recapView;
            }
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return NotesTable.PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Semestre 1";
                case 1:
                    return "Semestre 2";
                case 2:
                    return "Generale";
            }
            return null;
        }
    }


}
