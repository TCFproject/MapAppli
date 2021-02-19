package fr.eps.mapappli.Adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import fr.eps.mapappli.EpsiActivity;
import fr.eps.mapappli.ItemDetailActivity;
import fr.eps.mapappli.R;
import fr.eps.mapappli.obj.List_Item;

public class CathegorieAdapter extends RecyclerView.Adapter<CathegorieAdapter.ViewHolder> {
    private EpsiActivity activity;
    private List<List_Item> list_items;
    public CathegorieAdapter(EpsiActivity activity,List<List_Item> list_items){
        this.activity = activity;
        this.list_items = list_items;
    }

    @NonNull
    @Override
    public CathegorieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_adapter_cathegorie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CathegorieAdapter.ViewHolder holder, int position) {
        List_Item list_Item = this.list_items.get(position);
        holder.getName().setText(list_Item.getName());
        holder.getDescription().setText(list_Item.getDescription());
        Picasso.get().load(list_Item.getUrl()).into(holder.getImage());
        holder.getLayouT().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemDetailActivity.lanceCetActivite(activity,list_Item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.list_items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView Name;
        private final TextView Description;
        private final ImageView Image;
        private final LinearLayout layouT;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.nom_item);
            Description = itemView.findViewById(R.id.description);
            Image = itemView.findViewById(R.id.Item_image);
            layouT = itemView.findViewById(R.id.layout);
        }

        public TextView getName() {
            return Name;
        }

        public TextView getDescription() {
            return Description;
        }

        public ImageView getImage() {
            return Image;
        }

        public LinearLayout getLayouT() {
            return layouT;
        }
    }
}
