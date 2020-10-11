package com.example.administrator.studentattendance;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class StaffLoginActivity extends AppCompatActivity {
    EditText ET_NAME,ET_PASS;
    String login_name,login_pass;
    //Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);
        ET_NAME= (EditText) findViewById(R.id.user_name);
        ET_PASS= (EditText) findViewById(R.id.user_pass);

    }

    public void userReg(View view)
    {
        startActivity(new Intent(this,SignUpActivity.class));
    }

    public void userLogin(View view)
    {
        //final Context ctx=this;

        login_name = ET_NAME.getText().toString();
        login_pass = ET_PASS.getText().toString();
        String method = "login";

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
// http://localhost/webapp/login.php?login_name=pawar&login_pass=1233445
        String url = "http://192.168.43.63/webapp/login.php?login_name="+login_name+"&login_pass="+login_pass;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               char[] str=response.toCharArray();
               int i=2;
                //Toast.makeText(getApplicationContext(),""+str[9], Toast.LENGTH_LONG).show();

                if(str[i++]=='s' && str[i++]=='u' && str[i++]=='c' && str[i++]=='c') {

                    Toast.makeText(getApplicationContext(), " Successfully Login...", Toast.LENGTH_LONG).show();
                    //startActivity(new Intent(getApplicationContext(), MarkAttendanceActivity.class));
                    Intent intent=new Intent(StaffLoginActivity.this,DynamicCheckbox.class);
                     startActivity(intent);
                }

                else {
                    Toast.makeText(getApplicationContext(), "Login Failed...", Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),""+error.toString(),Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(stringRequest);



    }

       // http://localhost/webapp/login.php?login_name=pawar&login_pass=1233445
    }


