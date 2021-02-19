package fr.eps.mapappli;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.eps.mapappli.Adapter.CathegorieAdapter;
import fr.eps.mapappli.obj.Item;
import fr.eps.mapappli.obj.List_Item;

public class UneCategorieActiviy extends EpsiActivity {

    public static void lanceCetActivite(EpsiActivity activity, Item item){
        Intent intent = new Intent(activity, UneCategorieActiviy.class);
        intent.putExtra("nom_cathe", item.getTitre());
        intent.putExtra("url_cathe", item.getUrl());
        activity.startActivity(intent);
    }

    private List<List_Item> List_item;
    private CathegorieAdapter adapter;
    private RecyclerView rcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_une_categorie_activiy);
        setTitle(getIntent().getExtras().getString("nom_cathe"));
        showBack();
        List_item = new ArrayList<>();
        adapter = new CathegorieAdapter(this, List_item);
        rcv = (RecyclerView)findViewById(R.id.ItemRcv);

        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String item_Url = RequestHandler.sendGet(getIntent().getExtras().getString("url_cathe"));
            JSONObject JSONItem = new JSONObject(item_Url);
            JSONArray arrayItem = JSONItem.getJSONArray("items");
            for (int i = 0; i<arrayItem.length();i++){
                List_item.add(new List_Item(arrayItem.getJSONObject(i).getString("name"),arrayItem.getJSONObject(i).getString("description"),arrayItem.getJSONObject(i).getString("picture_url")));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setAdapter(adapter);
    }
}