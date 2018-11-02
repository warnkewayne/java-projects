package com.androidexample.thecroutongame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    public String bundleCrouton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        bundleCrouton = b.getString("crouton");
    }

    public void createUser(View v){

        String username = ((EditText)findViewById(R.id.new_user)).getText().toString();
        String password = ((EditText)findViewById(R.id.newPW)).getText().toString();
        String crouton = bundleCrouton;

        if (username.length() < 5){
            Toast.makeText(this, "Username is not long enough", Toast.LENGTH_SHORT).show();
            return;
        }

        if(password.length() < 8){
            Toast.makeText(this, "Password is not long enough", Toast.LENGTH_SHORT).show();
            return;
        }

        DBHelper db = new DBHelper(this);
        db.insertUser(username, password, crouton);

        finish();
    }

    public void cancelRegistration (View v){
        finish();
    }
}
