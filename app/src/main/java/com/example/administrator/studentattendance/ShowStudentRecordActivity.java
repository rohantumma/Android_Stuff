package com.example.administrator.studentattendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowStudentRecordActivity extends AppCompatActivity  {

    private TextView mTextView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_student_record);

        mTextView = (TextView) findViewById(R.id.tv);
        final RequestQueue requestQueue = Volley.newRequestQueue(this);


        // Adding spinner
        Spinner spinner1=findViewById(R.id.spinner_class);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Class,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                switch (position)
                {
                    case 0:
                        mTextView.setText("");
                       String url = "http://192.168.43.63/webapp/retrievebea.php";

                        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {

                                try{
                                    // Loop through the array elements
                                    for(int i=0;i<response.length();i++){
                                        // Get current json object
                                        JSONObject student = response.getJSONObject(i);

                                        // Get the current student (json object) data
                                        Integer rollNo = student.getInt("rollno");
                                        String firstName = student.getString("fname");
                                        String MiddleName = student.getString("mname");
                                        String lastName = student.getString("lname");
                                        String EmailId = student.getString("emailid");

                                        // Display the formatted json data in text view
                                        mTextView.append("RollNo:"+rollNo+"\n"+"Name:"+firstName +" " + MiddleName +" " +lastName+"\nEmailID:"+EmailId );
                                        //mTextView.append("\n-----------------------------------------------------------------------");
                                        mTextView.append("\n\n");

                                    }
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }

                                //Toast.makeText(getApplicationContext(), " " + response, Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                VolleyLog.wtf(error.getMessage(), "utf-8");
                                Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_LONG).show();

                            }
                        });
                        requestQueue.add(jsonArrayRequest);
                        //String text=parent.getItemAtPosition(position).toString();
                        //Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();

                        break;

                    case 1:

                        mTextView.setText("");
                        String url1 = "http://192.168.43.63/webapp/retrievebeb.php";

                        JsonArrayRequest jsonArrayRequest1 = new JsonArrayRequest(Request.Method.GET, url1, null, new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {

                                try{
                                    // Loop through the array elements

                                    //Toast.makeText(getApplicationContext(),response.length(), Toast.LENGTH_LONG).show();
                                    for(int i=0;i<response.length();i++){
                                        // Get current json object
                                        JSONObject student = response.getJSONObject(i);

                                        // Get the current student (json object) data
                                        Integer rollNo = student.getInt("rollno");
                                        String firstName = student.getString("fname");
                                        String MiddleName = student.getString("mname");
                                        String lastName = student.getString("lname");
                                        String EmailId = student.getString("emailid");

                                        // Display the formatted json data in text view
                                        mTextView.append("RollNo:"+rollNo+"\n"+"Name:"+firstName +" " + MiddleName +" " +lastName+"\nEmailID:"+EmailId );
                                        //mTextView.append("\n-----------------------------------------------------------------------");
                                        mTextView.append("\n\n");
                                    }
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }

                                //Toast.makeText(getApplicationContext(), " " + response, Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                VolleyLog.wtf(error.getMessage(), "utf-8");
                                Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_LONG).show();

                            }
                        });
                        requestQueue.add(jsonArrayRequest1);
                       // String text1=parent.getItemAtPosition(position).toString();
                        //Toast.makeText(parent.getContext(),text1,Toast.LENGTH_SHORT).show();

                        break;

                    case 2:
                        mTextView.setText("");
                        String url2 = "http://192.168.43.63/webapp/retrievetea.php";

                        JsonArrayRequest jsonArrayRequest2 = new JsonArrayRequest(Request.Method.GET, url2, null, new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {

                                try{
                                    // Loop through the array elements

                                    //Toast.makeText(getApplicationContext(),response.length(), Toast.LENGTH_LONG).show();
                                    for(int i=0;i<response.length();i++){
                                        // Get current json object
                                        JSONObject student = response.getJSONObject(i);

                                        // Get the current student (json object) data
                                        Integer rollNo = student.getInt("rollno");
                                        String firstName = student.getString("fname");
                                        String MiddleName = student.getString("mname");
                                        String lastName = student.getString("lname");
                                        String EmailId = student.getString("emailid");

                                        // Display the formatted json data in text view
                                        mTextView.append("RollNo:"+rollNo+"\n"+"Name:"+firstName +" " + MiddleName +" " +lastName+"\nEmailID:"+EmailId );
                                       // mTextView.append("\n-----------------------------------------------------------------------");
                                        mTextView.append("\n\n");
                                    }
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }

                                //Toast.makeText(getApplicationContext(), " " + response, Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                VolleyLog.wtf(error.getMessage(), "utf-8");
                                Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_LONG).show();

                            }
                        });
                        requestQueue.add(jsonArrayRequest2);
                       // String text2=parent.getItemAtPosition(position).toString();
                       // Toast.makeText(parent.getContext(),text2,Toast.LENGTH_SHORT).show();


                        break;

                    case 3:

                        mTextView.setText("");
                        String url3 = "http://192.168.43.63/webapp/retrieveteb.php";

                        JsonArrayRequest jsonArrayRequest3 = new JsonArrayRequest(Request.Method.GET, url3, null, new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {

                                try{
                                    // Loop through the array elements

                                    //Toast.makeText(getApplicationContext(),response.length(), Toast.LENGTH_LONG).show();
                                    for(int i=0;i<response.length();i++){
                                        // Get current json object
                                        JSONObject student = response.getJSONObject(i);

                                        // Get the current student (json object) data
                                        Integer rollNo = student.getInt("rollno");
                                        String firstName = student.getString("fname");
                                        String MiddleName = student.getString("mname");
                                        String lastName = student.getString("lname");
                                        String EmailId = student.getString("emailid");

                                        // Display the formatted json data in text view
                                        mTextView.append("RollNo:"+rollNo+"\n"+"Name:"+firstName +" " + MiddleName +" " +lastName+"\nEmailID:"+EmailId );
                                       // mTextView.append("\n-----------------------------------------------------------------------");
                                        mTextView.append("\n\n");
                                    }
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }

                                //Toast.makeText(getApplicationContext(), " " + response, Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                VolleyLog.wtf(error.getMessage(), "utf-8");
                                Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_LONG).show();

                            }
                        });
                        requestQueue.add(jsonArrayRequest3);
                       // String text3=parent.getItemAtPosition(position).toString();
                       // Toast.makeText(parent.getContext(),text3,Toast.LENGTH_SHORT).show();


                        break;

                    case 4:

                        mTextView.setText("");
                        String url4 = "http://192.168.43.63/webapp/retrievesea.php";

                        JsonArrayRequest jsonArrayRequest4 = new JsonArrayRequest(Request.Method.GET, url4, null, new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {

                                try{
                                    // Loop through the array elements

                                    //Toast.makeText(getApplicationContext(),response.length(), Toast.LENGTH_LONG).show();
                                    for(int i=0;i<response.length();i++){
                                        // Get current json object
                                        JSONObject student = response.getJSONObject(i);

                                        // Get the current student (json object) data
                                        Integer rollNo = student.getInt("rollno");
                                        String firstName = student.getString("fname");
                                        String MiddleName = student.getString("mname");
                                        String lastName = student.getString("lname");
                                        String EmailId = student.getString("emailid");

                                        // Display the formatted json data in text view
                                        mTextView.append("RollNo:"+rollNo+"\n"+"Name:"+firstName +" " + MiddleName +" " +lastName+"\nEmailID:"+EmailId );
                                       // mTextView.append("\n-----------------------------------------------------------------------");
                                        mTextView.append("\n\n");
                                    }
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }

                                //Toast.makeText(getApplicationContext(), " " + response, Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                VolleyLog.wtf(error.getMessage(), "utf-8");
                                Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_LONG).show();

                            }
                        });
                        requestQueue.add(jsonArrayRequest4);
                        //String text4=parent.getItemAtPosition(position).toString();
                       // Toast.makeText(parent.getContext(),text4,Toast.LENGTH_SHORT).show();


                        break;

                    case 5:

                        mTextView.setText("");
                        String url5 = "http://192.168.43.63/webapp/retrieveseb.php";

                        JsonArrayRequest jsonArrayRequest5 = new JsonArrayRequest(Request.Method.GET, url5, null, new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {

                                try{
                                    // Loop through the array elements

                                    //Toast.makeText(getApplicationContext(),response.length(), Toast.LENGTH_LONG).show();
                                    for(int i=0;i<response.length();i++){
                                        // Get current json object
                                        JSONObject student = response.getJSONObject(i);

                                        // Get the current student (json object) data
                                        Integer rollNo = student.getInt("rollno");
                                        String firstName = student.getString("fname");
                                        String MiddleName = student.getString("mname");
                                        String lastName = student.getString("lname");
                                        String EmailId = student.getString("emailid");

                                        // Display the formatted json data in text view
                                        mTextView.append("RollNo:"+rollNo+"\n"+"Name:"+firstName +" " + MiddleName +" " +lastName+"\nEmailID:"+EmailId );
                                       // mTextView.append("\n-----------------------------------------------------------------------");
                                        mTextView.append("\n\n");
                                    }
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }

                                //Toast.makeText(getApplicationContext(), " " + response, Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                VolleyLog.wtf(error.getMessage(), "utf-8");
                                Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_LONG).show();

                            }
                        });
                        requestQueue.add(jsonArrayRequest5);
                       // String text5=parent.getItemAtPosition(position).toString();
                       // Toast.makeText(parent.getContext(),text5,Toast.LENGTH_SHORT).show();


                        break;

                    case 6:

                        mTextView.setText("");
                        String url6 = "http://192.168.43.63/webapp/retrievebeb.php";

                        JsonArrayRequest jsonArrayRequest6 = new JsonArrayRequest(Request.Method.GET, url6, null, new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {

                                try{
                                    // Loop through the array elements

                                    //Toast.makeText(getApplicationContext(),response.length(), Toast.LENGTH_LONG).show();
                                    for(int i=0;i<response.length();i++){
                                        // Get current json object
                                        JSONObject student = response.getJSONObject(i);

                                        // Get the current student (json object) data
                                        Integer rollNo = student.getInt("rollno");
                                        String firstName = student.getString("fname");
                                        String MiddleName = student.getString("mname");
                                        String lastName = student.getString("lname");
                                        String EmailId = student.getString("emailid");

                                        // Display the formatted json data in text view
                                        mTextView.append("RollNo:"+rollNo+"\n"+"Name:"+firstName +" " + MiddleName +" " +lastName+"\nEmailID:"+EmailId );
                                        //mTextView.append("\n-----------------------------------------------------------------------");
                                        mTextView.append("\n\n");
                                    }
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }

                                //Toast.makeText(getApplicationContext(), " " + response, Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                VolleyLog.wtf(error.getMessage(), "utf-8");
                                Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_LONG).show();

                            }
                        });
                        requestQueue.add(jsonArrayRequest6);
                       // String text6=parent.getItemAtPosition(position).toString();
                       // Toast.makeText(parent.getContext(),text6,Toast.LENGTH_SHORT).show();


                        break;

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /*@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        if (text.equals("BEA"))
        {
            String url = "http://192.168.42.62/webapp/retrievebea.php";
            final RequestQueue requestQueue = Volley.newRequestQueue(this);
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    try{
                        // Loop through the array elements
                        for(int i=0;i<response.length();i++){
                            // Get current json object
                            JSONObject student = response.getJSONObject(i);

                            // Get the current student (json object) data
                            Integer rollNo = student.getInt("rollno");
                            String firstName = student.getString("fname");
                            String MiddleName = student.getString("mname");
                            String lastName = student.getString("lname");
                            String EmailId = student.getString("emailid");

                            // Display the formatted json data in text view
                            mTextView.append("RollNo:"+rollNo+"\n"+"Name:"+firstName +" " + MiddleName +" " +lastName+"\nEmailID:"+EmailId );
                            mTextView.append("\n-----------------------------------------------------------------------");
                            mTextView.append("\n");
                        }
                    }catch (JSONException e){
                        e.printStackTrace();
                    }

                    //Toast.makeText(getApplicationContext(), " " + response, Toast.LENGTH_LONG).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.wtf(error.getMessage(), "utf-8");
                    Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_LONG).show();

                }
            });
            requestQueue.add(jsonArrayRequest);



        }
        //Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/
}
