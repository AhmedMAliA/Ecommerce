package com.example.ahmedali.e_commerce;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class sign_up extends ActionBarActivity {

    EditText email;
    EditText pass;
    EditText userNmae;
    EditText date;
    EditText phone;

    Button signMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email= (EditText) findViewById(R.id.email);
        pass= (EditText) findViewById(R.id.pass);
        userNmae= (EditText) findViewById(R.id.user_name);
        date= (EditText) findViewById(R.id.date);
        phone= (EditText) findViewById(R.id.phone);

        signMe= (Button) findViewById(R.id.signme);


        signMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logDB obj=new logDB(sign_up.this);
                obj.insert_sign(email.getText().toString(),pass.getText().toString(),phone.getText().toString(),date.getText().toString());

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
