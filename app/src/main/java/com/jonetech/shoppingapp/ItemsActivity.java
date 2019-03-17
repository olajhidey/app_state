package com.jonetech.shoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ItemsActivity extends AppCompatActivity {

    public static final String ITEM_EXTRA= "com.jonetech.shoppingapp.extra.ITEMS_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
    }

    public void selectYam(View view) {

        String ingredient = "Yam";
        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra(ITEM_EXTRA, ingredient);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void selectPotato(View view) {
        String ingredient = "Potato";
        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra(ITEM_EXTRA, ingredient);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void selectRice(View view) {
        String ingredient = "Rice";
        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra(ITEM_EXTRA, ingredient);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void selectBread(View view) {
        String ingredient = "Bread";
        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra(ITEM_EXTRA, ingredient);
        setResult(RESULT_OK, intent);
        finish();
    }
}
