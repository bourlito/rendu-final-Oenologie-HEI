package com.Oenologie.oenologie;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PopUpLogActivity extends AppCompatActivity {
    private EditText etcodesession;
    private EditText etpseudo;
    private Button btndemarrer;

    private String codesession;
    private String pseudo;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Code = "codeKey";
    SharedPreferences mySettings;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_signin);
        etcodesession = findViewById(R.id.codesession);
        etpseudo = findViewById(R.id.pseudo);
        btndemarrer = findViewById(R.id.btndemarrer);

        //recuperation des SharedPref
        mySettings = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE );
        editor = mySettings.edit();

        //recuperation du pseudo et du codesession dans les SharedPref
        btndemarrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                codesession = etcodesession.getText().toString();
                pseudo = etpseudo.getText().toString();
                if (codesession.equals("171023") && !pseudo.equals("") || codesession.equals("180129") && !pseudo.equals("") || codesession.equals("180312") && !pseudo.equals("")){
                    editor.putString(Name, pseudo);
                    editor.putString(Code, codesession);
                    editor.apply();
                    finish();
                }//un pseudo est necessaire
                else if (pseudo.equals("")){
                    Toast.makeText(PopUpLogActivity.this, "PSEUDO INVALIDE", Toast.LENGTH_SHORT).show();
                }//le codesession doit correspondre a celui choisi par le predsident de l'asso
                else if (!codesession.equals("171023") || !codesession.equals("180129") || !codesession.equals("180312")){
                    Toast.makeText(PopUpLogActivity.this, "CODE SESSION INVALIDE", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
