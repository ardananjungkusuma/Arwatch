package com.blogspot.ardananjungkusuma.arwatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

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
        rv = findViewById(R.id.rvWatch);
        listWatch.add(new Watch("Casio G-Shock Mudmaster Master GG-1000-1A3ER",
                "Price : £210.00 ",
                "https://d1rkccsb0jf1bk.cloudfront.net/products/100019778/main/medium/gg-1000-1a3er-1509976747-7817.jpg","Casio G-Shock Mudmaster Master Of G GG-1000-1A3ER is an amazing and special Gents watch. Material of the case is Stainless Steel and Resin while the dial colour is LCD. In regards to the water resistance, the watch has got a resistancy up to 200 metres. This means it can be used for professional marine activity, skin diving and high impact water sports, but not deep sea or mixed gas diving. The watch is shipped with an original box and a guarantee from the manufacturer."));
        listWatch.add(new Watch("Raymond Weil Maestro Beatles Limited Edition",
                "Price : £796.00",
                "https://d1rkccsb0jf1bk.cloudfront.net/products/100012355/main/medium/rw_maestro_2237-st-beat2_pkt_white_rvb_300dpi_forweb-1493898486-4507.jpg","Raymond Weil Maestro Beatles Limited Edition 2237-ST-BEAT2 is an amazing and attractive Gents watch. Case is made out of Stainless Steel, which stands for a high quality of the item while the dial colour is Black. The features of the watch include (among others) a date function. In regards to the water resistance, the watch has got a resistancy up to 50 metres. It means it can be submerged in water for periods, so can be used for swimming and fishing. It is not reccomended for high impact water sports. We ship it with an original box and a guarantee from the manufacturer."));
        listWatch.add(new Watch("Gucci G-Timeless Iconic YA1264131",
                "Price : £850.00",
                "https://d1rkccsb0jf1bk.cloudfront.net/products/100032178/main/medium/YA1264131_001.jpg","No Detail, Gucci is already complicated."));
        listWatch.add(new Watch("Seiko SKA791P1",
                "Price : £249.00",
                "https://d1rkccsb0jf1bk.cloudfront.net/products/100025805/main/medium/ska791p1.jpg","Gents leather analogue Kinetic movement Casual / lifestyle Green dial and brown strap or bracelet"));
        listWatch.add(new Watch("Emporio Armani AR11115",
                "Price : £276.00",
                "https://d1rkccsb0jf1bk.cloudfront.net/products/100022842/main/medium/AR11115_main.jpg","Official Emporio Armani presentation box Official Emporio Armani guarantee Instruction manual (where applicable)"));
        listWatch.add(new Watch("40th Anniversary Gundam Limited Model (SBDB 033) ","Price : £4634.00","https://watchesbysjx.com/wp-content/uploads/2019/04/Seiko-Mobile-Suit-Gundam-40th-Anniversary-Gundam-Limited-Edition-SBDB033J1.jpg","The flagship watch of the series – the Prospex LX Spring Drive GMT Gundam Limited Edition SBDB033J – is dedicated to the instantly recognisable titular character of the series. The tricolour red, blue and yellow livery is modelled on the RX-78-2 Gundam robot manned by the hero Amuro Ray in Mobile Suit Gundam, who is a pilot for the Earth Federation."));
        listWatch.add(new Watch("Mens Emporio Armani Chronograph AR6066",
                "Price : £349.00",
                "https://d1rkccsb0jf1bk.cloudfront.net/products/99981705/main/medium/ar6066-1436514958-7680.jpg","Emporio Armani AR6066 is a super very impressive Gents watch . Case is made out of PVD Gold plated and the Black dial gives the watch that unique look. The features of the watch include (among others) a chronograf and date function. This model has got 50 metres water resistancy - it can be submerged in water for periods, so can be used for swimming and fishing. It is not reccomended for high impact water sports. We ship it with an original box and a guarantee from the manufacturer."));
        listWatch.add(new Watch("Daniel Wellington Petite 32 Cornwall DW00100215",
                "Price : £115.00",
                "https://d1rkccsb0jf1bk.cloudfront.net/products/100033091/main/medium/DW00100215.jpg","Daniel Wellington Petite 32 Cornwall RG Black DW00100215 is a beautiful and eye-catching Ladies watch from Petite collection. Case is made out of Stainless Steel and the Black dial gives the watch that unique look. In regards to the water resistance, the watch has got a resistancy up to 30 metres. It means it can be worn in scenarios where it is likely to be splashed but not immersed in water. It can be worn while washing your hands and will be fine in rain. We ship it with an original box and a guarantee from the manufacturer."));
        listWatch.add(new Watch("Ladies Daniel Wellington Petite 28 ",
                "Price : £105.00",
                "https://d1rkccsb0jf1bk.cloudfront.net/products/100018714/main/medium/100250-1507902977-3227.jpg","Daniel Wellington Petite 28 Bondi White DW00100250 is an amazing and interesting Ladies watch. Case material is Stainless Steel and the White dial gives the watch that unique look. In regards to the water resistance, the watch has got a resistancy up to 30 metres. It means it can be worn in scenarios where it is likely to be splashed but not immersed in water. It can be worn while washing your hands and will be fine in rain. The watch is shipped with an original box and a guarantee from the manufacturer."));
        listWatch.add(new Watch("Emporio Armani AR11133",
                "Price : £233.00",
                "https://d1rkccsb0jf1bk.cloudfront.net/products/100023499/main/medium/AR11133_main.jpg","Official Emporio Armani presentation box\nOfficial Emporio Armani guarantee Instruction manual (where applicable)"));
        listWatch.add(new Watch("Seiko Gundam 40th Anniversary mass production type Zaku limited model (SBDX 027)","Price : £2942.00","https://watchesbysjx.com/wp-content/uploads/2019/04/Seiko-Gundam-Mass-Production-Type-Zaku-Limited-Edition-SLA029J11.jpg"
        ,"The case is titanium, with a matte green ceramic shroud engraved with the Zaku II Mobile Suit number that measures 52.4mm in diameter and 17.2mm high. It’s powered by the automatic 8L35 movement that has a 50 hour power reserve."));
        watchAdapter = new WatchAdapter(listWatch);
        watchAdapter.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(watchAdapter);
        rv.setLayoutManager(layoutManager);

    }

    @Override
    public void onClick(View view, int position) {
        Watch watch = listWatch.get(position);
        Intent i = new Intent(MainActivity.this,OptionActivity.class);
        i.putExtra(Key_MainActivity,watch);
        startActivity(i);
    }
}
