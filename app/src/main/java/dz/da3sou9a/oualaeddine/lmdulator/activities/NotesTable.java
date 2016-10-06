package dz.da3sou9a.oualaeddine.lmdulator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
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

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.items.Annee;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class NotesTable extends AppCompatActivity {
    public static Annee year;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_table);
        Intent intent = getIntent();
        year =  (Annee) intent.getSerializableExtra("year");

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        if (mViewPager != null) {
            mViewPager.setAdapter(mSectionsPagerAdapter);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(mViewPager);
        }

        //  table = (TableLayout)findViewById(tabLayout)


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notes_table, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */

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
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
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
/**
 TextView mn1 = (TextView) rootView.findViewById(R.id.moduleName1);
 TextView mn2 = (TextView) rootView.findViewById(R.id.moduleName2);
 TextView mn3 = (TextView) rootView.findViewById(R.id.moduleName3);
 TextView mn4 = (TextView) rootView.findViewById(R.id.moduleName4);
 TextView mn5 = (TextView) rootView.findViewById(R.id.moduleName5);
 TextView mn6 = (TextView) rootView.findViewById(R.id.moduleName6);
 TextView mn7 = (TextView) rootView.findViewById(R.id.moduleName7);
 TextView mn8 = (TextView) rootView.findViewById(R.id.moduleName8);

 EditText tp1 = (EditText) rootView.findViewById(R.id.tp1);
 EditText tp2 = (EditText) rootView.findViewById(R.id.tp2);
 EditText tp3 = (EditText) rootView.findViewById(R.id.tp3);
 EditText tp4 = (EditText) rootView.findViewById(R.id.tp4);
 EditText tp5 = (EditText) rootView.findViewById(R.id.tp5);
 EditText tp6 = (EditText) rootView.findViewById(R.id.tp6);
 EditText tp7 = (EditText) rootView.findViewById(R.id.tp7);
 EditText tp8 = (EditText) rootView.findViewById(R.id.tp8);

 EditText td1 = (EditText) rootView.findViewById(R.id.td1);
 EditText td2 = (EditText) rootView.findViewById(R.id.td2);
 EditText td3 = (EditText) rootView.findViewById(R.id.td3);
 EditText td4 = (EditText) rootView.findViewById(R.id.td4);
 EditText td5 = (EditText) rootView.findViewById(R.id.td5);
 EditText td6 = (EditText) rootView.findViewById(R.id.td6);
 EditText td7 = (EditText) rootView.findViewById(R.id.td7);
 EditText td8 = (EditText) rootView.findViewById(R.id.td8);

 EditText cont1 = (EditText) rootView.findViewById(R.id.cont1);
 EditText cont2 = (EditText) rootView.findViewById(R.id.cont2);
 EditText cont3 = (EditText) rootView.findViewById(R.id.cont3);
 EditText cont4 = (EditText) rootView.findViewById(R.id.cont4);
 EditText cont5 = (EditText) rootView.findViewById(R.id.cont5);
 EditText cont6 = (EditText) rootView.findViewById(R.id.cont6);
 EditText cont7 = (EditText) rootView.findViewById(R.id.cont7);
 EditText cont8 = (EditText) rootView.findViewById(R.id.cont8);

 TextView cred1 = (TextView) rootView.findViewById(R.id.cred1);
 TextView cred2 = (TextView) rootView.findViewById(R.id.cred2);
 TextView cred3 = (TextView) rootView.findViewById(R.id.cred3);
 TextView cred4 = (TextView) rootView.findViewById(R.id.cred4);
 TextView cred5 = (TextView) rootView.findViewById(R.id.cred5);
 TextView cred6 = (TextView) rootView.findViewById(R.id.cred6);
 TextView cred7 = (TextView) rootView.findViewById(R.id.cred7);
 TextView cred8 = (TextView) rootView.findViewById(R.id.cred8);

 TextView moy1 = (TextView) rootView.findViewById(R.id.moy1);
 TextView moy2 = (TextView) rootView.findViewById(R.id.moy2);
 TextView moy3 = (TextView) rootView.findViewById(R.id.moy3);
 TextView moy4 = (TextView) rootView.findViewById(R.id.moy4);
 TextView moy5 = (TextView) rootView.findViewById(R.id.moy5);
 TextView moy6 = (TextView) rootView.findViewById(R.id.moy6);
 TextView moy7 = (TextView) rootView.findViewById(R.id.moy7);
 TextView moy8 = (TextView) rootView.findViewById(R.id.moy8);
 **/
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
            TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT, (float) 1.0);

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
            return PlaceholderFragment.newInstance(position + 1);
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