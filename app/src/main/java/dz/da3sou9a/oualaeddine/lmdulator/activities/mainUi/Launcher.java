package dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.Pair;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.OnBoomListener;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.UserSessionManager;
import dz.da3sou9a.oualaeddine.lmdulator.activities.PrefManager;
import dz.da3sou9a.oualaeddine.lmdulator.activities.frags.ModuleCustomizePopup;
import dz.da3sou9a.oualaeddine.lmdulator.activities.frags.SliderLauncher;
import dz.da3sou9a.oualaeddine.lmdulator.activities.notesRecyclerView.ViewAdapter;
import dz.da3sou9a.oualaeddine.lmdulator.activities.notesTableAdapter.NotesListAdapter;
import dz.da3sou9a.oualaeddine.lmdulator.activities.notesTableAdapter.NotesListContent;
import dz.da3sou9a.oualaeddine.lmdulator.db.ModulesTableManager;
import dz.da3sou9a.oualaeddine.lmdulator.items.Annee;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;
import dz.da3sou9a.oualaeddine.lmdulator.items.Semestre;
import dz.da3sou9a.oualaeddine.lmdulator.items.Unit;
import dz.da3sou9a.oualaeddine.lmdulator.items.User;
import dz.da3sou9a.oualaeddine.lmdulator.miche.Calcul;

import static android.R.attr.y;
import static dz.da3sou9a.oualaeddine.lmdulator.activities.frags.SliderLauncher.*;

