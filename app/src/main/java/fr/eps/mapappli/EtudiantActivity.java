package fr.eps.mapappli;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import fr.eps.mapappli.obj.Etudiant;

public class EtudiantActivity extends EpsiActivity {

    public static void lanceCetActivite(EpsiActivity activite, Etudiant etudiant){
        Intent intent = new Intent(activite, EtudiantActivity.class);
        intent.putExtra("Nom", etudiant.getNom());
        intent.putExtra("Prenom", etudiant.getPrenom());
        intent.putExtra("Email", etudiant.getEmail());
        intent.putExtra("groupe", etudiant.getGroupe());
        activite.startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiant);
        setTitle(getIntent().getExtras().getString("Nom","")+" "+getIntent().getExtras().getString("Prenom",""));
        showBack();
        TextView email = (TextView) findViewById(R.id.Email);
        email.setText(getIntent().getExtras().getString("Email",""));
        TextView group = (TextView) findViewById(R.id.GroupeNb);
        group.setText("Groupe "+ getIntent().getExtras().getInt("groupe"));
        TextView link = (TextView) findViewById(R.id.link);
        link.setText("https://www.epsi.fr/");
    }
}
