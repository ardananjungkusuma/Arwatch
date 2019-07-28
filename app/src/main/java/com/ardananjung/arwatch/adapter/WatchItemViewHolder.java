package com.ardananjung.arwatch.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ardananjung.arwatch.R;

public class WatchItemViewHolder extends RecyclerView.ViewHolder {
    private TextView txvName;
    private TextView txvPrice,txvDesc;
    private ImageView txvImage;

    public WatchItemViewHolder(@NonNull View view)
    {
        super(view);

        this.txvName = view.findViewById(R.id.txv_name);
        this.txvPrice = view.findViewById(R.id.txv_price);
        this.txvImage = view.findViewById(R.id.imgDetail);
        this.txvDesc = view.findViewById(R.id.txtDetail);
    }

    public TextView getTxvDesc() {
        return txvDesc;
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
