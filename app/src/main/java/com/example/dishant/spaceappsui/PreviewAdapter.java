package com.example.dishant.spaceappsui;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by dishant on 30/4/17.
 */

public class PreviewAdapter extends RecyclerView.Adapter<PreviewAdapter.PreviewViewHolder> {

    private Context context;
    private ArrayList<Uri> data;
    private LayoutInflater layoutInflater;
    Uri current;

    public PreviewAdapter(Context context, ArrayList<Uri> data){
        this.data = data;
        layoutInflater = (LayoutInflater.from(context));
        this.context = context;
    }


    @Override
    public PreviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.img_preview, parent, false);
        PreviewViewHolder previewViewHolder = new PreviewViewHolder(view);
        return previewViewHolder;
    }

    @Override
    public void onBindViewHolder(PreviewViewHolder holder, int position) {
        current = data.get(position);
        holder.imageView.setImageURI(current);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class PreviewViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        public PreviewViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }

}

