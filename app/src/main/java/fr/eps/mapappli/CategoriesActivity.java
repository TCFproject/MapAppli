package fr.eps.mapappli;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.os.StrictMode;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;

import fr.eps.mapappli.Adapter.ItemAdapter;
import fr.eps.mapappli.obj.Etudiant;
import fr.eps.mapappli.obj.Item;

public class CategoriesActivity extends EpsiActivity {

    public static void lanceCetAppli(EpsiActivity activity){
        Intent intent = new Intent(activity,CategoriesActivity.class);
        activity.startActivity(intent);
    }
    private ArrayList<Item> listItem;
    private ItemAdapter itemAdapter;
    String wsUrl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        setTitle("Cathegorie");
        showBack();
        RecyclerView rcv = (RecyclerView) findViewById(R.id.Catego_recycler);
        listItem = new ArrayList<>();
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String wsUrl = RequestHandler.sendGet("https://djemam.com/epsi/categories.json");
            JSONObject list_Item = new JSONObject(wsUrl);
            JSONArray array_Item = list_Item.getJSONArray("items");
            for (int i = 0; i<array_Item.length();i++){
                listItem.add(new Item(array_Item.getJSONObject(i).getInt("category_id"),array_Item.getJSONObject(i).getString("title"),array_Item.getJSONObject(i).getString("products_url")));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        itemAdapter = new ItemAdapter(this,listItem);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setAdapter(itemAdapter);
    }
}
