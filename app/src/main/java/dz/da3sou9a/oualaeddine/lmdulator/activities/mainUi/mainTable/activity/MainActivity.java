package dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi.mainTable.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi.dashboard.Dashboard;
import dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi.mainTable.fragments.FragmentOne;
import dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi.mainTable.fragments.FragmentTwo;


public class MainActivity extends AppCompatActivity {

    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;
    private TabLayout allTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getAllWidgets();
        bindWidgetsWithAnEvent();
        setupTabLayout();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, Dashboard.class);
        startActivity(i);
    }

    private void getAllWidgets() {
        allTabs = (TabLayout) findViewById(R.id.tabs);
    }

    private void setupTabLayout() {
        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        allTabs.addTab(allTabs.newTab().setText("Semestre 1"), true);
        allTabs.addTab(allTabs.newTab().setText("semestre 2"));
    }

    private void bindWidgetsWithAnEvent() {
        allTabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setCurrentTabFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void setCurrentTabFragment(int tabPosition) {
        switch (tabPosition) {
            case 0:
                replaceFragment(fragmentOne);
                break;
            case 1:
                replaceFragment(fragmentTwo);
                break;
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_container, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}
