package com.blogspot.ardananjungkusuma.arwatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.ardananjungkusuma.arwatch.data.Watch;
import com.squareup.picasso.Picasso;

import java.security.Key;

public class OptionActivity extends AppCompatActivity {
    TextView resultName,resultDesc,resultDetail;
    ImageView resultImgUrl;
    public static final String Key_MainActivity="Key_MainActivity";

    Watch watch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        resultName=findViewById(R.id.nameDetail);
        resultDesc=findViewById(R.id.descPrice);
        resultDetail=findViewById(R.id.descDetail);
        resultImgUrl=findViewById(R.id.imgDetail);

        watch = getIntent().getParcelableExtra(Key_MainActivity);

        //terakhir sampai sini
        resultName.setText(watch.getName());
        resultDesc.setText(watch.getDesc());
      //  resultDetail.setText(watch.getDetail());
       // Picasso.get().load(watch.getImageUrl()).into(resultImgUrl);

    }

    public void buy(View view) {
        Intent i = new Intent(OptionActivity.this,Checkout.class);
        startActivity(i);
    }
}
