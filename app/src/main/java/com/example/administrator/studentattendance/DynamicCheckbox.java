package com.example.administrator.studentattendance;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DynamicCheckbox extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    LinearLayout linearMain;
    CheckBox checkBox;
    Button button;
    int j = 0;
    //Integer size;
    String date;

    String sub;
    String date1;
    // String[] firstName, MiddleName, lastName, EmailId, rollNo;

    ArrayList<Integer> list = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_checkbox);

        button = (Button) findViewById(R.id.bsubmit);

        linearMain = (LinearLayout) findViewById(R.id.linear_main);
        final ArrayList<String> a1 = new ArrayList<String>();

        // a1.add("apple");
        //a1.add("banana");
        //a1.add("mango");
        //a1.add("Orange");


        //retrieve BE-B record
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url1 = "http://192.168.43.63/webapp/retrievebeb.php";

        JsonArrayRequest jsonArrayRequest1 = new JsonArrayRequest(Request.Method.GET, url1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {


                try {


                    for (int i = 0; i < response.length(); i++) {


                        JSONObject student = response.getJSONObject(i);

                        // Get the current student (json object) data
                        Integer rollNo = student.getInt("rollno");
                        String firstName = student.getString("fname");
                        String MiddleName = student.getString("mname");
                        String lastName = student.getString("lname");
                        String EmailId = student.getString("emailid");
                        //mn[i]=MiddleName;
                        //ln[i]=lastName;
                        //rl[i]=rollNo.toString();


                        String rno = rollNo.toString();


                        a1.add(rno + "    " + firstName + " " + MiddleName + " " + lastName);


                        checkBox = new CheckBox(getApplicationContext());
                        checkBox.setId(i);
                        checkBox.setText(a1.get(i));
                        checkBox.setOnClickListener(getOnClickDoSomething(checkBox));
                        linearMain.addView(checkBox);


                        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                                if (b) {
                                    list.add(compoundButton.getId());
                                    Toast.makeText(getApplicationContext(), "" + compoundButton.getId(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });


                        // Get current json object


                        // a1.add(firstName);

                        //size = response.length();

                        //Toast.makeText(getApplicationContext(),""+response.length(),Toast.LENGTH_LONG).show();
                        // Toast.makeText(getApplicationContext()," "+size, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.wtf(error.getMessage(), "utf-8");
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

            }
        });
        requestQueue.add(jsonArrayRequest1);










     /*  linearMain = (LinearLayout) findViewById(R.id.linear_main);
        ArrayList<String> a1 = new ArrayList<String>();

        a1.add("apple");
        a1.add("banana");
        a1.add("mango");
        a1.add("Orange");
        a1.add("Orange");
        a1.add("Orange");
        a1.add("Orange");
        a1.add("Orange");
        a1.add("Orange");
        a1.add("Orange");
        a1.add("Orange");
        a1.add("Orange");
        a1.add("Orange");
        a1.add("Orange");
        a1.add("Orange");

        for (int i=0;i<2;i++)
        {
            checkBox = new CheckBox(getApplicationContext());
            checkBox.setId(i);
           //checkBox.setText(a1.get(i));
            checkBox.setOnClickListener(getOnClickDoSomething(checkBox));
            linearMain.addView(checkBox);
        }*/

        Spinner spinner2 = findViewById(R.id.spinner_subject);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.Subject, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position) {
                    case 0:
                        String text = adapterView.getItemAtPosition(position).toString();
                        sub = text;
                        //  Toast.makeText(adapterView.getContext(),text,Toast.LENGTH_SHORT).show();
                        break;
                }

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


    }

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        //String myformat="yyyy/mm/dd";
        //SimpleDateFormat sdf = new SimpleDateFormat(myformat);
        String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime());
        // TextView textView = (TextView) findViewById(R.id.tvdate);
        Button button = (Button) findViewById(R.id.btn_date);
        button.setText(currentDateString);
        date1 = currentDateString;
        //button.setText(sdf.format(c.getTime()));

        //String date = currentDateString;
        // Toast.makeText(getApplicationContext(),""+date,Toast.LENGTH_LONG).show();

       /* String[] newdate = date.split(",");
        for (int i=0;i<newdate.length;i++)
        {
           newdate[i].trim();

        }*/
        //String newdate = date.replaceAll(",","").trim();
        //newdate=date.replaceAll("\\s+","").trim();
        // Toast.makeText(getApplicationContext(),""+newdate,Toast.LENGTH_LONG).show();

    }

    View.OnClickListener getOnClickDoSomething(final Button button) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ON_CLICK", "CheckBox ID: " + button.getId() + "Text: " + button.getText().toString());
            }
        };
    }


    public void takeAttendance(View view) {
        Toast.makeText(getApplicationContext(),"submit successfully",Toast.LENGTH_SHORT).show();
        Intent i1 = new Intent(DynamicCheckbox.this, StaffLoginActivity.class);
        startActivity(i1);


    }
}
