package fr.eps.mapappli.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.eps.mapappli.EpsiActivity;
import fr.eps.mapappli.R;
import fr.eps.mapappli.UneCategorieActiviy;
import fr.eps.mapappli.obj.Item;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private EpsiActivity activity;
    private List<Item> listItem;

    public ItemAdapter(EpsiActivity activity, List<Item> listItem){
        this.activity = activity;
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        Item item = listItem.get(position);
        holder.getTextViewNom().setText(item.getTitre());
        holder.getTextViewNom().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UneCategorieActiviy.lanceCetActivite(activity,item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView nom;
        public ViewHolder(View view) {
            super(view);
            nom = view.findViewById(R.id.Nom_etudiant);
        }
        public TextView getTextViewNom(){
            return nom;
        }
    }
}
