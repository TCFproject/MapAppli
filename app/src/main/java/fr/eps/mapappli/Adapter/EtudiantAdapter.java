package fr.eps.mapappli.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.eps.mapappli.EpsiActivity;
import fr.eps.mapappli.EtudiantActivity;
import fr.eps.mapappli.ListEtudiant;
import fr.eps.mapappli.R;
import fr.eps.mapappli.obj.Etudiant;

public class EtudiantAdapter extends RecyclerView.Adapter<EtudiantAdapter.ViewHolder> {
    private EpsiActivity activity;
    private ArrayList<Etudiant> listEtudiant;

    public EtudiantAdapter(EpsiActivity activity,ArrayList<Etudiant> listEtudiant){
        this.activity = activity;
        this.listEtudiant = listEtudiant;
    }

    @NonNull
    @Override
    public EtudiantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EtudiantAdapter.ViewHolder holder, int position) {
        Etudiant etudiant = listEtudiant.get(position);
        holder.getTextViewNom().setText(etudiant.getNom());
        holder.getTextViewNom().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EtudiantActivity.lanceCetActivite(activity,etudiant);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listEtudiant.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nom;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nom = itemView.findViewById(R.id.Nom_etudiant);
        }
        public TextView getTextViewNom(){
            return nom;
        }
    }
}
