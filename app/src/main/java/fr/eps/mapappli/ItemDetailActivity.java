package fr.eps.mapappli;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.eps.mapappli.obj.List_Item;

public class ItemDetailActivity extends EpsiActivity {

    public static void lanceCetActivite(EpsiActivity activity, List_Item listItem){
        Intent intent = new Intent(activity, ItemDetailActivity.class);
        intent.putExtra("Nom_produit", listItem.getName());
        intent.putExtra("description", listItem.getDescription());
        intent.putExtra("url", listItem.getUrl());
        activity.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        setTitle(getIntent().getExtras().getString("Nom_produit"));
        showBack();
        TextView bigDescription = (TextView)findViewById(R.id.BigDescription);
        bigDescription.setText(getIntent().getExtras().getString("description"));
        ImageView bigImage = (ImageView)findViewById(R.id.BigImage);
        Picasso.get().load(getIntent().getExtras().getString("url")).into(bigImage);
    }
}