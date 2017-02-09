package dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Space;
import android.widget.Switch;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.OnBoomListener;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.UserSessionManager;
import dz.da3sou9a.oualaeddine.lmdulator.activities.frags.ModuleCustomizePopup;
import dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi.components.BuilderManager;
import dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi.components.RecyclerItemClickListener;
import dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi.dashboard.Dashboard;
import dz.da3sou9a.oualaeddine.lmdulator.activities.notesTableAdapter.NotesListAdapter;
import dz.da3sou9a.oualaeddine.lmdulator.activities.notesTableAdapter.NotesListContent;
import dz.da3sou9a.oualaeddine.lmdulator.db.ModulesTableManager;
import dz.da3sou9a.oualaeddine.lmdulator.db.UnitsTableManager;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;
import dz.da3sou9a.oualaeddine.lmdulator.items.Semestre;
import dz.da3sou9a.oualaeddine.lmdulator.items.Unit;
import dz.da3sou9a.oualaeddine.lmdulator.items.User;
import dz.da3sou9a.oualaeddine.lmdulator.miche.Calcul;

public class Launcher extends AppCompatActivity {
    static int pos;

    public static Launcher instance;

    public static PlaceholderFragment getFrag() {
        return Frag;
    }

    public static PlaceholderFragment Frag;
    public static int semester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_launcher);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        instance = this;

        initActionBar();
        //initFabBoom();
        initFab();

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

    private void initFab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Frag.addModule(Launcher.this);
            }
        });
    }

    public static Launcher getInstance() {
        return instance;
    }

    public FragmentTransaction getFT() {
        return getSupportFragmentManager().beginTransaction();
    }

    private void initActionBar() {
        ActionBar mActionBar = getSupportActionBar();
        assert mActionBar != null;
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setHomeButtonEnabled(true);

        LayoutInflater mInflater = LayoutInflater.from(this);

        View actionBar = mInflater.inflate(R.layout.custom_actionbar, null);
        mActionBar.setCustomView(actionBar);
        mActionBar.setDisplayShowCustomEnabled(true);
        ((Toolbar) actionBar.getParent()).setContentInsetsAbsolute(0, 0);

        initActionBarBoom(actionBar);

    }

    @Override
    public void onBackPressed() {
        //TODO:create goodby intent
        //   moveTaskToBack(true);
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }

    /**
     * void initFabBoom() {
     * BoomMenuButton fabBmb = (BoomMenuButton) findViewById(R.id.boomFabAddModule);
     * fabBmb.setButtonEnum(ButtonEnum.TextOutsideCircle);
     * fabBmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_1);
     * fabBmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_1);
     * <p>
     * for (int i = 0; i < fabBmb.getPiecePlaceEnum().pieceNumber(); i++)
     * fabBmb.addBuilder(BuilderManager.AddModule());
     * <p>
     * <p>
     * fabBmb.setOnBoomListener(new OnBoomListener() {
     *
     * @Override public void onClicked(int index, BoomButton boomButton) {
     * Frag.addModule(Launcher.this);
     * }
     * @Override public void onBackgroundClick() {
     * <p>
     * }
     * @Override public void onBoomWillHide() {
     * <p>
     * }
     * @Override public void onBoomDidHide() {
     * <p>
     * }
     * @Override public void onBoomWillShow() {
     * <p>
     * }
     * @Override public void onBoomDidShow() {
     * <p>
     * }
     * });
     * }
     */

    void initActionBarBoom(final View actionBar) {
        BoomMenuButton leftBmb = (BoomMenuButton) actionBar.findViewById(R.id.action_bar_left_bmb);

        leftBmb.setButtonEnum(ButtonEnum.Ham);
        leftBmb.setPiecePlaceEnum(PiecePlaceEnum.HAM_6);
        leftBmb.setButtonPlaceEnum(ButtonPlaceEnum.HAM_6);

        for (int i = 0; i < leftBmb.getPiecePlaceEnum().pieceNumber(); i++)
            leftBmb.addBuilder(BuilderManager.getLauncherMenuBoutton());

        leftBmb.setOnBoomListener(new OnBoomListener() {
            @Override
            public void onClicked(int index, BoomButton boomButton) {
                actionBarBoomAction(index);
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

    private void actionBarBoomAction(int index) {
        Toast.makeText(Launcher.this, "Clicked " + index, Toast.LENGTH_SHORT).show();
        Intent intent;
        switch (index) {
            case 0: {
                intent = new Intent(Launcher.this, Dashboard.class);
                startActivity(intent);
                break;
            }
            case 1: {
                intent = new Intent(Launcher.this, UserSettings.class);
                startActivity(intent);
                break;
            }
            case 2: {
                intent = new Intent(Launcher.this, Settings.class);
                startActivity(intent);
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 5: {
                UserSessionManager userSessionManager = new UserSessionManager(this);
                userSessionManager.setCurrentYearId(0);
                intent = new Intent(Launcher.this, Loader.class);
                startActivity(intent);
                break;
            }


        }
    }

    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        private static final String ARG_SECTION_NUMBER = "section_number";
        static View rootView, recapView, rootView2;
        private static int sem;
        private static LinkedList<ModuleG> mod;
        private static NotesListAdapter notesListAdapterS1, notesListAdapterS2;
        private static int loggedUserId;
        private static int year;

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
        static int current = 0;
        static RecyclerView recyclerView;

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            Frag = fragment;
            return fragment;
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            recapView = inflater.inflate(R.layout.fragment_notes_recap, container, false);
            rootView = inflater.inflate(R.layout.fragment_tableau_notes, container, false);
            rootView2 = inflater.inflate(R.layout.fragment_tableau_notes, container, false);
            initSession();

            return initFrag();
        }

        void initSession() {
            UserSessionManager userSessionManager = new UserSessionManager(getContext());
            final HashMap loggedUser = userSessionManager.getUserDetails();
            loggedUserId = Integer.valueOf(loggedUser.get("userId").toString());
            year = userSessionManager.getSessionYear();
        }

        private View initFrag() {

            ModulesTableManager db = new ModulesTableManager(getContext());
            db.open();
            List<ModuleG> modules = NotesListContent.getModulesList(db, loggedUserId, year);
            List<ModuleG> modulesS1 = modulesInSem(1, modules);
            List<ModuleG> modulesS2 = modulesInSem(2, modules);

            notesListAdapterS1 = new NotesListAdapter(modulesS1, getContext());
            notesListAdapterS2 = new NotesListAdapter(modulesS2, getContext());

            mod = (LinkedList<ModuleG>) modules;
            sem = getArguments().getInt(ARG_SECTION_NUMBER);

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                initFragContent(notesListAdapterS1, 1);
                return rootView;
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                initFragContent(notesListAdapterS2, 2);
                return rootView2;
            } else {
                return recapView;
            }
        }

        static int semesterG;

        void initFragContent(NotesListAdapter notesListAdapter, int i) {
            semesterG = i;
            if (i == 1)
                recyclerView = (RecyclerView) rootView.findViewById(R.id.units_list_rec);
            else
                recyclerView = (RecyclerView) rootView2.findViewById(R.id.units_list_rec);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(notesListAdapter);
            recyclerViewOnTouch(recyclerView, notesListAdapter, getContext());
            // initSlider();
            setSemesterMoy(getArguments().getInt(ARG_SECTION_NUMBER));
            setSemesterCred(getArguments().getInt(ARG_SECTION_NUMBER));
        }


        /* private void addModulePopup() {
             ModuleCustomizePopup popup = new ModuleCustomizePopup();
             FragmentTransaction manager = Launcher.getInstance().getFT();
             manager.addToBackStack(null);
             popup.show(manager, null);
             refreshItems();
         }*/
        void initSlider() {
            viewPager = (ViewPager) rootView.findViewById(R.id.view_pager);
            dotsLayout = (LinearLayout) rootView.findViewById(R.id.layoutDots);
            btnSkip = (Button) rootView.findViewById(R.id.btn_skip);
            btnNext = (Button) rootView.findViewById(R.id.btn_next);

            // add few more layouts if you want
            layouts = new int[]{
                    R.layout.slide_modules_recap,
                    R.layout.slide_notes_recap,
                    R.layout.slide_cred_recap,
                    R.layout.slide_units_recap
            };

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


        public void refreshItems() {
            notesListAdapterS1.notifyDataSetChanged();
            notesListAdapterS2.notifyDataSetChanged();

            if (semesterG == 1) {
                notesListAdapterS1.notifyDataSetChanged();
                recyclerView.swapAdapter(notesListAdapterS1, true);
            } else {
                notesListAdapterS2.notifyDataSetChanged();
                recyclerView.swapAdapter(notesListAdapterS2, true);
            }
            //initFrag();
            setSemesterCred(sem);
            setSemesterMoy(sem);
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
                            showPopupEditNote(position, context, notesListAdapter);
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

        /**************************************************************************************************/
        public void setSemesterMoy(int semester) {
            TableRow tableRowMoy;
            if (semesterG == 1)
                tableRowMoy = (TableRow) rootView.findViewById(R.id.MoyCredTR);
            else
                tableRowMoy = (TableRow) rootView2.findViewById(R.id.MoyCredTR);

            TextView tvTextMoy = (TextView) tableRowMoy.findViewById(R.id.textMoyS);
            TextView tvMoy = (TextView) tableRowMoy.findViewById(R.id.moyS);
            List<ModuleG> modules = new ModulesTableManager(getContext()).getModules(loggedUserId, year);
            if (semester == 1) {
                modules = notesListAdapterS1.getListData();
            } else {
                modules = notesListAdapterS2.getListData();
            }
            Semestre s1 = getSemester(semester, (LinkedList<ModuleG>) modules);
            double moy = 0;
            if (s1.getNbUnit() != 0) {
                moy = Calcul.moySemester(s1);
            }
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

        public void setSemesterCred(int semester) {
            TableRow tableRowCred;
            if (semester == 1)
                tableRowCred = (TableRow) rootView.findViewById(R.id.MoyCredTR);
            else
                tableRowCred = (TableRow) rootView2.findViewById(R.id.MoyCredTR);


            TextView tvTextCred = (TextView) tableRowCred.findViewById(R.id.textCredTotalS);
            TextView tvCred = (TextView) tableRowCred.findViewById(R.id.credS);
            List<ModuleG> modules ;
            if (semester == 1) {
                modules = notesListAdapterS1.getListData();
            } else {
                modules = notesListAdapterS2.getListData();
            }
            Semestre s = getSemester(semester, (LinkedList<ModuleG>) modules);
            int cred = 0;
            if (s.getNbUnit() != 0) {
                cred = Calcul.credSemester(s);
            }
            String u = "" + cred;
            tvCred.setText(u);
            int red = Color.parseColor("#EF5350");
            int def = Color.parseColor("#66BB6A");
            if (cred < Calcul.defCredSemester(s)) {
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
                    s1.setSemester(getUnits(modules));
                }
            }
            return s1;
        }

        private LinkedList<Unit> getUnits(LinkedList<ModuleG> modules) {

            LinkedList<Unit> u = new LinkedList<>();
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

        private List<ModuleG> modulesInSem(int i, List<ModuleG> modules) {
            List<ModuleG> x = new LinkedList<>();
            for (ModuleG module : modules) {
                if (module.getSemester() == i)
                    x.add(module);
            }
            return x;
        }

        /**************************************************************************************************/


        private void addModule(Context context) {

            final Dialog popUpWindow = new Dialog(context);
            popUpWindow.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {

                }
            });
            LayoutInflater factory = LayoutInflater.from(context);
            final View myView = factory.inflate(R.layout.module_customizer, null);

            Button btnSave = (Button) myView.findViewById(R.id.button2);
            Button btnCancel = (Button) myView.findViewById(R.id.button);

            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (validate(myView)) {
                        addModuleTodDb(myView);
                        refreshItems();
                        popUpWindow.dismiss();
                    }
                }
            });
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    refreshItems();
                    popUpWindow.dismiss();
                }
            });
            LinearLayout layout = new LinearLayout(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setLayoutParams(params);
            layout.addView(myView);
            myView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            popUpWindow.setContentView(layout);
            popUpWindow.show();
        }

        public void addModuleTodDb(View view) {


            User user = new User(loggedUserId);


            EditText _unit = (EditText) view.findViewById(R.id.unit);
            EditText _semester = (EditText) view.findViewById(R.id.semester);
            EditText _cred = (EditText) view.findViewById(R.id.cred);
            EditText _coef = (EditText) view.findViewById(R.id.coef);
            Switch _isTp = (Switch) view.findViewById(R.id.isTp);
            Switch _isTd = (Switch) view.findViewById(R.id.isTd);
            ImageView _icon = (ImageView) view.findViewById(R.id.imageButton2);
            EditText _moduleName = (EditText) view.findViewById(R.id.editText2);

            Unit unit = new Unit(_unit.getText().toString());
            ModuleG newModule = new ModuleG(_moduleName.getText().toString());

            UnitsTableManager udb = new UnitsTableManager(getContext());
            udb.addUnit(unit, user, year);

            newModule.setUserId(loggedUserId);
            newModule.setCoef(Integer.valueOf(_coef.getText().toString()));
            newModule.setDefCred(Integer.valueOf(_cred.getText().toString()));
            newModule.setModuleName(_moduleName.getText().toString());
            newModule.setTdState(_isTd.isChecked());
            newModule.setTpState(_isTp.isChecked());
            newModule.setUnitId(Integer.parseInt(_unit.getText().toString()));
            newModule.setSemester(Integer.parseInt(_semester.getText().toString()));
            newModule.setYearId(year);
            ModulesTableManager db = new ModulesTableManager(getContext());
            db.open();
            db.addModule(newModule);
            mod = (LinkedList<ModuleG>) NotesListContent.getModulesList(db, loggedUserId, year);

        }


        public boolean validate(View view) {
            final EditText _cred = (EditText) view.findViewById(R.id.cred);
            final EditText _coef = (EditText) view.findViewById(R.id.coef);
            final EditText _moduleName = (EditText) view.findViewById(R.id.editText2);
            final EditText _semester = (EditText) view.findViewById(R.id.semester);

            boolean valid = true;
            try {
                String name = _moduleName.getText().toString();

                if (name.isEmpty()) {
                    _moduleName.setError("you must enter the module name");
                    valid = false;
                } else {
                    _moduleName.setError(null);
                }
            } catch (Exception e) {
                _moduleName.setError("you must enter the module name");
                valid = false;
            }

            try {
                int cred = Integer.valueOf(_cred.getText().toString());
                if (cred == 0 || cred < 1 || cred > 10) {
                    _cred.setError("between 1 and 10");
                    valid = false;
                } else {
                    _cred.setError(null);
                }
            } catch (Exception e) {
                _cred.setError("enter valid number");
                valid = false;
            }
            try {
                int sem = Integer.valueOf(_semester.getText().toString());
                if (sem < 1 || sem > 2) {
                    _semester.setError("1 or 2");
                    valid = false;
                } else {
                    _semester.setError(null);
                }
            } catch (Exception e) {
                _semester.setError("enter valid number");
                valid = false;
            }

            try {
                int coef = Integer.valueOf(_coef.getText().toString());
                if (coef == 0 || coef < 1 || coef > 10) {
                    _coef.setError("between 1 and 10");
                    valid = false;
                } else {
                    _coef.setError(null);
                }
            } catch (Exception e) {
                _coef.setError("enter valid number");
                valid = false;
            }
            return valid;
        }

        private void showPopupEditNote(final int position, final Context context, final NotesListAdapter notesListAdapter) {

            final ModuleG module = notesListAdapter.getModule(position);
            final Dialog popUpWindow = new Dialog(context);
            popUpWindow.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {

                }
            });
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

            Space sp1 = (Space) myView.findViewById(R.id.sp1);
            Space sp2 = (Space) myView.findViewById(R.id.sp2);
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
            String tpv = "" + module.getTp();
            String tdv = "" + module.getTd();
            String contd = "" + module.getCont();
            tp.setText(tpv);
            td.setText(tdv);
            control.setText(contd);
            Button confirm = (Button) myView.findViewById(R.id.button5);
            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (validate(tp, td, control)) {
                        module.setCont(Double.parseDouble(control.getText().toString()));
                        if (module.isTdState()) {
                            module.setTd(Double.parseDouble(td.getText().toString()));
                        } else {
                            module.setTd(0);
                        }
                        if (module.isTpState()) {
                            module.setTp(Double.parseDouble(tp.getText().toString()));
                        } else {
                            module.setTp(0);
                        }
                        module.setMoy(Calcul.moyModule(module));
                        module.setCred(Calcul.credModule(module));

                        ModulesTableManager db = new ModulesTableManager(context);
                        db.open();
                        db.addModule(module);
                        mod = (LinkedList<ModuleG>) NotesListContent.getModulesList(db, module.getUserId(), module.getYearId());
                        /*setSemesterMoy(sem);
                        setSemesterCred(sem);*/
                        refreshItems();
                        popUpWindow.dismiss();
                    }
                }

                private boolean validate(EditText tp, EditText td, EditText cont) {
                    boolean valid = true;

                    double _tp = Double.valueOf(tp.getText().toString());
                    if (_tp < 0 || _tp > 20 || tp.getText().toString().equals("")) {
                        tp.setError("valeur entre 0 and 20");
                        valid = false;
                    }
                    double _td = Double.valueOf(td.getText().toString());
                    if (_td < 0 || _td > 20 || td.getText().toString().equals("")) {
                        td.setError("valeur entre 0 and 20");
                        valid = false;
                    }
                    double _cont = Double.valueOf(cont.getText().toString());
                    if (_cont < 0 || _cont > 20 || cont.getText().toString().equals("")) {
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

        public class MyViewPagerAdapter extends PagerAdapter {
            private LayoutInflater layoutInflater;

            MyViewPagerAdapter() {
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = layoutInflater.inflate(layouts[position], container, false);
                container.addView(view);
                Log.e("initItem", "position= " + position);
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
                Frag.refreshItems();
            }
        }

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
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









