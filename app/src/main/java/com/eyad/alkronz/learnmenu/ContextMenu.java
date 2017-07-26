package com.eyad.alkronz.learnmenu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContextMenu extends AppCompatActivity {
    ArrayList<String> names ;
    myAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
         Button btn =(Button) findViewById(R.id.buttoncontexmenu);
        ListView ListView =(ListView) findViewById(R.id.ListView);

        names = new ArrayList<>();
        names.add("eyad");
        names.add("ali");
        names.add("eyad");
        names.add("eyad");
          myAdapter = new myAdapter(this , names);
        ListView.setAdapter(myAdapter);
        registerForContextMenu(ListView);
       // registerForContextMenu(btn);
    }

    public void btnclick(View view) {

    }

    @Override
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);

     }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        AdapterView.AdapterContextMenuInfo info=  (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int position = info.position;
        Toast.makeText(this, position+"", Toast.LENGTH_SHORT).show();
        switch (id){
            case R.id.item_add:
                Toast.makeText(this,"Add",Toast.LENGTH_LONG).show(); break;

            case R.id.item_search:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show(); break;

            case R.id.item_update:
                Toast.makeText(this,"item_update",Toast.LENGTH_LONG).show(); break;

            case R.id.item_delete:
                Toast.makeText(this, "item_delete", Toast.LENGTH_SHORT).show();
                names.remove(position);
                myAdapter.notifyDataSetChanged();;
                break;
            case R.id.item_share:
                Toast.makeText(this, "item_share", Toast.LENGTH_SHORT).show(); break;
        }
        return super.onContextItemSelected(item);
    }


    class myAdapter extends BaseAdapter{
        List<String> names ;
        Context context ;

        public  myAdapter(  Context context  , List<String> names){
              this.context =context;
            this.names=names;
        }
        @Override
        public int getCount() {
            return names.size();
        }

        @Override
        public Object getItem(int i) {
            return names.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from( context).inflate(R.layout.name_row ,viewGroup, false);

            TextView tvname = (TextView)view.findViewById(R.id.tvname);
            tvname.setText(names.get(i)+"");
            return view;
        }
    }
}
