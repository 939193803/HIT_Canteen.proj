package com.qiafan.hitcanteen;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.zip.Inflater;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button intel, recommendation, privateintel;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private DrawerLayout drawerlayout;
    private ActionBar actionBar;

    @Override
    public void onClick(View v){
        Log.d("TAG", "Enter Onclick");
        switch(v.getId()){
            case R.id.drawerCaller:
                drawerlayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.button_intel:
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.main_top_fragment, new FragmentIntel());
                ft.commit();
                break;
            case R.id.button_recommendation:
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.main_top_fragment, new FragmentRecommendation());
                ft.commit();
                break;
            case R.id.button_privateintel:
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.main_top_fragment, new FragmentPrivateIntel());
                ft.commit();
                break;
            default:
                break;
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main_activity);

        LayoutInflater inflater = getLayoutInflater();
        View actionBarView = inflater.inflate(R.layout.toolbar, null);
        ((ImageButton)actionBarView.findViewById(R.id.drawerCaller)).setOnClickListener(this);
        actionBar = (ActionBar)getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM,ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME| ActionBar.DISPLAY_SHOW_TITLE);
        actionBar.setCustomView(actionBarView);

        Toolbar parent = (Toolbar)actionBarView.getParent();
        parent.setPadding(0,0,0,0);
        parent.setContentInsetsAbsolute(0,0);

        drawerlayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        intel = findViewById(R.id.button_intel);
        recommendation = findViewById(R.id.button_recommendation);
        privateintel = findViewById(R.id.button_privateintel);



        intel.setOnClickListener(this);
        recommendation.setOnClickListener(this);
        privateintel.setOnClickListener(this);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.main_top_fragment, new FragmentIntel());
        ft.commit();

    }
}

