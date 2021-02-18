package fr.eps.mapappli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import fr.eps.mapappli.Adapter.EtudiantAdapter;
import fr.eps.mapappli.obj.Etudiant;

public class ListEtudiant extends EpsiActivity {

    public static void lanceCetAppli(EpsiActivity activity){
        Intent intent = new Intent(activity,ListEtudiant.class);
        activity.startActivity(intent);
    }
    private ArrayList<Etudiant> listEtudiant;
    private EtudiantAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_etudiant);
        setTitle("info");
        showBack();
        listEtudiant = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listEtudiant.add(new Etudiant("CH", "Th", "lolo@gmail", 1));
        listEtudiant.add(new Etudiant("CHa", "Thi", "lolo@gmail", 2));
        listEtudiant.add(new Etudiant("CHan", "Thie", "lolo@gmail", 3));
        listEtudiant.add(new Etudiant("CHang", "Thierr", "lolo@gmail", 1));
        listEtudiant.add(new Etudiant("C", "Thierry", "lolo@gmail", 2));
        adapter = new EtudiantAdapter(this, listEtudiant);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}