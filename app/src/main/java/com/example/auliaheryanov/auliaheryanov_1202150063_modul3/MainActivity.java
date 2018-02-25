package com.example.auliaheryanov.auliaheryanov_1202150063_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter mAdapter;
    public static ArrayList<Model> DATA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.RecyclerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DATA = new ArrayList<>();

        mAdapter = new Adapter(this, DATA);
        recyclerView.setAdapter(mAdapter);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        initialiseData();
    }

    private void initialiseData(){
        String[] title = getResources().getStringArray(R.array.title);
        String[] desc1 = getResources().getStringArray(R.array.desc1);
        TypedArray airImageResource = getResources().obtainTypedArray(R.array.merek_image);
        DATA.clear();

        for (int i=0; i<title.length; i++){
            DATA.add(new Model(title[i], desc1[i], airImageResource.getResourceId(i, 0)));
        }

        airImageResource.recycle();

        mAdapter.notifyDataSetChanged();
    }
}