public class Launcher extends AppCompatActivity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    public static Launcher instance;
    public static PlaceholderFragment Frag;

    public static PlaceholderFragment getFrag() {
        return Frag;
    }

    public static Launcher getInstance() {
        return instance;
    }

    public FragmentTransaction getFT() {
        return getSupportFragmentManager().beginTransaction();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.app_bar_launcher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /********************************************************************************************/

        ActionBar mActionBar = getSupportActionBar();
        assert mActionBar != null;
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setHomeButtonEnabled(true);

        LayoutInflater mInflater = LayoutInflater.from(this);

        View actionBar = mInflater.inflate(R.layout.custom_actionbar, null);
        //TextView mTitleTextView = (TextView) actionBar.findViewById(R.id.title_text);
        //mTitleTextView.setText(R.string.app_name);
        mActionBar.setCustomView(actionBar);
        mActionBar.setDisplayShowCustomEnabled(true);
        ((Toolbar) actionBar.getParent()).setContentInsetsAbsolute(0, 0);

        BoomMenuButton leftBmb = (BoomMenuButton) actionBar.findViewById(R.id.action_bar_left_bmb);
        //BoomMenuButton rightBmb = (BoomMenuButton) actionBar.findViewById(R.id.action_bar_right_bmb);
//     BoomMenuButton leftBmb = new BoomMenuButton(this);

        leftBmb.setButtonEnum(ButtonEnum.Ham);
        leftBmb.setPiecePlaceEnum(PiecePlaceEnum.HAM_6);
        leftBmb.setButtonPlaceEnum(ButtonPlaceEnum.HAM_6);

        for (int i = 0; i < leftBmb.getPiecePlaceEnum().pieceNumber(); i++)
            leftBmb.addBuilder(BuilderManager.getLauncherMenuBoutton());

        leftBmb.setOnBoomListener(new OnBoomListener() {
            @Override
            public void onClicked(int index, BoomButton boomButton) {
                Toast.makeText(Launcher.this, "Clicked " + index, Toast.LENGTH_SHORT).show();
                switch (index) {
                    case 1: {
                        break;
                    }
                    case 2: {
                        break;
                    }
                    case 3: {
                        break;
                    }
                    case 4: {
                        break;
                    }
                    case 5: {
                        break;
                    }
                    case 6: {
                        break;
                    }

                }
            }

            @Override
            public void onBackgroundClick() {

            }

            @Override
            public void onBoomWillHide() {

            }

            @Override
            public void onBoomDidHide() {

            }

            @Override
            public void onBoomWillShow() {

            }

            @Override
            public void onBoomDidShow() {

            }
        });
        /** rightBmb.setButtonEnum(ButtonEnum.Ham);
         rightBmb.setPiecePlaceEnum(PiecePlaceEnum.HAM_4);
         rightBmb.setButtonPlaceEnum(ButtonPlaceEnum.HAM_4);
         for (int i = 0; i < rightBmb.getPiecePlaceEnum().pieceNumber(); i++){
         rightBmb.addBuilder(BuilderManager.getHamButtonBuilderWithDifferentPieceColor());}

         /*******************************************************************************************/

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

    /**
     * @Override public void onBackPressed() {
     * DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
     * if (drawer.isDrawerOpen(GravityCompat.START)) {
     * drawer.closeDrawer(GravityCompat.START);
     * } else {
     * //TODO:create goodby intent
     * //   moveTaskToBack(true);
     * }
     * }
     **/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.launcher, menu);
        return false;
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

    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        private static final String ARG_SECTION_NUMBER = "section_number";
        View rootView, recapView;
        private RecyclerView notesRecycler;
        private ViewAdapter adapter;
        private static TableRow tr;
        private static int sem;
        private static LinkedList<ModuleG> mod;
        private ArrayList<Pair> piecesAndButtons = new ArrayList<>();
        private static NotesListAdapter notesListAdapterS1,notesListAdapterS2;
        private static int loggedUserId;
        private static int year;

        private static TableRow getTr() {
            return tr;
        }

        private static int getSem() {
            return sem;
        }

        private static LinkedList<ModuleG> getMod() {
            return mod;
        }

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        ViewPager viewPager;
        static MyViewPagerAdapter myViewPagerAdapter;
        LinearLayout dotsLayout;
        static TextView[] dots;
        static int[] layouts;
        Button btnSkip, btnNext;
        PrefManager prefManager;
        static int current = 0;

        public static PlaceholderFragment newInstance(int sectionNumber) {


            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            Frag = fragment;
            return fragment;
        }

        public static List<ModuleG> getData(Context context, int userId, int yearId, int semesterId) {
            ModulesTableManager db = new ModulesTableManager(context);
            db.open();
            return db.getModules(userId, yearId, semesterId);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            recapView = inflater.inflate(R.layout.fragment_notes_recap, container, false);
            rootView = inflater.inflate(R.layout.fragment_tableau_notes, container, false);
            UserSessionManager userSessionManager = new UserSessionManager(getContext());
            final HashMap loggedUser = userSessionManager.getUserDetails();
            final int loggedUserId = Integer.valueOf(loggedUser.get("userId").toString());
            final int y = userSessionManager.getSessionYear();
            Toast.makeText(getContext(), "userId:" + loggedUser.get("userId") + "  username:" + loggedUser.get("name"), Toast.LENGTH_LONG).show();

            //notesRecycler = (RecyclerView) rootView.findViewById(R.id.units_list_rec);
            RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.units_list_rec);
            TableRow trmoy = (TableRow) rootView.findViewById(R.id.MoyCredTR);
            int currentYear = userSessionManager.getSessionYear();
            year = currentYear;
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            final ModulesTableManager db = new ModulesTableManager(getContext());
            List<ModuleG> modules = NotesListContent.getModulesList(db, loggedUserId, currentYear);
            List<ModuleG> modulesS1 = modulesInSem(1, modules);
            List<ModuleG> modulesS2 = modulesInSem(2, modules);
            notesListAdapterS1 = new NotesListAdapter(modulesS1, getContext());
            notesListAdapterS2 = new NotesListAdapter(modulesS2, getContext());

            tr = trmoy;
            mod = (LinkedList<ModuleG>) modules;
            sem = getArguments().getInt(ARG_SECTION_NUMBER);
            /*************************************************************************************************/
