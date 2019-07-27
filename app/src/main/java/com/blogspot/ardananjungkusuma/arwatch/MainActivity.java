package com.blogspot.ardananjungkusuma.arwatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.ardananjungkusuma.arwatch.models.Watch;
import com.blogspot.ardananjungkusuma.arwatch.models.WatchAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements WatchAdapter.OnWatchClickListener{

    public static final String Key_MainActivity="Key_MainActivity";

    public RecyclerView rv;
    public WatchAdapter watchAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<Watch> listWatch = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClick(View view, int position) {
        Watch watch = listWatch.get(position);
        Intent i = new Intent(MainActivity.this,OptionActivity.class);
        i.putExtra(Key_MainActivity,watch);
        startActivity(i);
    }
}
