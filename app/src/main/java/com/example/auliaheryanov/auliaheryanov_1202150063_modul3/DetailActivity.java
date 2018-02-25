package com.example.auliaheryanov.auliaheryanov_1202150063_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    private Button btnAdd, btnRemove;
    private ImageView logo, indicatorImg;
    private TextView detail, mtitle, indicatorlbl;
    private int level = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnAdd = findViewById(R.id.buttonAdd); //tombol tambah
        btnRemove = findViewById(R.id.buttonRemove); //tombol kurang
        logo = findViewById(R.id.logoDetail); //logo atas
        indicatorImg = findViewById(R.id.indicatorBottle); //gambar indikator
        detail = findViewById(R.id.descDetail); //lipsum
        mtitle = findViewById(R.id.titleDetail); //judul
        indicatorlbl = findViewById(R.id.indicatorNumber); //angka botol

        Intent detailIntent = getIntent();
        String title = detailIntent.getStringExtra("Title");
        int imgIntent = detailIntent.getIntExtra("Image Resource", 0);

//        setTitle(title);
        mtitle.setText(title);
        logo.setImageResource(imgIntent);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahIsi();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kurangIsi();
            }
        });
    }

    public void tambahIsi(){
        status();
        if(level==6){
            Toast.makeText(this,"Air Penuh",Toast.LENGTH_SHORT).show();return;}
        indicatorImg.setImageLevel(++level);
    }

    public void kurangIsi(){
        status();
        if(level==0){Toast.makeText(this,"Air Kosong",Toast.LENGTH_SHORT).show();return;}
        indicatorImg.setImageLevel(--level);
    }

    public void status(){
        indicatorlbl.setText(""+level+"L");
    }
}




