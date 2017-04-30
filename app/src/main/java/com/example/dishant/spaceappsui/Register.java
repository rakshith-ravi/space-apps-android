package com.example.dishant.spaceappsui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class Register extends Fragment {

    LinearLayout login;
    Button signup;
    EditText fname, lname, uname, pwd, cpwd, email;
    private APIService mAPIService;
    String password, name, user, mail;

    public Register() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        login = (LinearLayout) view.findViewById(R.id.login);
        signup = (Button) view.findViewById(R.id.signup);

        fname = (EditText) view.findViewById(R.id.first_name);
        lname = (EditText) view.findViewById(R.id.sec_name);
        uname = (EditText) view.findViewById(R.id.user_name);
        pwd = (EditText) view.findViewById(R.id.password1);
        cpwd = (EditText) view.findViewById(R.id.password2);
        email = (EditText) view.findViewById(R.id.email);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Login fragment = new Login();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 name = fname.getText().toString() + " " + lname.getText().toString();
                    password = pwd.getText().toString();

                 user = uname.getText().toString();
                 mail = email.getText().toString();
                sendPost(name,password, user, mail );
            }
        });

        return view;
    }

    public void sendPost(String name, String password, String username, String email) {
        mAPIService.saveRegister(name, password, username, email).enqueue(new Callback<LoginPost>() {
            @Override
            public void onResponse(Call<LoginPost> call, Response<LoginPost> response) {

                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<LoginPost> call, Throwable t) {
                Log.e(TAG, "Unable to submit post to API.");
            }
        });
    }

    public void showResponse(String response) {
        Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();
    }

}
