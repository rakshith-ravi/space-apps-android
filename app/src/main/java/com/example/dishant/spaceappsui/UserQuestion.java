package com.example.dishant.spaceappsui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dishant.spaceappsui.ViewModels.QuestionModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserQuestion extends Fragment {

    RecyclerView recyclerView;
    List<QuestionModel> data;

    public UserQuestion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_question, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.question_recycler);
        QuestionAdapter questionAdapter = new QuestionAdapter(getActivity(), getQuestionData(), new QuestionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(QuestionModel info) {

            }
        });

        recyclerView.setAdapter(questionAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

    public List<QuestionModel> getQuestionData(){
        data = new ArrayList<>();
        String que = "Is an adder poisonous?";
        String ans = "The adder is the only venomous snake native to Britain.";
        String ansd = "DarthVader";
        int ups = 137;
        for(int i=0; i<10; i++){
            QuestionModel current = new QuestionModel();
            current.question = que;
            current.answer = ans;
            current.answered = ansd;
            current.upvotes = ups;
            data.add(current);
        }

        return data;
    }

}
