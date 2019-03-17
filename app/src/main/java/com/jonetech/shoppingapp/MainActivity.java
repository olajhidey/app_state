package com.jonetech.shoppingapp;

import android.content.Intent;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    private TextView fRice;
    private TextView fYam;
    private TextView fPotato;
    private TextView fBread;

    public static final String MAIN_EXTRA = "com.jonetech.shoppingapp.extra.MAIN_EXTRA";
    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int RESULT_CODE = 1;
    private String fChoosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fRice = (TextView) findViewById(R.id.item1);
        fYam = (TextView) findViewById(R.id.item2);
        fPotato = (TextView) findViewById(R.id.item3);
        fBread = (TextView) findViewById(R.id.item4);

        if(savedInstanceState != null) {
            fYam.setText(savedInstanceState.getString("saved_item"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        if(fChoosen !=  null || fChoosen != ""){
            outState.putString("saved_item", fChoosen);
        }

        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == RESULT_CODE) {
            if (resultCode == RESULT_OK) {
                fChoosen = data.getStringExtra(ItemsActivity.ITEM_EXTRA);

                fYam.setText(fChoosen);


            }


        }else{
            Log.d(LOG_TAG, "Nothing to listen to!");
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onRestart() {

        if(fChoosen != null){

            fYam.setText(fChoosen);
        }
        super.onRestart();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        if(fChoosen != null){
            fYam.setText(savedInstanceState.getString("saved_item"));
        }

        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_main) {
//       Create intent to navigate to the page where we select a Ingredient

            Intent mIntent = new Intent(MainActivity.this, ItemsActivity.class);

            startActivityForResult(mIntent, RESULT_CODE);
        }
        return super.onOptionsItemSelected(item);
    }
}
