package com.Oenologie.oenologie.ConnexionTomcat;

import org.json.JSONException;

import java.text.ParseException;

/**
 * Created by etienne on 08/02/2018.
 * interface servant à la classe RecupererJson qui permet d'utiliser la méthode DoInBackground appelée dans d'autre classe
 */

public interface AsyncResponse {
    void processFinish(String output) throws JSONException, ParseException;
}
