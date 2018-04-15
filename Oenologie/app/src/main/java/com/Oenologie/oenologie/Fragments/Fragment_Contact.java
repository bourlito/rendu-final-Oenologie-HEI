package com.Oenologie.oenologie.Fragments;


import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Oenologie.oenologie.R;

/**
 * A simple {@link Fragment} subclass.
 * pas encore fait
 */
public class Fragment_Contact extends Fragment {

    private CardView cv2;
    private CardView cv3;
    private CardView cv4;

    public Fragment_Contact() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cv2 = view.findViewById(R.id.cv2);
        cv3 = view.findViewById(R.id.cv3);
        cv4 = view.findViewById(R.id.cv4);

        //gestion des clics sur les widgets CardView et redirection vers les sites web adequats
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "www.carliervogliazzo.com");
                startActivity(intent);
            }
        });

        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "https://www.cavistecurieux.fr/");
                startActivity(intent);
            }
        });

        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "https://www.lesvinsdaurelien.fr");
                startActivity(intent);
            }
        });
    }
}
