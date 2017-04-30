package com.example.dishant.spaceappsui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dishant.spaceappsui.ViewModels.AnswerModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by dishant on 30/4/17
 */

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder>{

    Context context;
    List<AnswerModel> data = Collections.EMPTY_LIST;
    private LayoutInflater layoutInflater;

    public interface OnItemClickListener{
        public void onItemClick(AnswerModel info);
    }

    private AnswerAdapter.OnItemClickListener listener;

    public AnswerAdapter(Context context, List<AnswerModel> data, AnswerAdapter.OnItemClickListener listener){
        this.data = data;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.listener = listener;
    }

    @Override
    public AnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.answer_card, parent, false);
        AnswerViewHolder answerViewHolder = new AnswerViewHolder(view);
        return answerViewHolder;
    }

    @Override
    public void onBindViewHolder(AnswerViewHolder holder, int position) {
        AnswerModel current = data.get(position);
        holder.bind(current, listener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class AnswerViewHolder extends RecyclerView.ViewHolder{

        TextView question, answer, asked, replies, upvotes;


        public AnswerViewHolder(View itemView) {
            super(itemView);

            question = (TextView) itemView.findViewById(R.id.question);
            answer = (TextView) itemView.findViewById(R.id.answer);
            asked = (TextView) itemView.findViewById(R.id.asked);
            replies = (TextView) itemView.findViewById(R.id.replies);
            upvotes = (TextView) itemView.findViewById(R.id.upvotes);

        }

        public void bind(final AnswerModel info, final AnswerAdapter.OnItemClickListener listener){
            question.setText(info.question);
            answer.setText(info.answer);
            asked.setText("asked by " + info.asked_by);
            replies.setText("Replies: " + info.replies);
            upvotes.setText("Upvotes: " + String.valueOf(info.upvotes));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(info);
                }
            });
        }
    }

}
