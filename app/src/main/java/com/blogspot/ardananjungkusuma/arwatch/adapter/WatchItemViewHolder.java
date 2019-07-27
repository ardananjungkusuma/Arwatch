package com.blogspot.ardananjungkusuma.arwatch.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.ardananjungkusuma.arwatch.R;

public class WatchItemViewHolder extends RecyclerView.ViewHolder {
    private TextView txvName;
    private TextView txvPrice;
    private ImageView txvImage;

    public WatchItemViewHolder(@NonNull View view)
    {
        super(view);

        this.txvName = view.findViewById(R.id.txv_name);
        this.txvPrice = view.findViewById(R.id.txv_price);
        this.txvImage = view.findViewById(R.id.image);
    }

    public TextView getTxvName() {
        return txvName;
    }

    public TextView getTxvPrice() {
        return txvPrice;
    }

    public ImageView getTxvImage(){
        return txvImage;
    }
}