initSlider();
initAddModuleBoom();

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                recyclerView.setAdapter(notesListAdapterS1);
                recyclerViewOnTouch(recyclerView, notesListAdapterS1, getContext());
                setSemesterMoy(trmoy, (LinkedList<ModuleG>) modulesS1, getArguments().getInt(ARG_SECTION_NUMBER));
                setSemesterCred(trmoy, (LinkedList<ModuleG>) modulesS1, getArguments().getInt(ARG_SECTION_NUMBER));
                return rootView;
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                recyclerViewOnTouch(recyclerView, notesListAdapterS2, getContext());
                recyclerView.setAdapter(notesListAdapterS2);
                setSemesterMoy(trmoy, (LinkedList<ModuleG>) modulesS2, getArguments().getInt(ARG_SECTION_NUMBER));
                setSemesterCred(trmoy, (LinkedList<ModuleG>) modulesS2, getArguments().getInt(ARG_SECTION_NUMBER));
                return rootView;
            } else {
                return recapView;
            }

        }


        void initSlider(){
            viewPager = (ViewPager) rootView.findViewById(R.id.view_pager);
            dotsLayout = (LinearLayout) rootView.findViewById(R.id.layoutDots);
            btnSkip = (Button) rootView.findViewById(R.id.btn_skip);
            btnNext = (Button) rootView.findViewById(R.id.btn_next);

            // layouts of all welcome sliders
            // add few more layouts if you want
            layouts = new int[]{
                    R.layout.slide_modules_recap,
                    R.layout.slide_notes_recap,
                    R.layout.slide_cred_recap,
                    R.layout.slide_units_recap};

            // adding bottom dots
            addBottomDots(0);
            ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageSelected(int position) {
                    addBottomDots(position);
                }

                @Override
                public void onPageScrolled(int arg0, float arg1, int arg2) {

                }

                @Override
                public void onPageScrollStateChanged(int arg0) {

                }
            };

            myViewPagerAdapter = new MyViewPagerAdapter();
            viewPager.setAdapter(myViewPagerAdapter);
            viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

            /**btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
            launchHomeScreen();
            }
            });**/

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    current = getItem(+1);
                    if (current < layouts.length) {
                        viewPager.setCurrentItem(current);
                    } else {
                        current = 0;
                        viewPager.setCurrentItem(current);
                        addBottomDots(0);
                    }
                }
            });
        }

        void initAddModuleBoom(){

            BoomMenuButton bmb = (BoomMenuButton) rootView.findViewById(R.id.bmb);

            bmb.setButtonEnum(ButtonEnum.TextOutsideCircle);

            bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_2_1);
            bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_2_1);

            for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++)
                bmb.addBuilder(BuilderManager.AddModule());

            bmb.setOnBoomListener(new OnBoomListener() {
                @Override
                public void onClicked(int index, BoomButton boomButton) {
                    if (index == 0) {
                        NotesListAdapter notesManager = notesListAdapterS2;
                        if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                            notesManager = notesListAdapterS1;
                        }
                        ModuleCustomizePopup popup = new ModuleCustomizePopup();
                        ModuleG newModule = new ModuleG("new module");
                        User user = new User(loggedUserId);
                        popup.setModule(year, newModule, notesManager, user);
                        FragmentTransaction manager = Launcher.getInstance().getFT();
                        manager.addToBackStack(null);
                        popup.show(manager, null);
                    }
                }

                @Override
                public void onBackgroundClick() {

                }

                @Override
                public void onBoomWillHide() {

                }

                @Override
                public void onBoomDidHide() {

                }

                @Override
                public void onBoomWillShow() {

                }

                @Override
                public void onBoomDidShow() {

                }
            });
        }

        private void addBottomDots(int currentPage) {
            dots = new TextView[layouts.length];

            int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
            int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

            dotsLayout.removeAllViews();
            for (int i = 0; i < dots.length; i++) {
                dots[i] = new TextView(getContext());
                dots[i].setText(Html.fromHtml("&#8226;"));
                dots[i].setTextSize(35);
                dots[i].setTextColor(colorsInactive[currentPage]);
                dotsLayout.addView(dots[i]);
            }

            if (dots.length > 0)
                dots[currentPage].setTextColor(colorsActive[currentPage]);
        }

        private int getItem(int i) {
            return viewPager.getCurrentItem() + i;
        }

        private void recyclerViewOnTouch(final RecyclerView recyclerView, final NotesListAdapter notesListAdapter, final Context context) {
            recyclerView.addOnItemTouchListener(
                    new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, final int position) {
                            showPopup(view, position, context, notesListAdapter, recyclerView);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            // do whatever
                            // Intent intent = new Intent(context, PieChartFrag.class);
                            //startActivity(intent);
                        }
                    })
            );
        }

        public void setSemesterMoy(TableRow tableRowMoy, LinkedList<ModuleG> modules, int semester) {
            TextView tvTextMoy = (TextView) tableRowMoy.findViewById(R.id.textMoyS);
            TextView tvMoy = (TextView) tableRowMoy.findViewById(R.id.moyS);
            Semestre s1 = getSemester(semester, modules);
            double moy = 0;
            if (s1.getNbUnit() != 0) {
                moy = Calcul.moySemester(s1);
            }
            //String moyen = String.valueOf(moy);
            String u = "" + Math.floor(moy * 100) / 100;
            tvMoy.setText(u);
            int red = Color.parseColor("#EF5350");
            int def = Color.parseColor("#66BB6A");
            if (moy < 10) {
                tvMoy.setBackgroundColor(red);
                tvTextMoy.setBackgroundColor(red);
            } else {
                tvMoy.setBackgroundColor(def);
                tvTextMoy.setBackgroundColor(def);
            }

        }

        public void setSemesterCred(TableRow tableRowCred, LinkedList<ModuleG> modules, int semester) {
            TextView tvTextCred = (TextView) tableRowCred.findViewById(R.id.textCredTotalS);
            TextView tvCred = (TextView) tableRowCred.findViewById(R.id.credS);
            Semestre s1 = getSemester(semester, modules);
            int cred = 0;
            if (s1.getNbUnit() != 0) {
                cred = Calcul.credSemester(s1);
            }
            //String moyen = String.valueOf(moy);
            String u = "" + cred;
            tvCred.setText(u);
            int red = Color.parseColor("#EF5350");
            int def = Color.parseColor("#66BB6A");
            if (cred < Calcul.defCredSemester(s1)) {
                tvCred.setBackgroundColor(red);
                tvTextCred.setBackgroundColor(red);
            } else {
                tvCred.setBackgroundColor(def);
                tvTextCred.setBackgroundColor(def);
            }

        }

        private Semestre getSemester(int semesterid, LinkedList<ModuleG> modules) {
            Semestre s1 = new Semestre(semesterid);
            for (ModuleG module : modules) {
                if (module.getSemester() == semesterid) {
                    s1.setSemester(getUnits(modules, semesterid));
                }
            }
            return s1;
        }

        private LinkedList<Unit> getUnits(LinkedList<ModuleG> modules, int semesterid) {

            LinkedList<Unit> u = new LinkedList<Unit>();
            Unit[] un = new Unit[11];
            for (int i = 0; i < un.length; i++) {
                un[i] = new Unit(i);
            }
            for (ModuleG module : modules) {
                for (int j = 1; j < un.length; j++) {
                    if (module.getUnitId() == j) {
                        un[j].addModule(module);
                    }
                }
            }

            Collections.addAll(u, un);

            return u;
        }


        private void showPopup(View view, final int position, final Context context, final NotesListAdapter notesListAdapter, final RecyclerView recyclerView) {

            final ModuleG module = notesListAdapter.getModule(position);
            final Dialog popUpWindow = new Dialog(context);

            LayoutInflater factory = LayoutInflater.from(context);
            View myView = factory.inflate(R.layout.edit_notes_popup, null);

            LinearLayout layout = new LinearLayout(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setLayoutParams(params);
            layout.addView(myView);
            final EditText tp, td, control;
            TextView moduleNametv;
            moduleNametv = (TextView) myView.findViewById(R.id.textView3);
            tp = (EditText) myView.findViewById(R.id.note_tp);
            td = (EditText) myView.findViewById(R.id.note_td);
            control = (EditText) myView.findViewById(R.id.note_control);

            android.widget.Space sp1 = (android.widget.Space) myView.findViewById(R.id.sp1);
            android.widget.Space sp2 = (android.widget.Space) myView.findViewById(R.id.sp2);
            moduleNametv.setText(module.getModuleName());
            sp1.setVisibility(View.GONE);
            sp2.setVisibility(View.GONE);
            if (!module.isTdState()) {
                td.setVisibility(View.GONE);
                sp1.setVisibility(View.GONE);
            }
            if (!module.isTpState()) {
                tp.setVisibility(View.GONE);
                sp2.setVisibility(View.GONE);
            }
            tp.setText("" + module.getTp());
            td.setText("" + module.getTd());
            control.setText("" + module.getCont());
            Button confirm = (Button) myView.findViewById(R.id.button5);
            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (validate(tp, td, control)) {
                        module.setCont(Double.parseDouble(control.getText().toString()));
                        if (module.isTdState()) {
                            module.setTd(Double.parseDouble(td.getText().toString()));
                        }
                        if (module.isTpState()) {
                            module.setTp(Double.parseDouble(tp.getText().toString()));
                        }
                        module.setMoy(Calcul.moyModule(module));
                        module.setCred(Calcul.credModule(module));

                        ModulesTableManager db = new ModulesTableManager(context);
                        db.open();
                        db.addModule(module);
                        mod = (LinkedList<ModuleG>) NotesListContent.getModulesList(db, module.getUserId(), module.getYearId());
                        notesListAdapter.getListData().clear();
                        notesListAdapter.getListData().addAll(NotesListContent.getModulesList(db, module.getUserId(), module.getYearId()));
                        notesListAdapter.notifyDataSetChanged();

                        setSemesterMoy(tr, mod, sem);
                        setSemesterCred(tr, mod, sem);
                        popUpWindow.dismiss();
                    }
                }

                private boolean validate(EditText tp, EditText td, EditText cont) {


                    boolean valid = true;

                    double _tp = Double.valueOf(tp.getText().toString());
                    if (_tp == 0 || _tp < 0 || _tp > 20 || tp.getText().toString().equals("")) {
                        tp.setError("valeur entre 0 and 20");
                        valid = false;
                    }
                    double _td = Double.valueOf(td.getText().toString());
                    if (_td == 0 || _td < 0 || _td > 20 || td.getText().toString().equals("")) {
                        td.setError("valeur entre 0 and 20");
                        valid = false;
                    }
                    double _cont = Double.valueOf(cont.getText().toString());
                    if (_cont == 0 || _cont < 0 || _cont > 20 || cont.getText().toString().equals("")) {
                        cont.setError("valeur entre 0 and 20");
                        valid = false;
                    }
                    return valid;
                }
            });

            myView.setLayoutParams(new LinearLayout.LayoutParams(500, LinearLayout.LayoutParams.WRAP_CONTENT));

            popUpWindow.setContentView(layout);

            popUpWindow.show();
        }


        private List<ModuleG> modulesInSem(int i, List<ModuleG> modules) {
            List<ModuleG> x = new LinkedList<>();
            for (ModuleG module : modules) {
                if (module.getSemester() == i)
                    x.add(module);
            }
            return x;
        }

        private List<String> getData() {
            List<String> data = new ArrayList<>();
            for (int p = 0; p < PiecePlaceEnum.values().length - 1; p++) {
                for (int b = 0; b < ButtonPlaceEnum.values().length - 1; b++) {
                    PiecePlaceEnum piecePlaceEnum = PiecePlaceEnum.getEnum(p);
                    ButtonPlaceEnum buttonPlaceEnum = ButtonPlaceEnum.getEnum(b);
                    if (piecePlaceEnum.pieceNumber() == buttonPlaceEnum.buttonNumber()
                            || buttonPlaceEnum == ButtonPlaceEnum.Horizontal
                            || buttonPlaceEnum == ButtonPlaceEnum.Vertical) {
                        piecesAndButtons.add(new Pair<>(piecePlaceEnum, buttonPlaceEnum));
                        data.add(piecePlaceEnum + " " + buttonPlaceEnum);
                        if (piecePlaceEnum.getValue() < PiecePlaceEnum.HAM_1.getValue()
                                || piecePlaceEnum == PiecePlaceEnum.Share
                                || buttonPlaceEnum.getValue() < ButtonPlaceEnum.HAM_1.getValue()) {
                            piecesAndButtons.remove(piecesAndButtons.size() - 1);
                            data.remove(data.size() - 1);
                        }
                    }
                }
            }
            return data;
        }

        public void setSemesterMoy() {
            setSemesterMoy(tr, mod, sem);
        }

        public void setSemesterCred() {
            setSemesterCred(tr, mod, sem);
        }


        public class MyViewPagerAdapter extends PagerAdapter {
            private LayoutInflater layoutInflater;

            public MyViewPagerAdapter() {
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = layoutInflater.inflate(layouts[position], container, false);
                container.addView(view);
                Log.e("initItem","position= "+position);
                return view;
            }

            @Override
            public int getCount() {
                return layouts.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object obj) {
                return view == obj;
            }


            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                View view = (View) object;
                container.removeView(view);
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









