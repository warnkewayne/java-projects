package com.androidexample.thecroutongame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notACrouton(View v){
        Toast.makeText(this ,"That is not a crouton.", Toast.LENGTH_SHORT).show();
    }

    public void croutonClick(View v){
        Intent intent = new Intent(this, LoginActivity.class);

        switch (v.getId()) {
            case R.id.Crouton0:
                //TODO: SEND EXTRA TO NEXT INTENT
                intent.putExtra("crouton", "crouton0");
                break;
            case R.id.Crouton1:
                intent.putExtra("crouton", "crouton1");
                break;
            case R.id.Crouton2:
                intent.putExtra("crouton", "crouton2");
                break;
        }

        startActivity(intent);
    }

}
