package com.Oenologie.oenologie.ConnexionTomcat;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;

/**
 * Created by etienne on 05/12/2017.
 * classe permettant de recuperer les strings Json depuis le webservice
 */


public class RecupererJson extends AsyncTask<String, Void, String> {
    private String JSON_STRING;
    public AsyncResponse delegate = null;

    @Override
    protected String doInBackground(String... params) {
        try {
            StringBuilder JSON_DATA = new StringBuilder();
            URL url = new URL(params[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream in = httpURLConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while ((JSON_STRING = reader.readLine()) != null) {
                JSON_DATA.append(JSON_STRING).append("\n");
            }
            reader.close();
            in.close();
            httpURLConnection.disconnect();
            return JSON_DATA.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON_STRING;
    }

    @Override
    protected void onPostExecute(String JSON_STRING) {
        try {
            delegate.processFinish(JSON_STRING);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}