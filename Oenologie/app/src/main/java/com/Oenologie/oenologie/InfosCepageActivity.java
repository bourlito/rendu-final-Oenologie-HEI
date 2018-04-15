package com.Oenologie.oenologie;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InfosCepageActivity extends AppCompatActivity {
    private TextView tvIntro;
    private TextView tvContenu;
    private TextView tvContenu2;
    private TextView tvContenu3;
    private TextView tvContenu4;
    private TextView tvTContenu5;
    private TextView tvContenu5;
    private ImageView imageView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos_cepage);
        imageView = findViewById(R.id.imageView);
        tvIntro = findViewById(R.id.textintro);
        tvContenu = findViewById(R.id.textcontenu);
        tvContenu2 = findViewById(R.id.textcontenu2);
        tvContenu3 = findViewById(R.id.textcontenu3);
        tvContenu4 = findViewById(R.id.textcontenu4);
        tvTContenu5 = findViewById(R.id.textTcontenu5);
        tvContenu5 = findViewById(R.id.textcontenu5);

        //recuperation des infos passees dans le bundle de l'activite precedente
        Bundle bundle = getIntent().getExtras();
        tvIntro.setText(bundle.getString("zone"));

        //retour vers la carte
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //affichage des infos du cepage en fonction de la zone du cepage
        switch (bundle.getString("zone")){
            case "Loire":
                tvContenu.setText("70 000 hectares dont 52 000 classés en AOC-AOP."
                );
                tvContenu2.setText("Vin rouge : cabernet franc, gamay, grolleau.\nVin blanc : melon de Bourgogne, chenin, sauvignon."
                );
                tvContenu3.setText("45% de vins blancs secs et doux, 23% de vins rouges, 21%de vins rosés et 11% de vins mousseux."
                );
                tvContenu4.setText("Sancerre, Savennières, Vouvray, Tours, Cheverny, Nantes, Saint-Pourçain et Amboise."
                );
                tvContenu5.setVisibility(View.GONE);
                tvTContenu5.setVisibility(View.GONE);
                break;

            case "Bordeaux":
                tvContenu.setText("117 500 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Vin rouge : merlot, cabernet sauvignon, cabernet franc.\nVin blanc : muscadelle, sémillon, sauvignon."
                );
                tvContenu3.setText("11% de vins blancs secs et doux, 89% de vins rouges et rosés."
                );
                tvContenu4.setText("Pauillac, St Julien, St Estèphe, Pessac Léognan, Pomerol et Médoc."
                );

                tvContenu5.setText("1900, 1929, 1949, 1961, 1982, 1990, 2000 et 2005."
                );
                break;

            case "Alsace":
                tvContenu.setText("15 600 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Vin rouge : pinot noir.\nVin blanc : riesling, gewurztraminer, sylvaner, pinot gris, muscat."
                );
                tvContenu3.setText("70% de vins blancs secs et doux, 10% de vins rouges et 20% de vins mousseux."
                );
                tvContenu4.setText("Altenberg, Menchberg, Osterberg et Vorbourg."
                );
                tvContenu5.setText("1921, 1928, 1929, 1937, 1945, 1947, 1961, 1983, 1985, 1990 et 2000."
                );
                break;

            case "Bourgogne":
                tvContenu.setText("29 500 hectares dont 25 000 classés en AOC-AOP."
                );
                tvContenu2.setText("Vin rouge : pinot noir, gamay.\nVin blanc : chardonnay, aligoté."
                );
                tvContenu3.setText("61% de vins blancs secs, 39% de vins rouges et rosés."
                );
                tvContenu4.setText("Romanée-Conti, Echezaux, Chambertin, Montrachet, Chambolle-Musigny, Meursault, Chablis, Nuits-Sait-Georges, Pommard, Givry et Beaune."
                );
                tvContenu5.setText("1929, 1934, 1945, 1947, 1961, 1969, 1986, 1996, 1999 et 2009."
                );
                break;

            case "Provence & Corse":
                tvContenu.setText("34 180 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Vin rouge : grenache, mourvèdre, cinsault, tibouren, syrah, cabernet sauvignon, carrignan, niellucio, sciacarello, carcajolo noir.\nVin blanc : clairette, vermentino, sémillon, ugni-blanc, carcajolo blanc."
                );
                tvContenu3.setText("5% de vins blancs secs, 40% de vins rouges et 55% de vins rosés."
                );
                tvContenu4.setText("Bandol, Cassis, Aix-en-Provence, Ajaccio et Calvi."
                );
                tvContenu5.setText("1988, 1989, 1990, 1998, 2000, 2006 et 200è."
                );
                break;

            case "Lorraine":
                tvContenu.setText("180 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Vin rouge : pinot noir, gamay.\nVin blanc : auxerrois, chardonnay."
                );
                tvContenu3.setText("5% de vins blancs secs, 95% de vins gris et rouges."
                );
                tvContenu4.setText("Lucey, Bruley, Charmes-la-Côte, Mont-le-Vignoble et Bulligny."
                );
                tvContenu5.setText("1921, 1918, 1945, 1961, 1983, 1990 et 2000."
                );
                break;

            case "Champagne":
                tvContenu.setText("33 344 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Vin rouge : pinot noir, pinot meunier, chardonnay.\nVin rosé de Riceys : pinot noir, pinot meunier."
                );
                tvContenu3.setText("90% de vins mousseux, 5% de vins rouges et 5% de vins rosés."
                );
                tvContenu4.setText("Avize, Epernay, Cramant, Cuis, Chouilly, Vertus et Mesnil."
                );
                tvContenu5.setText("1900, 1911, 1914, 1921, 1937, 1955, 1975, 1990, 1996 et 2002."
                );
                break;

            case "Sud-Ouest":
                tvContenu.setText("57 500 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Vin rouge : merlot, côt malbec, duras, tannat, la négrette, cabernet sauvignon, cabernet franc.\nVin blanc : gros manseng, petit manseng, mauzac, arrufiac, sauvignon."
                );
                tvContenu3.setText("20% de vins blancs secs, 80% de vins rouges et rosés."
                );
                tvContenu4.setText("Cahors, Gaillac, Jurançon, Agen et Bergerac."
                );
                tvContenu5.setText("1985, 1987 et 1998."
                );
                break;

            case "Savoie":
                tvContenu.setText("5 771 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Vin rouge : poulsard, mondeuse, pinot noir, gamay.\nVin blanc : chardonnay, jacquère, roussanne, altesse, chasselas, molette."
                );
                tvContenu3.setText("61% de vins blancs secs, 39% de vins rouges et rosés."
                );
                tvContenu4.setText("Apremont et Montagieux."
                );
                tvContenu5.setText("1988, 1990, 1995, 2002 et 2005."
                );
                break;

            case "Rhône":
                tvContenu.setText("73 838 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Vin rouge : syrah, grenache, gamay (coteaux du Lyonnais), mourvèdre.\nVin blanc : viognier, roussance, marsanne, grenache blanc, bourboulenc, chardonnay (coteaux du Lyonnais)."
                );
                tvContenu3.setText("60,5% de vins blancs secs, 31% de vins rouges et 8,5% de vins rosés."
                );
                tvContenu4.setText("Condrieu, Vinsobres, Rasteau, Avignon, Ampuis et Châteauneuf-du-Rhône."
                );
                tvContenu5.setText("1911, 1923, 1929, 1945, 1961, 1978, 1998 et 2007."
                );
                break;

            case "Languedoc":
                tvContenu.setText("246 000 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Vin rouge : grenache, mourvèdre, syrah, carignan, cinsault.\nVin blanc : marsanne, bourboulenc, grenache blanc, roussance."
                );
                tvContenu3.setText("15% de vins blancs secs et doux, 85% de vins rouges et rosés."
                );
                tvContenu4.setText("Banyuls, Collioure, Saint-Jean-de-Minervois, Lesquerde et Tautavel."
                );
                tvContenu5.setText("1990, 1991, 1995, 1998, 2001, 2003, 2004, 2005, 2006 et 2010."
                );
                break;

            default:
                tvContenu.setText("Erreur");
                break;
        }
    }
}
