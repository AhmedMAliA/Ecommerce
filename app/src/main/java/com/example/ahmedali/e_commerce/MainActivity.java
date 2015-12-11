package com.example.ahmedali.e_commerce;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    Button sign;
    EditText email;
    EditText pass;
    Button log;
    TextView forget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sign = (Button) findViewById(R.id.signup);
        email= (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        log = (Button) findViewById(R.id.log);
        forget= (TextView) findViewById(R.id.forget);


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logDB obj=new logDB(MainActivity.this);
                boolean bool=obj.get_user(email.getText().toString(),pass.getText().toString());

                if(!email.getText().toString().isEmpty() && !pass.getText().toString().isEmpty()) {
                        if (bool==false) {
                            Toast.makeText(MainActivity.this, "Wrong Entery :( please enter a valid Email and password", Toast.LENGTH_LONG).show();
                        } else {
                           // Toast.makeText(MainActivity.this, "user is found", Toast.LENGTH_LONG).show();

                            Intent i=new Intent(MainActivity.this,products.class);
                            startActivity(i);


                        }
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Please enter your email and the password",Toast.LENGTH_LONG).show();
                }

            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(MainActivity.this,sign_up.class);
                startActivity(i);
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent I_sign =new Intent(MainActivity.this,sign_up.class);
                startActivity(I_sign);

            }
        });
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(MainActivity.this,forget_pass.class);
                startActivity(ii);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
