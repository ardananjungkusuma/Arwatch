package com.ardananjung.arwatch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ardananjung.arwatch.R;
import com.ardananjung.arwatch.data.Watch;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerWatchListAdapter extends RecyclerView.Adapter<WatchItemViewHolder> {
    private Context context;
    private List<Watch> watchList;

    private OnWatchClickListener listener;

    public interface OnWatchClickListener {
        public void onClick(View view, int position);
    }

    public void setListener(OnWatchClickListener listener){
        this.listener=listener;
    }

    public RecyclerWatchListAdapter(Context context)
    {
        this.context = context;
    }

    public List<Watch> getWatchList()
    {
        return watchList;
    }

    public void setWatchList(List<Watch> watchList)
    {
        this.watchList= watchList;

        // Biar nge-refresh
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WatchItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // Dapatkan inflater
        LayoutInflater inflater = LayoutInflater.from(this.context);

        // Render view pakai inflater
        View watchItemView = inflater.inflate(R.layout.watch_item_view, parent, false);

        // View-nya dilempar ke ViewHolder
        WatchItemViewHolder vhWatchItem = new WatchItemViewHolder(watchItemView);

        // Jadikan nilai balik method ini
        return vhWatchItem;
    }
    // Ketika sedang me-render satu-persatu baris dari RecyclerView-nya...
    // Terjadi pe-renderan view holder satu persatu juga.


    @Override
    public void onBindViewHolder(@NonNull WatchItemViewHolder holder, int position)
    {
        // Dapatkan data di posisi saat ini...
        Watch currentWatch = this.watchList.get(position);

        // Pasang datanya di ViewHolder saat ini
        String name = currentWatch.getName();
        String price = currentWatch.getPrice();
        String image = currentWatch.getImgUrl();

        holder.getTxvName().setText(name);
        holder.getTxvPrice().setText(price);
        Picasso.get().load(image).placeholder(R.drawable.ic_launcher_background).into(holder.getTxvImage());//todo : picasso
    }

    @Override
    public int getItemCount()
    {
        if(this.watchList== null)
            return 0;
        else
            return this.watchList.size();
    }
}
