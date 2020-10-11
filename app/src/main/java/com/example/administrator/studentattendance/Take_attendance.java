package com.example.administrator.studentattendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.io.BufferedReader;

public class Take_attendance extends AppCompatActivity {



    RelativeLayout rl1,rl2;
    ScrollView sv;
    String[] att;
    String atl=null,sms2;
    CheckBox[] b;
    int sum=30;
    Button button;
    String[] results={};
    String[] results1={};
    String[] slist={"Canada", "Mexico", "USA","Canada", "Mexico", "USA"};
    String name="",mobileno="";//,password="";
    BufferedReader reader=null;
    String line="";
    int cnt=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance);
      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        rl1=(RelativeLayout) findViewById(R.id.scroll1);
        sv=new ScrollView(scrollbar.this);
        rl2=new RelativeLayout(scrollbar.this);
        b=new CheckBox[20];
        button= new Button(this);
        for(int i=1;i<=15;i++)
        {
            b[i]=new CheckBox(this);
            RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(
                    (int) AbsListView.LayoutParams.WRAP_CONTENT,(int) AbsListView.LayoutParams.WRAP_CONTENT);
            params.leftMargin=10;
            params.topMargin=sum;
            params.width=450;
            b[i].setText(" " + i + "   Dnyaneshwar          ");
            b[i].setLayoutParams(params);

            rl2.addView(b[i]);
            sum=sum+100;
            b[i].setOnClickListener(getOnClickDoSomething(b[i]));

        }
        RelativeLayout.LayoutParams params1=new RelativeLayout.LayoutParams(
                (int) AbsListView.LayoutParams.WRAP_CONTENT,(int) AbsListView.LayoutParams.WRAP_CONTENT);
        params1.leftMargin=10;
        params1.topMargin=sum;
        params1.width=450;
        button.setText("Submit ");
        button.setLayoutParams(params1);

        rl2.addView(button);
        sum=sum+100;



        sv.addView(rl2);
        rl1.addView(sv);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(scrollbar.this, "button click", Toast.LENGTH_SHORT).show();
            }
        });
        //button.hasOnClickListeners(new View)
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dash, menu);
        return true;
    }

    private View.OnClickListener getOnClickDoSomething(final Button button) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "" + button.getId() + " :" + button.getText(), Toast.LENGTH_LONG).show();


            }
        };
}
}
