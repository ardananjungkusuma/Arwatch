package com.blogspot.ardananjungkusuma.arwatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CheckoutDetail extends AppCompatActivity {

    EditText namaBox,alamatBox,kotaKabBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_detail);

        namaBox = findViewById(R.id.nameCustBox);
        alamatBox=findViewById(R.id.alamatCustBox);
        kotaKabBox=findViewById(R.id.kotaKabCustBox);
    }

    public void confirmOrder(View view) {
        String nama=namaBox.getText().toString();
        String alamat=alamatBox.getText().toString();
        String kotaKab=kotaKabBox.getText().toString();

        if(TextUtils.isEmpty(nama)){
            Toast.makeText(this, "Nama Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(alamat)){
            Toast.makeText(this, "Alamat Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(kotaKab)){
            Toast.makeText(this, "Kota dan Provinsi Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }else{
            Intent i = new Intent(CheckoutDetail.this,Checkout.class);
            startActivity(i);
        }
    }
}
