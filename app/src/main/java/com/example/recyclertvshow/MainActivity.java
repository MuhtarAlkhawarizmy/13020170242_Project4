package com.example.recyclertvshow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<TvShow> data=new ArrayList<>();
    private RecyclerView recyclerView;
    Button hapus;
    String[] nama, desc, title;
    TypedArray foto;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("List Film");
        recyclerView=findViewById(R.id.recyclerView);
        hapus=findViewById(R.id.btn_hapus);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final TvShowAdapter tvShowAdapter=new TvShowAdapter(this, data);
        recyclerView.setAdapter(tvShowAdapter);
        getData();
        tvShowAdapter.notifyDataSetChanged();
    }

    private void getData() {
        prepare();
        additem();
    }

    void prepare(){
        nama=getResources().getStringArray(R.array.nama);
        desc=getResources().getStringArray(R.array.desc);
        foto=getResources().obtainTypedArray(R.array.foto);
    }

    private void additem() {
        for(int i=0; i<nama.length; i++){
            TvShow film=new TvShow(nama[i], desc[i], foto.getResourceId(i,-1));
            data.add(film);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int itemId) {
        switch (itemId){
            case R.id.idCardview:
                getData();
                break;
            case R.id.idGrid:
                getData();
                break;
            case R.id.idAbout:
                about();
                break;
        }
    }

    public void about(){
        Intent goAbout=new Intent(MainActivity.this, about.class);
        startActivity(goAbout);
    }
}