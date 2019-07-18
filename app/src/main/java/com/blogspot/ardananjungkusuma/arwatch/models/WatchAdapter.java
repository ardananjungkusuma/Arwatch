package com.blogspot.ardananjungkusuma.arwatch.models;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.ardananjungkusuma.arwatch.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class WatchAdapter extends RecyclerView.Adapter<WatchAdapter.WatchViewHolder> {
    private List<Watch> listWatch = new ArrayList<>();

    public WatchAdapter(List<Watch>listWatch){
        this.listWatch=listWatch;
    }

    private OnWatchClickListener listener;

    public interface OnWatchClickListener {
        public void onClick(View view, int position);
    }

    public void setListener(OnWatchClickListener listener){
        this.listener=listener;
    }

    @NonNull
    @Override
    public WatchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vh = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_watch,viewGroup,false);
        WatchViewHolder viewHolder = new WatchViewHolder(vh);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WatchViewHolder WatchViewHolder, int i) {
        Watch item=listWatch.get(i);
        WatchViewHolder.txtDesc.setText(item.getDesc());
        WatchViewHolder.txtName.setText(item.getName());
        WatchViewHolder.txtDetail.setText(item.getDetail());
        Picasso.get().load(item.getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(WatchViewHolder.imageWatch);
    }

    @Override
    public int getItemCount() {
        return listWatch.size();
    }

    public class WatchViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageWatch;
        public TextView txtName, txtDesc,txtDetail;

        public WatchViewHolder(@NonNull View itemView){
            super(itemView);
            imageWatch=itemView.findViewById(R.id.imageWatch);
            txtName=itemView.findViewById(R.id.txtName);
            txtDesc=itemView.findViewById(R.id.txtDesc);
            txtDetail=itemView.findViewById(R.id.txtDetail);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    listener.onClick(v, getAdapterPosition());
                }
            });
        }
    }
}
