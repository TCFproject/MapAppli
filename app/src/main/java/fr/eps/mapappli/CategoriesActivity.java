package fr.eps.mapappli;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class CategoriesActivity extends EpsiActivity {

    public static void lanceCetAppli(EpsiActivity activity){
        Intent intent = new Intent(activity,CategoriesActivity.class);
        activity.startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        setTitle("Cathegorie");
        showBack();
    }
}
