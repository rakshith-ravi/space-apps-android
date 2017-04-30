package com.example.dishant.spaceappsui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dishant.spaceappsui.ViewModels.Info;

import java.util.Collections;
import java.util.List;

/**
 * Created by dishant on 30/4/17.
 */


    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

        List<Info> data= Collections.emptyList();
        LayoutInflater layoutInflater;
        private Context context;

        public interface ClickListener{
            public void itemClicked(Info info);
        }

        private RecyclerAdapter.ClickListener listener;

        public RecyclerAdapter(Context context, List<Info> data, RecyclerAdapter.ClickListener listener ) {
            layoutInflater=LayoutInflater.from(context);
            this.data=data;
            this.listener = listener;
            this.context = context;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= layoutInflater.inflate(R.layout.row, parent, false);
            MyViewHolder viewHolder=new MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Info current=data.get(position);
            holder.bind(current, listener);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView title;
            ImageView icon;
            public MyViewHolder(View itemView) {
                super(itemView);
                title= (TextView)itemView.findViewById(R.id.title);
                icon=(ImageView)itemView.findViewById(R.id.icon);
                itemView.setClickable(true);
            }

            public void bind(final Info info, final RecyclerAdapter.ClickListener listener){
                title.setText(info.title);
                icon.setImageResource(info.icon_id);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.itemClicked(info);
                    }
                });
            }
        }


    }

