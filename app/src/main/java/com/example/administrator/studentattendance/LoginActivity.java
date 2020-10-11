package com.example.administrator.studentattendance;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button login;
    TextView txt;
    int counter = 3;

    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.etuname);
        password = (EditText) findViewById(R.id.etpwd);
        login = (Button) findViewById(R.id.blogin);
        txt = (TextView) findViewById(R.id.textView);
        txt.setVisibility(View.GONE);

        sp = getSharedPreferences("login",MODE_PRIVATE);


        final Context context = this;

        if (sp.getBoolean("logged",false))
        {
            Intent intent = new Intent(context,MainPageActivity.class);
            startActivity(intent);
            finish();

        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (username.getText().toString().equals("admin") && password.getText().toString().equals("orchid"))
                {
                    Toast.makeText(getApplicationContext(),"Login Successful!!!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,MainPageActivity.class);
                    startActivity(intent);
                    finish();
                    sp.edit().putBoolean("logged",true).apply();



                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login Failed!!!",Toast.LENGTH_SHORT).show();

                    txt.setVisibility(View.VISIBLE);
                    txt.setBackgroundColor(Color.RED);
                    counter--;
                    txt.setText("  Attempts Left: "+ Integer.toString(counter));

                    if (counter == 0)
                    {
                        login.setEnabled(false);
                    }
                }
            }
        });


    }
}
