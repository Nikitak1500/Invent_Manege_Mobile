package com.example.inventmanege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.inventmanege.models.Worker;

public class OptionsMain extends AppCompatActivity {

    private Worker worker;
    private String local = "EN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_main);

        Intent intent = getIntent();

        worker = new Worker();

        worker.setIdworker(intent.getIntExtra("workerId", 0));
        worker.setFullName(intent.getStringExtra("name"));
        worker.setIdCompany(intent.getIntExtra("companyId", 0));
        worker.setCompanyName(intent.getStringExtra("company"));
        worker.setIdrole(intent.getIntExtra("role", 0));
        local = intent.getStringExtra("local");
        Localize();

        if (worker.getIdrole() == 1) {
            findViewById(R.id.CostumesBlock).setVisibility(View.INVISIBLE);
            findViewById(R.id.CostumesBlock).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            findViewById(R.id.RequisiteBlock).setVisibility(View.INVISIBLE);
            findViewById(R.id.RequisiteBlock).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            findViewById(R.id.DecorationBlock).setVisibility(View.INVISIBLE);
            findViewById(R.id.DecorationBlock).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            findViewById(R.id.WorkerBlock).setVisibility(View.INVISIBLE);
            findViewById(R.id.WorkerBlock).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            findViewById(R.id.CarBlock).setVisibility(View.INVISIBLE);
            findViewById(R.id.CarBlock).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            findViewById(R.id.StorageBlock).setVisibility(View.INVISIBLE);
            findViewById(R.id.StorageBlock).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        }
    }

    public void RespOnClick(View view) {
        Intent intent = new Intent(OptionsMain.this, RespInv.class);

        intent.putExtra("workerId", worker.getIdworker());
        intent.putExtra("name", worker.getFullName());
        intent.putExtra("companyId", worker.getIdCompany());
        intent.putExtra("company", worker.getCompanyName());
        intent.putExtra("role", worker.getIdrole());
        intent.putExtra("local", local);

        startActivity(intent);
        finish();
    }

    public void MyAccClick(View view) {
        Intent intent = new Intent(OptionsMain.this, MyAcc.class);

        intent.putExtra("workerId", worker.getIdworker());
        intent.putExtra("name", worker.getFullName());
        intent.putExtra("companyId", worker.getIdCompany());
        intent.putExtra("company", worker.getCompanyName());
        intent.putExtra("role", worker.getIdrole());
        intent.putExtra("local", local);

        startActivity(intent);
        finish();
    }

    public void CostumeClick(View view) {
        Intent intent = new Intent(OptionsMain.this, CostumeSet.class);

        intent.putExtra("workerId", worker.getIdworker());
        intent.putExtra("name", worker.getFullName());
        intent.putExtra("companyId", worker.getIdCompany());
        intent.putExtra("company", worker.getCompanyName());
        intent.putExtra("role", worker.getIdrole());
        intent.putExtra("local", local);

        startActivity(intent);
        finish();
    }

    public void RequisiteClick(View view) {
        Intent intent = new Intent(OptionsMain.this, RequisiteSet.class);

        intent.putExtra("workerId", worker.getIdworker());
        intent.putExtra("name", worker.getFullName());
        intent.putExtra("companyId", worker.getIdCompany());
        intent.putExtra("company", worker.getCompanyName());
        intent.putExtra("role", worker.getIdrole());
        intent.putExtra("local", local);

        startActivity(intent);
        finish();
    }

    public void DecorationClick(View view) {
        Intent intent = new Intent(OptionsMain.this, DecorationSet.class);

        intent.putExtra("workerId", worker.getIdworker());
        intent.putExtra("name", worker.getFullName());
        intent.putExtra("companyId", worker.getIdCompany());
        intent.putExtra("company", worker.getCompanyName());
        intent.putExtra("role", worker.getIdrole());
        intent.putExtra("local", local);

        startActivity(intent);
        finish();
    }

    public void WorkerClick(View view) {
        Intent intent = new Intent(OptionsMain.this, WorkersSet.class);

        intent.putExtra("workerId", worker.getIdworker());
        intent.putExtra("name", worker.getFullName());
        intent.putExtra("companyId", worker.getIdCompany());
        intent.putExtra("company", worker.getCompanyName());
        intent.putExtra("role", worker.getIdrole());
        intent.putExtra("local", local);

        startActivity(intent);
        finish();
    }

    public void CarClick(View view) {
        Intent intent = new Intent(OptionsMain.this, CarSet.class);

        intent.putExtra("workerId", worker.getIdworker());
        intent.putExtra("name", worker.getFullName());
        intent.putExtra("companyId", worker.getIdCompany());
        intent.putExtra("company", worker.getCompanyName());
        intent.putExtra("role", worker.getIdrole());
        intent.putExtra("local", local);

        startActivity(intent);
        finish();
    }

    public void StorageClick(View view) {
        Intent intent = new Intent(OptionsMain.this, StorageSet.class);

        intent.putExtra("workerId", worker.getIdworker());
        intent.putExtra("name", worker.getFullName());
        intent.putExtra("companyId", worker.getIdCompany());
        intent.putExtra("company", worker.getCompanyName());
        intent.putExtra("role", worker.getIdrole());
        intent.putExtra("local", local);

        startActivity(intent);
        finish();
    }

    public void QuitClick(View view) {
        Intent intent = new Intent(OptionsMain.this, MainActivity.class);

        startActivity(intent);
        finish();
    }

    public void LocalClick(View view) {
        if (local.equals("UA")) {
            local = "EN";
        } else {
            local = "UA";
        }
        Localize();
    }

    public void Localize() {
        if (local.equals("UA")) {
            TextView textView4 = findViewById(R.id.textView4);
            TextView textView3 = findViewById(R.id.textView3);
            TextView textView6 = findViewById(R.id.textView6);
            TextView textView7 = findViewById(R.id.textView7);
            TextView textView8 = findViewById(R.id.textView8);
            TextView textView9 = findViewById(R.id.textView9);
            TextView textView10 = findViewById(R.id.textView10);
            TextView textView11 = findViewById(R.id.textView11);
            TextView textView13 = findViewById(R.id.textView13);
            TextView textView12 = findViewById(R.id.textView12);

            textView4.setText("Мій аккаунт");
            textView3.setText("Мій інвентар");
            textView6.setText("Костюми");
            textView7.setText("Реквізит");
            textView8.setText("Декорації");
            textView9.setText("Робітники");
            textView10.setText("Автомобілі");
            textView11.setText("Хранилища");
            textView13.setText("Українська");
            textView12.setText("Вийти");
        } else {
            TextView textView4 = findViewById(R.id.textView4);
            TextView textView3 = findViewById(R.id.textView3);
            TextView textView6 = findViewById(R.id.textView6);
            TextView textView7 = findViewById(R.id.textView7);
            TextView textView8 = findViewById(R.id.textView8);
            TextView textView9 = findViewById(R.id.textView9);
            TextView textView10 = findViewById(R.id.textView10);
            TextView textView11 = findViewById(R.id.textView11);
            TextView textView13 = findViewById(R.id.textView13);
            TextView textView12 = findViewById(R.id.textView12);

            textView4.setText("My Account");
            textView3.setText("  Responsible Inventory");
            textView6.setText("Costumes");
            textView7.setText("Requisites");
            textView8.setText("Decorations");
            textView9.setText("Workers");
            textView10.setText("Cars");
            textView11.setText("Storages");
            textView13.setText("English");
            textView12.setText("Exit");
        }
    }
}