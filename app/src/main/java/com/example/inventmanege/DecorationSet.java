package com.example.inventmanege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Display;
import android.widget.LinearLayout;
import android.widget.TextView;

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

public class DecorationSet extends AppCompatActivity {

    private Worker worker;
    private InventServerAPI inventServerAPI;
    private String local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoration_set);

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

        Call<List<Inventory>> call = inventServerAPI.getDecorations(map);

        call.enqueue(new Callback<List<Inventory>>() {
            @Override
            public void onResponse(Call<List<Inventory>> call, Response<List<Inventory>> response) {
                if (response.isSuccessful()) {
                    drawInv(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Inventory>> call, Throwable t) {
                int a = 0;
            }
        });
    }

    public void drawInv(List<Inventory> inventories) {
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();//Это ложь

        LinearLayout container = findViewById(R.id.DecorationScroll);

        for (Inventory inv : inventories) {
            LinearLayout layout = new LinearLayout(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 0, 0, 20);
            layout.setLayoutParams(params);
            layout.setPadding(10, 10, 10, 10);

            TextView textView = new TextView(this);
            if (local.equals("UA")) {
                textView.setText(Html.fromHtml("<b>Id: </b>" +
                        inv.getIdinv() + "<br/>" +
                        "<b>Назва: </b>" +
                        inv.getInvName() + "<br/>" +
                        "<b>Відповідальний: </b>" +
                        inv.getInvRespName() + "<br/>" +
                        "<b>Інструкція: </b>" +
                        inv.getInvInstruction() + "<br/>" +
                        "<b>Вага: </b>" +
                        inv.getInvWeight() + "<br/>" +
                        "<b>Тип: </b>" +
                        inv.getInvTypeName() + "<br/>" +
                        "<b>Місцезнаходження: <u>" +
                        inv.getInvPositionName() + "</u></b>"));
            } else {
                textView.setText(Html.fromHtml("<b>Id: </b>" +
                        inv.getIdinv() + "<br/>" +
                        "<b>Name: </b>" +
                        inv.getInvName() + "<br/>" +
                        "<b>Responsible: </b>" +
                        inv.getInvRespName() + "<br/>" +
                        "<b>Instruction: </b>" +
                        inv.getInvInstruction() + "<br/>" +
                        "<b>Weight: </b>" +
                        inv.getInvWeight() + "<br/>" +
                        "<b>Type: </b>" +
                        inv.getInvTypeName() + "<br/>" +
                        "<b>Position: <u>" +
                        inv.getInvPositionName() + "</u></b>"));
            }
            textView.setTextSize(24);

            layout.addView(textView);

            layout.setBackgroundColor(Color.GRAY);

            container.addView(layout);
        }


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DecorationSet.this, OptionsMain.class);

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