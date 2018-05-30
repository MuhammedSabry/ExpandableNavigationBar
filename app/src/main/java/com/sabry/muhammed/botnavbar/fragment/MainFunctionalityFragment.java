package com.sabry.muhammed.botnavbar.fragment;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.sabry.muhammed.botnavbar.ButtonAdapter;
import com.sabry.muhammed.botnavbar.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainFunctionalityFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("InflateParams")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment_layout, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridView gridView = view.findViewById(R.id.mainGridView);
        List<String> buttonNames = new ArrayList<>(6);
        Collections.addAll(buttonNames, "First", "Second", "Third", "Fourth", "Fifth", "Sixth");
        List<Drawable> buttonDrawables = new ArrayList<>(6);
        Drawable drawable = getResources().getDrawable(R.drawable.ic_close);
        Collections.addAll(buttonDrawables, drawable, drawable, drawable, drawable, drawable, drawable);
        gridView.setAdapter(new ButtonAdapter(this.getContext(), buttonNames, buttonDrawables));
    }
}
