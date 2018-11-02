package com.androidexample.thecroutongame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public String bundleCrouton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        bundleCrouton = b.getString("crouton");

        //Toast.makeText(this, bundleCrouton, Toast.LENGTH_LONG).show();
    }

    public void goToRegisterScreen(View v){
        Intent intent = new Intent(this, RegisterActivity.class);

        intent.putExtra("crouton", bundleCrouton);
        startActivity(intent);
    }

    public void login(View v){
        int userIndex = -1;


        String username = ((EditText)findViewById(R.id.unEditText)).getText().toString();
        String password = ((EditText)findViewById(R.id.pwEditText)).getText().toString();
        String crouton = bundleCrouton;

        //check if its valid
        DBHelper db = new DBHelper(this);

        User user = db.getUserByUsername(username);

        if (user == null) {
            Toast.makeText(this, "Unknown Username", Toast.LENGTH_SHORT).show();
            return;
        }

        if (user.password.equals(password) == false) {
            Toast.makeText(this, "Incorrect password", Toast.LENGTH_SHORT).show();
            return;
        }

//        for (int i = 0; i < usernames.length; i++) {
//            if (usernames[i].equals(username)){
//                userIndex = i;
//                break;
//            }
//            if (i + 1 == usernames.length) {
//                Toast.makeText(this, "Unknown Username", Toast.LENGTH_SHORT).show();
//                return;
//            }
//        }

        //TODO: Make class
       // CurrentUser.name = username;
       // CurrentUser.id = user.id;

        Intent homeIntent = new Intent(this, HomeActivity.class);
        homeIntent.putExtra("crouton", bundleCrouton);
        startActivity(homeIntent);



    }

}
