package com.example.administrator.studentattendance;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainPageActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    final Context context = this;

   /*  Navigation Drawer code
    private DrawerLayout dl;
    private ActionBarDrawerToggle adt;
    NavigationView navigationView;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


       /* --------------Navigation Drawer code------------------------------
        dl = (DrawerLayout) findViewById(R.id.activity_main);
        adt = new ActionBarDrawerToggle(this, dl, R.string.open, R.string.close);
        final Context context = this;

        dl.addDrawerListener(adt);
        adt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView=(NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

               switch (menuItem.getItemId())
               {
                   case R.id.nav_s_entry:
                       Intent intent1= new Intent(context,StudentActivity.class);
                       startActivity(intent1);
                       menuItem.setChecked(true);
                       break;

                   case R.id.nav_entry:
                       Intent intent2= new Intent(context,StaffActivity.class);
                       startActivity(intent2);
                       menuItem.setChecked(true);
                       break;

                   case R.id.nav_update:
                       Intent intent3= new Intent(context,UpdateAttendanceActivity.class);
                       startActivity(intent3);
                       menuItem.setChecked(true);
                       break;

                   case R.id.nav_list:
                       Intent intent4= new Intent(context,ShowAttendanceActivity.class);
                       startActivity(intent4);
                       menuItem.setChecked(true);
                       break;

                   case R.id.nav_help:
                       Intent intent5= new Intent(context,HelpActivity.class);
                       startActivity(intent5);
                       menuItem.setChecked(true);
                       break;

                   case R.id.nav_logout:
                       sharedPreferences= getSharedPreferences("login",MODE_PRIVATE);
                       SharedPreferences.Editor editor=sharedPreferences.edit();
                       editor.clear();
                       editor.commit();
                     //  Toast.makeText(getApplicationContext(),"Logout from app successfully!!!",Toast.LENGTH_SHORT).show();
                       Intent intent6 = new Intent(context,LoginActivity.class);
                       startActivity(intent6);
                       menuItem.setChecked(true);
                       break;

               }
                    return true;
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (adt.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);*/
    }

    //--------------- code for moving to next activity

    public void movetostudent(View view){
        Intent intent= new Intent(context,StudentActivity.class);
        startActivity(intent);
    }
    public void movetoview(View view){
        Intent intent= new Intent(context,ShowStudentRecordActivity.class);
        startActivity(intent);
    }
    public void movetostaff(View view){
        Intent intent= new Intent(context,StaffActivity.class);
        startActivity(intent);
    }
    public void movetoviewstaff(View view){
        Intent intent= new Intent(context,ShowStaffRecordActivity.class);
        startActivity(intent);
    }
    public void movetologout(View view){
        sharedPreferences= getSharedPreferences("login",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.commit();
        Intent intent = new Intent(context,FirstActivity.class);
        startActivity(intent);
        finish();
    }

}
