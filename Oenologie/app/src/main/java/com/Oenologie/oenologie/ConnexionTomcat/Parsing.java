package com.Oenologie.oenologie.ConnexionTomcat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by etienne on 22/03/2018.
 * methode pour parser le string Json des séances
 */

public class Parsing {
    private String dateparse;
    private JSONObject mainObject;
    private JSONArray mainArray;
    private JSONObject unicObject;

    private DateFormat inputformat;
    private DateFormat outputformat;

    private ArrayList<String> listeFinale;

    public ArrayList<String> parseSeance(String output) throws JSONException,ParseException{
        listeFinale = new ArrayList<>();
        mainObject = new JSONObject(output);
        mainArray = mainObject.getJSONArray("server_response");
        unicObject = mainArray.getJSONObject(0);

        inputformat = new SimpleDateFormat("yyyy-MM-dd");
        outputformat = new SimpleDateFormat("dd-MM-yyyy");

        String date = unicObject.getString("Date");
        Date date1 = inputformat.parse(date);
        dateparse = outputformat.format(date1);

        listeFinale.add(dateparse);
        listeFinale.add(unicObject.getString("Libelle"));
        listeFinale.add(unicObject.getString("Informations"));

        return listeFinale;
    }
}
