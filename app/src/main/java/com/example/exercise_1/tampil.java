package com.example.exercise_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class tampil extends AppCompatActivity {

    TextView Task,Jenis,Lama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        Task = findViewById(R.id.tv_namaTugas);
        Jenis = findViewById(R.id.tv_jenisTugas);
        Lama = findViewById(R.id.tv_waktuTugas);

        Bundle bundle = getIntent().getExtras();

        String task = bundle.getString("a");
        String jenis = bundle.getString("b");
        String lama = bundle.getString("c");

        Task.setText(task);
        Jenis.setText(jenis);
        Lama.setText(lama);
    }
}