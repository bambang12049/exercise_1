package com.example.exercise_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_nama,et_pass;
    Button login;
    String nama, pass;
    String isinama="vian";
    String isipassword="bodad";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nama=findViewById(R.id.et_nama);
        et_pass=findViewById(R.id.et_passowrd);
        login=findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regis();
            }
        });


    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        return super.onOptionsItemSelected(item);
//        if (item.getItemId() == R.id.mnDaftar)
//        {
//            Intent i = new Intent(getApplicationContext(), Register.class);
//            startActivity(i);
//        }
//        return super.onOptionsItemSelected(item);
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
    public void regis(){

        nama=et_nama.getText().toString();
        pass=et_pass.getText().toString();

        if (nama.isEmpty())

        {
            et_nama.setError("yang bener");
        }
        else if(pass.isEmpty())
        {
            et_pass.setError("serius");
        }

        else
        {
            if(!nama.equals(isinama) && !pass.equals(isipassword))
            {
                Toast bubble=Toast.makeText(getApplicationContext(),"nama dan password tidak sesuai",Toast.LENGTH_LONG);
                bubble.show();
            }
            else if(!nama.equals(isinama))
            {
                Toast bubble=Toast.makeText(getApplicationContext(),"nama tidak sesuai",Toast.LENGTH_LONG);
                bubble.show();
            }
            else if(!pass.equals(isipassword))
            {
                Toast bubble=Toast.makeText(getApplicationContext(),"password tidak sesuai",Toast.LENGTH_LONG);
                bubble.show();
            }

            else
            {
                Bundle a = new Bundle();
                a.putString("a", nama.trim());


                Intent b = new Intent(getApplicationContext(), input.class);

                b.putExtras(a);
                startActivity(b);
                Toast bubble=Toast.makeText(getApplicationContext(),"sukses",Toast.LENGTH_LONG);
                bubble.show();
            }
        }

    }


}