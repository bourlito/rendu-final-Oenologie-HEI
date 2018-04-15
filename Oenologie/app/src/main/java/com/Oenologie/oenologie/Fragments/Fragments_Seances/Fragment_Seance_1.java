package com.Oenologie.oenologie.Fragments.Fragments_Seances;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Oenologie.oenologie.ConnexionTomcat.AsyncResponse;
import com.Oenologie.oenologie.ConnexionTomcat.Parsing;
import com.Oenologie.oenologie.ConnexionTomcat.RecupererJson;
import com.Oenologie.oenologie.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Seance_1 extends Fragment implements AsyncResponse{
    private TextView tvfrags1;
    private TextView tvfrags12;
    private TextView tvfrags13;
    private String url = "https://thomas-chevalier.fr/android/seance1.php";

    public Fragment_Seance_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_seance_1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvfrags1 = view.findViewById(R.id.tvfrags1);
        tvfrags12 = view.findViewById(R.id.tvfrags12);
        tvfrags13 = view.findViewById(R.id.tvfrags13);

        //recuperation du json
        RecupererJson recupererJson = new RecupererJson();
        recupererJson.delegate = this;
        recupererJson.execute(url);
    }

    @Override
    public void processFinish(String output) throws JSONException, ParseException {
        Parsing parsing = new Parsing();
        ArrayList<String> elements = parsing.parseSeance(output);

        //distribution des textes une fois decoupes dans les conteneurs du layout
        tvfrags1.setText(elements.get(0));
        tvfrags12.setText(elements.get(1));
        tvfrags13.setText(elements.get(2));
    }
}