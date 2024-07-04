package com.example.inventmanege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Display;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.inventmanege.models.Car;
import com.example.inventmanege.models.InventServerAPI;
import com.example.inventmanege.models.Inventory;
import com.example.inventmanege.models.Worker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarSet extends AppCompatActivity {

    private Worker worker;
    private InventServerAPI inventServerAPI;
    private String local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_set);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        worker = new Worker();

        worker.setIdworker(intent.getIntExtra("workerId", 0));
        worker.setFullName(intent.getStringExtra("name"));
        worker.setIdCompany(intent.getIntExtra("companyId", 0));
        worker.setCompanyName(intent.getStringExtra("company"));
        worker.setIdrole(intent.getIntExtra("role", 0));
        local = intent.getStringExtra("local");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        inventServerAPI = retrofit.create(InventServerAPI.class);

        Map<String, String> map = new HashMap<>();

        map.put("company", worker.getIdCompany() + "");

        Call<List<Car>> call = inventServerAPI.getCars(map);

        call.enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                if (response.isSuccessful()) {
                    drawInv(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {
                int a = 0;
            }
        });
    }

    public void drawInv(List<Car> cars) {
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();//Это ложь

        LinearLayout container = findViewById(R.id.CarScroll);

        for (Car car : cars) {
            LinearLayout layout = new LinearLayout(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 0, 0, 20);
            layout.setLayoutParams(params);
            layout.setPadding(10, 10, 10, 10);

            String trList = "";

            for (Inventory inv : car.getTransportList()) {
                trList += "<br/>   ---   <b>" + inv.getIdinv() + "</b>: " + inv.getInvName();
            }

            if (trList == "") {
                trList = "<br/><b> NONE</b>";
            }

            TextView textView = new TextView(this);
            if (local.equals("UA")) {
                textView.setText(Html.fromHtml("<b>Id: </b>" + car.getIdCar() + "<br/>" +
                        "<b>Найменування: </b>" + car.getCarName() + "<br/>" +
                        "<b>Вантажопідйомність: </b>" + car.getCarCarrying() + "<br/>-------------------------<br/>" +
                        "<b>Список перевезення: </b>" + trList));
            } else {
                textView.setText(Html.fromHtml("<b>Id: </b>" + car.getIdCar() + "<br/>" +
                        "<b>Name: </b>" + car.getCarName() + "<br/>" +
                        "<b>Carrying: </b>" + car.getCarCarrying() + "<br/>-------------------------<br/>" +
                        "<b>Transport list: </b>" + trList));
            }
            textView.setTextSize(24);

            layout.addView(textView);

            layout.setBackgroundColor(Color.GRAY);

            container.addView(layout);
        }


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CarSet.this, OptionsMain.class);

        intent.putExtra("workerId", worker.getIdworker());
        intent.putExtra("name", worker.getFullName());
        intent.putExtra("companyId", worker.getIdCompany());
        intent.putExtra("company", worker.getCompanyName());
        intent.putExtra("role", worker.getIdrole());
        intent.putExtra("local", local);

        startActivity(intent);
        finish();
    }
}