package com.Oenologie.oenologie.Fragments;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.Oenologie.oenologie.ConnexionTomcat.AsyncResponse;
import com.Oenologie.oenologie.ConnexionTomcat.RecupererJson;
import com.Oenologie.oenologie.PopUpLogActivity;
import com.Oenologie.oenologie.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.Oenologie.oenologie.PopUpLogActivity.Code;
import static com.Oenologie.oenologie.PopUpLogActivity.MyPREFERENCES;
import static com.Oenologie.oenologie.PopUpLogActivity.Name;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Fragment_Quizz extends Fragment implements AsyncResponse{
    private static int a = 0;
    private static int highscore = 0;
    private LinearLayout LL2;
    private LinearLayout LL4;
    private LinearLayout LLV;

    private TextView tvQuestion;
    private TextView tvReponse1;
    private TextView tvReponse2;
    private TextView tvReponse3;
    private TextView tvReponse4;
    private TextView tvScore;

    private CardView cvRep1;
    private CardView cvRep2;

    private String urlS1 = "https://thomas-chevalier.fr/android/quizzS1";
    private String urlS2 = "https://thomas-chevalier.fr/android/quizzS2";
    private String urlS3 = "https://thomas-chevalier.fr/android/quizzS3";

    private RecupererJson recupererJson;
    private JSONObject mainObject;
    private JSONArray mainArray;

    SharedPreferences mySettings;
    SharedPreferences.Editor editor;

    public Fragment_Quizz() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quizz, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LL2 = view.findViewById(R.id.LL2);
        LL4 = view.findViewById(R.id.LL4);
        LLV = view.findViewById(R.id.LLV);

        tvQuestion = view.findViewById(R.id.tvQuestiion);
        tvReponse1 = view.findViewById(R.id.tvReponse1);
        tvReponse2 = view.findViewById(R.id.tvReponse2);
        tvReponse3 = view.findViewById(R.id.tvReponse3);
        tvReponse4 = view.findViewById(R.id.tvReponse4);
        tvScore = view.findViewById(R.id.tvScore);

        cvRep1 = view.findViewById(R.id.cvRep1);
        cvRep2 = view.findViewById(R.id.cvRep2);

        recupererJson = new RecupererJson();
        recupererJson.delegate = this;

        mySettings = this.getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        //affichage de la page de connection
        if (mySettings.getString(Name,"").equals("")){
            Intent intent = new Intent(getActivity(),PopUpLogActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void processFinish(String output) throws JSONException{
        tvQuestion.setVisibility(View.VISIBLE);
        LLV.setVisibility(View.VISIBLE);
        LL2.setVisibility(View.VISIBLE);

        mainObject = new JSONObject(output);
        mainArray = mainObject.getJSONArray("server_response");

        //affichage des questions
        updateQuestion(a);

        //gestion du clic sur la reponse
        cvRep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mainArray.getJSONObject(a).getJSONArray("Reponses").getJSONObject(0).getString("Correct").equals("1")){
                        highscore++;
                        Toast.makeText(getActivity(), "Formidable !", Toast.LENGTH_SHORT).show();
                    }else Toast.makeText(getActivity(), "Raté...", Toast.LENGTH_SHORT).show();
                    a++;
                    updateQuestion(a);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        cvRep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mainArray.getJSONObject(a).getJSONArray("Reponses").getJSONObject(1).getString("Correct").equals("1")){
                        highscore++;
                        Toast.makeText(getActivity(), "Formidable !", Toast.LENGTH_SHORT).show();
                    }else Toast.makeText(getActivity(), "Raté...", Toast.LENGTH_SHORT).show();
                    a++;
                    updateQuestion(a);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void updateQuestion(int num) throws JSONException{
        if (num<mainArray.length()){
            tvQuestion.setText(mainArray.getJSONObject(num).getString("Libelle_question"));
            tvReponse1.setText(mainArray.getJSONObject(num).getJSONArray("Reponses").getJSONObject(0).getString("Libelle_reponse"));
            tvReponse2.setText(mainArray.getJSONObject(num).getJSONArray("Reponses").getJSONObject(1).getString("Libelle_reponse"));
        }else{
            LL2.setVisibility(View.GONE);
            tvQuestion.setText("Quizz terminé\nScore : "+highscore);
        }
        tvScore.setText("Score : "+highscore);

    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            if (mySettings.getString(Code,null) != null){
                switch (mySettings.getString(Code,null)){
                    case "171023":
                        recupererJson.execute(urlS1);
                        break;
                    case "180129":
                        recupererJson.execute(urlS2);
                        break;
                    case "180312":
                        recupererJson.execute(urlS3);
                        break;
                }
            }
        }catch (Exception e){e.printStackTrace();}
    }
}