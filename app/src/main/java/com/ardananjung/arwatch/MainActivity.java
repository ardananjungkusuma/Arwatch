package com.ardananjung.arwatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;

import com.ardananjung.arwatch.adapter.RecyclerWatchListAdapter;
import com.ardananjung.arwatch.data.Watch;
import com.ardananjung.arwatch.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    public static final String Key_MainActivity="Key_MainActivity";
//todo : mbenerin onclick ini
    //viewmodel
    private MainViewModel mainViewModel;

    // Data
    private RecyclerWatchListAdapter recyclerWatchListAdapter;
    private ArrayList<Watch> watchList;

    // Components
    private RecyclerView recyclerWatchList;
    private EditText edtName;
    private EditText edtPrice;
    private EditText edtImage;
    private EditText edtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mendapatkan instance ViewModel
        //ini harus import dulu di gradle
        this.mainViewModel= ViewModelProviders.of(this).get(MainViewModel.class);

        this.initData();
        this.initComponents();
    }

    private void initData()
    {
        this.watchList= new ArrayList<>();

        // Tambahin dummy data..
        /*this.contactList.add(new Contact("Alan Walker", "0857-123-456"));*/

        // Seting recycler view-nya
        this.recyclerWatchListAdapter = new RecyclerWatchListAdapter(this);
    }

    private void initComponents()
    {
        this.recyclerWatchList = this.findViewById(R.id.recycler_watch_list);
        this.recyclerWatchList.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerWatchList.setAdapter(this.recyclerWatchListAdapter);


        // Load data ke recycler View
        /*this.recyclerContactListAdapter.setContactList(this.contactList);*/
        this.mainViewModel.getWatchList().observe(this, new Observer<List<Watch>>() {
            @Override
            public void onChanged(List<Watch> watches) {
                recyclerWatchListAdapter.setWatchList(watches);
            }
        });
    }
    public void formGan(View view) {
        Intent i = new Intent(MainActivity.this,FormBuy.class);
        startActivity(i);
    }
}
