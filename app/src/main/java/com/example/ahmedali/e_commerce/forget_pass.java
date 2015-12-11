package com.example.ahmedali.e_commerce;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class forget_pass extends ActionBarActivity {


    EditText phone;
    Button get ;
    TextView pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
        phone= (EditText) findViewById(R.id.phone);
        get= (Button) findViewById(R.id.getpass);
        pass= (TextView) findViewById(R.id.yourpass);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logDB obj=new logDB(forget_pass.this);

                String s=obj.getpass(phone.getText().toString());
                pass.setText(s);


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_forget_pass, menu);
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
