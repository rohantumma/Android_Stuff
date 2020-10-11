package com.example.administrator.studentattendance;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class TEBDivActivity extends AppCompatActivity {

    EditText et_fname,et_mname,et_lname,et_rollno,et_emailid;
    String fname,mname,lname,rollno,emailid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tebdiv);
        Button b1 = (Button) findViewById(R.id.bcancel);
        et_fname = (EditText) findViewById(R.id.etfname);
        et_mname = (EditText) findViewById(R.id.etmname);
        et_lname = (EditText) findViewById(R.id.etlname);
        et_rollno = (EditText) findViewById(R.id.etrno);
        et_emailid = (EditText) findViewById(R.id.etemail);
    }

    public void movetoStudent(View view)
    {
        final Context context=this;
        Intent intent=new Intent(context,StudentActivity.class);
        startActivity(intent);

    }
    public void addRecordtoDB(View view)
    {
        fname=et_fname.getText().toString();
        mname=et_mname.getText().toString();
        lname=et_lname.getText().toString();
        rollno=et_rollno.getText().toString();
        emailid=et_emailid.getText().toString();

        String method = "inserttebStudent";
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        // http://localhost/webapp/insertbeaStudent.php?rno=1&fname=sai&mname=ravi&lname=patil&email=saipatil@gmail.com
        String url = "http://192.168.43.63/webapp/inserttebStudent.php?rollno="+rollno+"&fname="+fname+"&mname="+mname+"&lname="+lname+"&emailid="+emailid;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"Data inserted sucessfully...",Toast.LENGTH_LONG).show();

                et_fname.setText("");
                et_mname.setText("");
                et_lname.setText("");
                et_rollno.setText("");
                et_emailid.setText("");

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
