package com.Oenologie.oenologie;

import com.Oenologie.oenologie.ConnexionTomcat.Parsing;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void parseSeance_isCorrect() throws Exception{
        String jsonString = "{\"server_response\":[{\"Id_seance\":\"1\",\"Libelle\":\"Vins Mono-c\\u00e9pages \",\"Date\":\"2017-10-23\",\"Informations\":\"Cette s\\u00e9ance sera port\\u00e9e sur les vins mon-c\\u00e9apges. Quatre vins seront appr\\u00e9ci\\u00e9s durant cette d\\u00e9gustation. L\\u2019\\u0153nologue Antoine Elwart tout droit venu de lorraine et travaillant au Clarance \\u00e0 Lille ayant une \\u00e9toile au guide Michelin, vous enseignera l'art de la d\\u00e9gustation du vin. Il vous \\u00e9tonnera avec ses accords mets et vins.\\r La s\\u00e9ance durera environ 2h30 et une compensation financi\\u00e8re de 7\\u20ac vous sera demand\\u00e9e. \",\"Code_quizz\":\"171023\"}]}";
        Parsing parsing = new Parsing();
        ArrayList<String> test = parsing.parseSeance(jsonString);
        assertEquals("23-10-2017",test.get(0));
    }
}