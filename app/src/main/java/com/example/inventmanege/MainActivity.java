package com.example.inventmanege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.inventmanege.models.InventServerAPI;
import com.example.inventmanege.models.Worker;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private InventServerAPI inventServerAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logIn(View view) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        inventServerAPI = retrofit.create(InventServerAPI.class);


        Map<String, String> map = new HashMap<>();
        EditText loginEdit = findViewById(R.id.editTextTextPersonName);
        EditText passEdit = findViewById(R.id.editTextTextPassword);

        map.put("login", loginEdit.getText().toString());
        map.put("pass", passEdit.getText().toString());

        Call<Worker> call = inventServerAPI.getUser(map);

        call.enqueue(new Callback<Worker>() {
            @Override
            public void onResponse(Call<Worker> call, Response<Worker> response) {
                if (response.isSuccessful()) {
                    Worker worker = response.body();
                    Intent intent = new Intent(MainActivity.this, OptionsMain.class);

                    intent.putExtra("workerId", worker.getIdworker());
                    intent.putExtra("name", worker.getFullName());
                    intent.putExtra("companyId", worker.getIdCompany());
                    intent.putExtra("company", worker.getCompanyName());
                    intent.putExtra("role", worker.getIdrole());
                    intent.putExtra("local", "EN");

                    startActivity(intent);
                    finish();

                }
            }

            @Override
            public void onFailure(Call<Worker> call, Throwable t) {
                int a = 0;
            }
        });
    }
}