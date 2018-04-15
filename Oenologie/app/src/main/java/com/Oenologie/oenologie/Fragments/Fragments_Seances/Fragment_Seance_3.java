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

import org.json.JSONException;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Seance_3 extends Fragment implements AsyncResponse{
    private TextView tvfrags3;
    private TextView tvfrags32;
    private TextView tvfrags33;
    private String url = "https://thomas-chevalier.fr/android/seance3.php";

    public Fragment_Seance_3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_seance_3, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvfrags3 = view.findViewById(R.id.tvfrags3);
        tvfrags32 = view.findViewById(R.id.tvfrags32);
        tvfrags33 = view.findViewById(R.id.tvfrags33);

        RecupererJson recupererJson = new RecupererJson();
        recupererJson.delegate = this;
        recupererJson.execute(url);
    }

    @Override
    public void processFinish(String output) throws JSONException, ParseException {
        Parsing parsing = new Parsing();
        ArrayList<String> elements = parsing.parseSeance(output);

        tvfrags3.setText(elements.get(0));
        tvfrags32.setText(elements.get(1));
        tvfrags33.setText(elements.get(2));
    }
}