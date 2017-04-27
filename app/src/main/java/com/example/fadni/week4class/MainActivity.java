package com.example.fadni.week4class;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        preferences = getSharedPreferences("values",MODE_PRIVATE);
        final Ideas ideaList = new Ideas();
        description = (TextView) findViewById(R.id.descrtiption);
        ideaList.newIdea(new Idea("item1", "first item"));
        ideaList.newIdea(new Idea("item2", "second item"));
        ideaList.newIdea(new Idea("item3", "third item"));
        Map<String,?> keys = preferences.getAll();
        for(Map.Entry<String,?> entry : keys.entrySet()){
            ideaList.newIdea(new Idea(entry.getKey(),entry.getValue().toString()));
        }
        ArrayList<String> myArray = ideaList.getIdeas();
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myArray);
        ListView listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(myAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                description.setText(ideaList.getIdeaList().get(position).getDesc());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        preferences.edit().clear().apply();
    }

    public void addButton(View view){
        Intent intent = new Intent(this, addItem.class);
        startActivity(intent);
    }

}

