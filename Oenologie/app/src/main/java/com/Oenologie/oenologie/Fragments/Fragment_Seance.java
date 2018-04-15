package com.Oenologie.oenologie.Fragments;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Oenologie.oenologie.Fragments.Fragments_Seances.Fragment_Seance_1;
import com.Oenologie.oenologie.Fragments.Fragments_Seances.Fragment_Seance_2;
import com.Oenologie.oenologie.Fragments.Fragments_Seances.Fragment_Seance_3;
import com.Oenologie.oenologie.Fragments.Fragments_Seances.ViewPagerAdapter;
import com.Oenologie.oenologie.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Fragment_Seance extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    public Fragment_Seance() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_seance, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewpager);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());

        //creation des seances
        viewPagerAdapter.addFragment(new Fragment_Seance_1(), "Seance 1");
        viewPagerAdapter.addFragment(new Fragment_Seance_2(), "Seance 2");
        viewPagerAdapter.addFragment(new Fragment_Seance_3(), "Seance 3");

        //affichage du menu des seances
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
