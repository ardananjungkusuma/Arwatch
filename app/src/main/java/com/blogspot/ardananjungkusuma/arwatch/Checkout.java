package com.blogspot.ardananjungkusuma.arwatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Checkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
    }

    public void Order_Now(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"ardananjungkusuma@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "I want to order ... ");
        i.putExtra(Intent.EXTRA_TEXT, "This is my Address");
        startActivity(i.createChooser(i, "Choose Email "));
    }
}
