package com.example.administrator.studentattendance;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class SignUpActivity extends AppCompatActivity {

    EditText ET_NAME,ET_USER_NAME,ET_USER_PASS;
    String name,user_name,user_pass;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ET_NAME=(EditText)findViewById(R.id.name);
        ET_USER_NAME=(EditText)findViewById(R.id.new_user_name);
        ET_USER_PASS=(EditText)findViewById(R.id.new_user_pass);
    }



    public void userReg(View view) {
        name = ET_NAME.getText().toString();
        user_name = ET_USER_NAME.getText().toString();
        user_pass = ET_USER_PASS.getText().toString();
        String method = "SignUp";
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "http://192.168.43.63/webapp/signUp.php?user_name="+user_name+"&user_pass="+user_pass+"&user="+name;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"sucessfully register",Toast.LENGTH_LONG).show();


                Intent intent = new Intent(context,StaffLoginActivity.class);
                startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),""+error.toString(),Toast.LENGTH_LONG).show();



            }
        });
        requestQueue.add(stringRequest);

    }

}
