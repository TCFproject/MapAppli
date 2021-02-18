package fr.eps.mapappli;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends EpsiActivity {

    public static void lanceActivite(EpsiActivity activite){
        Intent intent = new Intent(activite, MainActivity.class);
        activite.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView Zone1 = (TextView) findViewById(R.id.Zone);
        TextView Zone2 = (TextView) findViewById(R.id.Zone2);
        Zone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListEtudiant.lanceCetAppli(MainActivity.this);
            }
        });

        Zone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CategoriesActivity.lanceCetAppli(MainActivity.this);
            }
        });
    }
}