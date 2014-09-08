package com.example.jason.firstapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MyActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{

    private ArrayList<MyListItem>myListCategory;
    private  MyListAdapter myListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        myListCategory=new ArrayList<MyListItem>();
        myListCategory.add(new MyListItem(getResources().getDrawable(R.drawable.gradient_diagonal),"Landscape"));
        myListCategory.add(new MyListItem(getResources().getDrawable(R.drawable.ic_launcher),"Flowers"));
        myListCategory.add(new MyListItem(getResources().getDrawable(R.drawable.ic_launcher),"Animals"));
        myListCategory.add(new MyListItem(getResources().getDrawable(R.drawable.ic_launcher),"Clouds"));
        myListCategory.add(new MyListItem(getResources().getDrawable(R.drawable.ic_launcher),"Sunsets"));

        ListView myList=(ListView)findViewById(android.R.id.list);
        myListAdapter=new MyListAdapter(this,myListCategory);
        myList.setAdapter(myListAdapter);
        myList.setOnItemClickListener(this);
    }
    public void showToast(View landscapeButton){
        Toast.makeText(this,"Your Clicking Landscape",Toast.LENGTH_LONG).show();
    }
    public void showToastFlower(View landscapeButton){
        Toast.makeText(this,"Your Clicking Flowers",Toast.LENGTH_LONG).show();
    }
    public void showToastAnimals(View landscapeButton){
        Toast.makeText(this,"Your Clicking Animals",Toast.LENGTH_LONG).show();
    }
    public void showToastClouds(View landscapeButton){
        Toast.makeText(this,"Your Clicking Clouds",Toast.LENGTH_LONG).show();
    }
    public void showToastSunsets(View landscapeButton){
        Toast.makeText(this,"Your Clicking Sunsets",Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"Your Clicking " + myListAdapter.getItem(position).myTitle,Toast.LENGTH_LONG).show();
    }
}
