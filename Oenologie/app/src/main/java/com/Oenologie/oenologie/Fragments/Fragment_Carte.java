package com.Oenologie.oenologie.Fragments;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.Oenologie.oenologie.InfosCepageActivity;
import com.Oenologie.oenologie.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Fragment_Carte extends Fragment {

    private ImageView ivLoire;
    private ImageView ivLoire2;
    private ImageView ivBordeaux;
    private ImageView ivSudOuest;
    private ImageView ivSudOuest2;
    private ImageView ivLanguedoc;
    private ImageView ivProvenceCorse;
    private ImageView ivProvenceCorse2;
    private ImageView ivRhone;
    private ImageView ivSavoie;
    private ImageView ivBourgogne;
    private ImageView ivChampagne;
    private ImageView ivAlsace;
    private ImageView ivLorraine;
    private ImageView ivCarte;

    public Fragment_Carte() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_carte, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ivLoire = view.findViewById(R.id.iv_loire);
        ivLoire2 = view.findViewById(R.id.iv_loire2);
        ivAlsace = view.findViewById(R.id.iv_alsace);
        ivBordeaux = view.findViewById(R.id.iv_bordeaux);
        ivBourgogne = view.findViewById(R.id.iv_bourgogne);
        ivChampagne = view.findViewById(R.id.iv_champagne);
        ivLanguedoc = view.findViewById(R.id.iv_languedoc);
        ivLorraine = view.findViewById(R.id.iv_lorraine);
        ivProvenceCorse = view.findViewById(R.id.iv_provencecorse);
        ivProvenceCorse2 = view.findViewById(R.id.iv_provencecorse2);
        ivRhone = view.findViewById(R.id.iv_rhone);
        ivSavoie = view.findViewById(R.id.iv_savoie);
        ivSudOuest = view.findViewById(R.id.iv_sudouest);
        ivSudOuest2 = view.findViewById(R.id.iv_sudouest2);
        ivCarte = view.findViewById(R.id.iv_carte);


        //gestion des clics sur la carte
        ivLoire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfosCepageActivity.class);
                intent.putExtra("zone","Loire");
                startActivity(intent);
            }
        });

        ivLoire2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfosCepageActivity.class);
                intent.putExtra("zone","Loire");
                startActivity(intent);
            }
        });

        ivProvenceCorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfosCepageActivity.class);
                intent.putExtra("zone","Provence & Corse");
                startActivity(intent);
            }
        });

        ivProvenceCorse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfosCepageActivity.class);
                intent.putExtra("zone","Provence & Corse");
                startActivity(intent);
            }
        });

        ivSudOuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfosCepageActivity.class);
                intent.putExtra("zone","Sud-Ouest");
                startActivity(intent);
            }
        });

        ivSudOuest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfosCepageActivity.class);
                intent.putExtra("zone","Sud-Ouest");
                startActivity(intent);
            }
        });

        ivSavoie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfosCepageActivity.class);
                intent.putExtra("zone","Savoie");
                startActivity(intent);
            }
        });

        ivRhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfosCepageActivity.class);
                intent.putExtra("zone","Rhône");
                startActivity(intent);
            }
        });

        ivLorraine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfosCepageActivity.class);
                intent.putExtra("zone","Lorraine");
                startActivity(intent);
            }
        });

        ivLanguedoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfosCepageActivity.class);
                intent.putExtra("zone","Languedoc");
                startActivity(intent);
            }
        });

        ivChampagne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfosCepageActivity.class);
                intent.putExtra("zone","Champagne");
                startActivity(intent);
            }
        });

        ivBourgogne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfosCepageActivity.class);
                intent.putExtra("zone","Bourgogne");
                startActivity(intent);
            }
        });
        super.onViewCreated(view, savedInstanceState);

        ivBordeaux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfosCepageActivity.class);
                intent.putExtra("zone","Bordeaux");
                startActivity(intent);
            }
        });

        ivAlsace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfosCepageActivity.class);
                intent.putExtra("zone","Alsace");
                startActivity(intent);
            }
        });
    }
}
