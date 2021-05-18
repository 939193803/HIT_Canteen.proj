package com.qiafan.hitcanteen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FragmentRecommendation extends Fragment {
    public FragmentRecommendation(){
        super();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.main_top_fragment_recommendation, container, false);
        v.setId(View.generateViewId());
        return v;
    }
}
