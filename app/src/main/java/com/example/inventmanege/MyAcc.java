package com.example.inventmanege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.inventmanege.models.Worker;

public class MyAcc extends AppCompatActivity {

    private Worker worker;
    private String local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_acc);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        worker = new Worker();

        worker.setIdworker(intent.getIntExtra("workerId", 0));
        worker.setFullName(intent.getStringExtra("name"));
        worker.setIdCompany(intent.getIntExtra("companyId", 0));
        worker.setCompanyName(intent.getStringExtra("company"));
        worker.setIdrole(intent.getIntExtra("role", 0));
        local = intent.getStringExtra("local");

        TextView textView = findViewById(R.id.textView5);

        if (local.equals("UA")) {
            if (worker.getIdrole() == 2) {
                textView.setText(Html.fromHtml("<b>ID Компанії:</b><br/>" + worker.getIdCompany() + "<br/><br/>" +
                        "<b>Назва компанії:</b><br/>" + worker.getCompanyName() + "<br/>---------------------------------------<br/><br/>" +
                        "<b>ID Робітника:</b><br/>" + worker.getIdworker() + "<br/><br/>" +
                        "<b>ПІБ:</b><br/>" + worker.getFullName() + "<br/><br/>" +
                        "<b>Посада:</b><br/>Адміністратор"));
            } else {
                textView.setText(Html.fromHtml("<b>ID Компанії:</b><br/>" + worker.getIdCompany() + "<br/><br/>" +
                        "<b>Назва компанії:</b><br/>" + worker.getCompanyName() + "<br/>---------------------------------------<br/><br/>" +
                        "<b>ID Робітника:</b><br/>" + worker.getIdworker() + "<br/><br/>" +
                        "<b>ПІБ:</b><br/>" + worker.getFullName() + "<br/><br/>" +
                        "<b>Посада:</b><br/>Робітник"));
            }
        } else {
            if (worker.getIdrole() == 2) {
                textView.setText(Html.fromHtml("<b>Company ID:</b><br/>" + worker.getIdCompany() + "<br/><br/>" +
                        "<b>Company name:</b><br/>" + worker.getCompanyName() + "<br/>---------------------------------------<br/><br/>" +
                        "<b>Worker ID:</b><br/>" + worker.getIdworker() + "<br/><br/>" +
                        "<b>Full name:</b><br/>" + worker.getFullName() + "<br/><br/>" +
                        "<b>Role:</b><br/>Admin"));
            } else {
                textView.setText(Html.fromHtml("<b>Company ID:</b><br/>" + worker.getIdCompany() + "<br/><br/>" +
                        "<b>Company name:</b><br/>" + worker.getCompanyName() + "<br/>---------------------------------------<br/><br/>" +
                        "<b>Worker ID:</b><br/>" + worker.getIdworker() + "<br/><br/>" +
                        "<b>Full name:</b><br/>" + worker.getFullName() + "<br/><br/>" +
                        "<b>Role:</b><br/>Worker"));
            }
        }


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MyAcc.this, OptionsMain.class);

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