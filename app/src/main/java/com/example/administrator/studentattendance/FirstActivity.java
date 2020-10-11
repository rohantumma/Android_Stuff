package com.example.administrator.studentattendance;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FirstActivity extends AppCompatActivity {
ImageButton admin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        admin=(ImageButton) findViewById(R.id.badmin);

    }
    public void movetoLogin(View view)
    {
        final Context context=this;
        Intent intent= new Intent(context,LoginActivity.class);
        startActivity(intent);
        finish();

    }
    public void movetoStaffLogin(View view)
    {
        final Context context=this;
        Intent intent= new Intent(context,StaffLoginActivity.class);
        startActivity(intent);
        finish();
    }

}
