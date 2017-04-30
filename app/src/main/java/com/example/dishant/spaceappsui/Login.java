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
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {

    EditText uname, pwd;
    String username, password;
    Button login;
    LinearLayout signup;
    private APIService mAPIService;

    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        uname = (EditText) view.findViewById(R.id.username);
        pwd = (EditText) view.findViewById(R.id.password);
        login = (Button) view.findViewById(R.id.login);
        signup = (LinearLayout) view.findViewById(R.id.sign_up);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                username = uname.getText().toString();
                password = pwd.getText().toString();
                if(username.isEmpty() || password.isEmpty()){
                    Toast.makeText(getActivity(), "Kindly fill all credentials", Toast.LENGTH_LONG).show();
                }
                else{
                    sendPost(username, password);
                }
                */
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Register fragment = new Register();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    public void sendPost(String username, String password) {
        mAPIService.saveLogin(username, password).enqueue(new Callback<LoginPost>() {
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
