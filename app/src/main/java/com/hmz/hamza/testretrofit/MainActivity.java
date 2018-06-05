package com.hmz.hamza.testretrofit;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "MainActivity";
    private EditText username;
    private EditText password;
    private Button btn;
    private Button btnFind;
    private Button btnFinbyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = findViewById(R.id.id);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.button);
        btnFind = findViewById(R.id.button2);
        btnFinbyId = findViewById(R.id.button3);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = String.valueOf(username.getText());
                String pass = String.valueOf(password.getText());

                executeApiCallLogin(user, pass);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = String.valueOf(username.getText());
                String pass = String.valueOf(password.getText());

                executeApiCallLogin(user, pass);
            }
        });

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeApiCallFind();
            }
        });

        btnFinbyId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = String.valueOf(username.getText());
                executeApiCallFindById(user);
            }
        });
    }


    private void executeApiCallFindById(String user) {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<User> call = apiInterface.findByID(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG, "hani f onresponse");
                User user1 = response.body();
                Toast.makeText(MainActivity.this, user1.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }


    private void executeApiCallLogin(String user, String pass) {
        Log.d(TAG, user + ";" + pass);
        Log.d(TAG, "hani f executeApiCall");
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Integer> call = apiInterface.loginUser(user, pass);

        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {

                Log.d(TAG, "onResponse");
                Toast.makeText(MainActivity.this, String.valueOf(response.body()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.d(TAG, "onFailure");
                t.printStackTrace();


            }
        });

    }

    private void executeApiCallFind() {
        Log.d(TAG, "hani f executeApiCallFIND");
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<User>> call = apiInterface.findAll();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> users = response.body();
                for (User user : users) {
                    Log.d(TAG, user.toString());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
}
