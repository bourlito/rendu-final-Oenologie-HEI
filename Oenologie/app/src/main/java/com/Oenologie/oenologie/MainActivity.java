package com.Oenologie.oenologie;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import com.Oenologie.oenologie.Fragments.Fragment_Accueil;
import com.Oenologie.oenologie.Fragments.Fragment_Carte;
import com.Oenologie.oenologie.Fragments.Fragment_Contact;
import com.Oenologie.oenologie.Fragments.Fragment_Quizz;
import com.Oenologie.oenologie.Fragments.Fragment_Seance;

import static com.Oenologie.oenologie.PopUpLogActivity.MyPREFERENCES;
import static com.Oenologie.oenologie.PopUpLogActivity.Name;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout myDrawer;
    private ActionBarDrawerToggle myToggle;
    private FragmentTransaction fragmentTransaction;

    private NavigationView navigationView;
    private View hView;

    private ImageButton btnFb;
    private TextView nav_user;
    private TextView tvIntro;


    SharedPreferences mySettings;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDrawer = findViewById(R.id.myDrawer);
        navigationView = findViewById(R.id.navView);
        btnFb = navigationView.findViewById(R.id.btnFb);
        tvIntro = findViewById(R.id.textintro);

        hView = navigationView.getHeaderView(0);
        nav_user = hView.findViewById(R.id.testPseudoNav);

        //implementation du menu
        myDrawer.addDrawerListener(myToggle);
        myToggle = new ActionBarDrawerToggle(this,myDrawer,R.string.open,R.string.close);
        myToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(navigationView);

        //animation du titre
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.my_transition);
        tvIntro.startAnimation(myanim);

        //recuperation des SharedPref
        mySettings = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = mySettings.edit();
        editor.clear();
        editor.apply();

        //gestion des onglets du menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.accueil: //page d'accueil
                        tvIntro.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Accueil());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Accueil");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;

                    case R.id.seance: //page des seances
                        tvIntro.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Seance());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Séances");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;

                    case R.id.carte: //page de la carte interactive
                        tvIntro.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Carte());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Carte Intéractive");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;

                    case R.id.quizz: //page du quizz
                        tvIntro.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Quizz());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Quizz!");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;

                    case R.id.contact: //page des contacts
                        tvIntro.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Contact());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Contact & Adresses");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;
                }
                return true;
            }
        });

        //lien vers l'evenement Facebook
        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "https://www.facebook.com/oenologie.hei.5?ref=br_rs");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (myToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //bouton menu
    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return true;
            }
        });
    }

    //affichage du nom de l'utisateur dans le menu
    @Override
    protected void onResume() {
        super.onResume();
        nav_user.setText("".equals(mySettings.getString(Name,"")) || mySettings.getString(Name,null).equals(null) ? "" : String.format("%s", mySettings.getString(Name,"")));
    }
}
