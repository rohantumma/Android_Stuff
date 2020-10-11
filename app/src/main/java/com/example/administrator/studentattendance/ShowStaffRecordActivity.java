package com.example.administrator.studentattendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class ShowStaffRecordActivity extends AppCompatActivity {

    private TextView mTextView;

    String url = "http://192.168.43.63/webapp/retrievestaff.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_staff_record);

        mTextView = (TextView) findViewById(R.id.tv);

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
                        String firstName = student.getString("fname");
                        String MiddleName = student.getString("mname");
                        String lastName = student.getString("lname");
                        String EmailId = student.getString("emailid");

                        // Display the formatted json data in text view
                       mTextView.append("Name:"+firstName +" " + MiddleName +" " +lastName+"\nEmailID:"+EmailId );
                       mTextView.append("\n---------------------------------------------------------------");
                       mTextView.append("\n");
                       // Toast.makeText(getApplicationContext(), " " + firstName, Toast.LENGTH_LONG).show();
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }


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
}
