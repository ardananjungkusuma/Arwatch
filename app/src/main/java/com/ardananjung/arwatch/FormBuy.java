package com.ardananjung.arwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FormBuy extends AppCompatActivity {

    EditText editName,editAddress,editEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_buy);
        editName=findViewById(R.id.nameBuyerEdt);
        editAddress=findViewById(R.id.addressBuyerEdt);
        editEmail=findViewById(R.id.emailBuyerEdt);
    }

    public void whyUs(View view) {
        Intent i = new Intent(FormBuy.this,WhyUs.class);
        startActivity(i);
    }

    public void buyNow(View view) {

        if(TextUtils.isEmpty(editName.getText().toString().trim())||TextUtils.isEmpty(editAddress.getText().toString().trim())
                ||TextUtils.isEmpty(editEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Form Cant Blank", Toast.LENGTH_SHORT).show();
        }else{
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{"ardananjungkusuma@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "I want to order ... ");
            startActivity(i.createChooser(i, "Choose Email Address."));
        }
    }
}
