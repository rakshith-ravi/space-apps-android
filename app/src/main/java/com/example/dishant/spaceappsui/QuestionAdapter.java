package com.example.dishant.spaceappsui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dishant.spaceappsui.ViewModels.QuestionModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by dishant on 30/4/17.
 */

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    Context context;
    List<QuestionModel> data = Collections.EMPTY_LIST;
    private LayoutInflater layoutInflater;

    public interface OnItemClickListener{
        public void onItemClick(QuestionModel info);
    }

    private OnItemClickListener listener;

    public QuestionAdapter(Context context, List<QuestionModel> data, OnItemClickListener listener){

        this.data = data;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.listener = listener;

    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.question_card, parent, false);
        QuestionViewHolder questionViewHolder = new QuestionViewHolder(view);
        return questionViewHolder;
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {
        QuestionModel current = data.get(position);
        holder.bind(current, listener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder{

        TextView question, answer, answered, upvotes;

        public QuestionViewHolder(View itemView) {
            super(itemView);

            question = (TextView) itemView.findViewById(R.id.question);
            answer = (TextView) itemView.findViewById(R.id.answer);
            answered = (TextView) itemView.findViewById(R.id.answered);
            upvotes = (TextView) itemView.findViewById(R.id.upvotes);

        }

        public void bind(final QuestionModel info, final QuestionAdapter.OnItemClickListener listener){

            question.setText(info.question);
            answer.setText(info.answer);
            answered.setText("answered by " + info.answered);
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
