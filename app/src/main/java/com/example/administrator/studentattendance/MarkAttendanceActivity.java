package com.example.administrator.studentattendance;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
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

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MarkAttendanceActivity extends AppCompatActivity implements  DatePickerDialog.OnDateSetListener {


    LinearLayout linearMain;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance);


        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        Spinner spinner1 = findViewById(R.id.spinner_class);
        Spinner spinner2 = findViewById(R.id.spinner_subject);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Class, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.Subject, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position)
                {
                    case 0:

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
                                        //mTextView.append("RollNo:"+rollNo+"\n"+"Name:"+firstName +" " + MiddleName +" " +lastName+"\nEmailID:"+EmailId );
                                        //mTextView.append("\n-----------------------------------------------------------------------");
                                       // mTextView.append("\n\n");

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

                        //mTextView.setText("");
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
                                        //mTextView.append("RollNo:"+rollNo+"\n"+"Name:"+firstName +" " + MiddleName +" " +lastName+"\nEmailID:"+EmailId );
                                        //mTextView.append("\n-----------------------------------------------------------------------");
                                        //mTextView.append("\n\n");
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
                        //mTextView.setText("");
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
                                       // mTextView.append("RollNo:"+rollNo+"\n"+"Name:"+firstName +" " + MiddleName +" " +lastName+"\nEmailID:"+EmailId );
                                        // mTextView.append("\n-----------------------------------------------------------------------");
                                       // mTextView.append("\n\n");
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

                        //mTextView.setText("");
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
                                       // mTextView.append("RollNo:"+rollNo+"\n"+"Name:"+firstName +" " + MiddleName +" " +lastName+"\nEmailID:"+EmailId );
                                        // mTextView.append("\n-----------------------------------------------------------------------");
                                       // mTextView.append("\n\n");
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

                       // mTextView.setText("");
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
                                       // mTextView.append("RollNo:"+rollNo+"\n"+"Name:"+firstName +" " + MiddleName +" " +lastName+"\nEmailID:"+EmailId );
                                        // mTextView.append("\n-----------------------------------------------------------------------");
                                      //  mTextView.append("\n\n");
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

                        //mTextView.setText("");
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
                                       // mTextView.append("RollNo:"+rollNo+"\n"+"Name:"+firstName +" " + MiddleName +" " +lastName+"\nEmailID:"+EmailId );
                                        // mTextView.append("\n-----------------------------------------------------------------------");
                                      //  mTextView.append("\n\n");
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

                       // mTextView.setText("");
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
                                       // mTextView.append("RollNo:"+rollNo+"\n"+"Name:"+firstName +" " + MiddleName +" " +lastName+"\nEmailID:"+EmailId );
                                        //mTextView.append("\n-----------------------------------------------------------------------");
                                      //  mTextView.append("\n\n");
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
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Button button = (Button) findViewById(R.id.btn_date);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });


        linearMain = (LinearLayout) findViewById(R.id.linear_main);
        ArrayList<String> a1 = new ArrayList<String>();

        a1.add("apple");
        a1.add("banana");
        a1.add("mango");
        a1.add("Orange");

        for (int i = 0; i < a1.size(); i++) {
            checkBox = new CheckBox(this);
            checkBox.setId(i);
            checkBox.setText(a1.get(i));
            checkBox.setOnClickListener(getOnClickDoSomething(checkBox));
            linearMain.addView(checkBox);
        }
    }


    View.OnClickListener getOnClickDoSomething(final Button button) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ON_CLICK", "CheckBox ID: " + button.getId() + "Text: " + button.getText().toString());
            }
        };
    }


    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        TextView textView = (TextView) findViewById(R.id.tvdate);
        textView.setText(currentDateString);

    }
}


