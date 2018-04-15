package com.Oenologie.oenologie.Fragments;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.Oenologie.oenologie.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Fragment_Accueil extends Fragment {

    public Fragment_Accueil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_accueil, container, false);
    }

}
