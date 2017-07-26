package com.eyad.alkronz.learnmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
     }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id = item.getItemId();
        switch (id){
            case R.id.item_add:
                Toast.makeText(this,"Add",Toast.LENGTH_LONG).show(); break;

            case R.id.item_search:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show(); break;

            case R.id.item_update:
                Toast.makeText(this,"item_update",Toast.LENGTH_LONG).show(); break;

            case R.id.item_delete:
                Toast.makeText(this, "item_delete", Toast.LENGTH_SHORT).show(); break;
            case R.id.item_share:
                Toast.makeText(this, "item_share", Toast.LENGTH_SHORT).show(); break;
         }

        return super.onOptionsItemSelected(item);
    }
}
