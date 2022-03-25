package com.example.exercise_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class input extends AppCompatActivity {

    TextView Email;
    EditText Task, JenisTask,Lamatask;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Task = findViewById(R.id.et_namaTugas);
        JenisTask = findViewById(R.id.et_jenisTugas);
        Lamatask = findViewById(R.id.et_waktuTugas);
        Email = findViewById(R.id.tv_nama);

        fab = findViewById(R.id.floatingActionButton);

        Bundle bundle = getIntent().getExtras();

        String email = bundle.getString("a");


        Email.setText(email);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.mninput){
            validate();
        }
        else {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void validate(){
        if (Task.getText().toString().isEmpty() && JenisTask.getText().toString().isEmpty() &&Lamatask.getText().toString().isEmpty() ){
            Toast toast= Toast.makeText(getApplicationContext(),
                    "Isi Semua Data "  , Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }
        else if (Task.getText().toString().isEmpty() ){
            Task.setError("Masukan Task!");
        }
        else if (JenisTask.getText().toString().isEmpty() ){
            JenisTask.setError("Jenis Task!");
        }
        else if (Lamatask.getText().toString().isEmpty() ){
            Lamatask.setError("Lama Task!");
        }
        else{

            Bundle b = new Bundle();
            //key parsing data dimasukan kedalam bundle
            b.putString("a", Task.getText().toString().trim());
            b.putString("b", JenisTask.getText().toString().trim());
            b.putString("c", Lamatask.getText().toString().trim());
            Intent i  = new Intent(getApplicationContext(), tampil.class);
            i.putExtras(b);
            startActivity(i);
            Toast toast= Toast.makeText(getApplicationContext(),
                    "Berhasil"  , Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }
    }
}