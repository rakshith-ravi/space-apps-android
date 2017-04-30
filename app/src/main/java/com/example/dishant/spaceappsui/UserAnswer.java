package com.example.dishant.spaceappsui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dishant.spaceappsui.ViewModels.AnswerModel;
import com.example.dishant.spaceappsui.ViewModels.QuestionModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserAnswer extends Fragment {

    RecyclerView recyclerView;
    List<AnswerModel> data;

    public UserAnswer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_answer, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.answer_recycler);
        AnswerAdapter answerAdapter = new AnswerAdapter(getActivity(), getAnswerData(), new AnswerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(AnswerModel info) {

            }
        });

        recyclerView.setAdapter(answerAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;
    }

    public List<AnswerModel> getAnswerData(){

        data = new ArrayList<>();

        String que = "Is an adder poisonous?";
        String ans = "The adder is the only venomous snake native to Britain.";
        String asked = "DarthVader";
        int ups = 137;
        int reps = 22;
        for(int i=0; i<10; i++){
            AnswerModel current = new AnswerModel();
            current.question = que;
            current.answer = ans;
            current.asked_by = asked;
            current.replies = reps;
            current.upvotes = ups;
            data.add(current);
        }

        return data;
    }

}
