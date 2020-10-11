package com.example.administrator.studentattendance;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class StudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        ImageButton b1=(ImageButton) findViewById(R.id.imageButton);
    }

    public void movetoMainPage(View view)
    {
        final Context context=this;
        Intent intent=new Intent(context,MainPageActivity.class);
        startActivity(intent);
    }

    public void movetoBEADiv(View view)
    {
        final Context context=this;
        Intent intent= new Intent(context,BEADivActivity.class);
        startActivity(intent);
    }

    public void movetoBEBDiv(View view)
    {
        final Context context=this;
        Intent intent= new Intent(context,BEBDivActivity.class);
        startActivity(intent);
    }

    public void movetoTEADiv(View view)
    {
        final Context context=this;
        Intent intent= new Intent(context,TEADivActivity.class);
        startActivity(intent);
    }

    public void movetoTEBDiv(View view)
    {
        final Context context=this;
        Intent intent= new Intent(context,TEBDivActivity.class);
        startActivity(intent);
    }
    public void movetoSEADiv(View view)
    {
        final Context context=this;
        Intent intent= new Intent(context,SEADivActivity.class);
        startActivity(intent);
    }

    public void movetoSEBDiv(View view)
    {
        final Context context=this;
        Intent intent= new Intent(context,SEBDivActivity.class);
        startActivity(intent);
    }
    public void movetoFE(View view)
    {
        final Context context=this;
        Intent intent= new Intent(context,FEActivity.class);
        startActivity(intent);
    }

}
