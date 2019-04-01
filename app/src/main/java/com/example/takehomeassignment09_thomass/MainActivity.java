package com.example.takehomeassignment09_thomass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show();
    }

    public void Submit (View view){
        Intent intent = new Intent (this, SecondActivity.class);
        startActivity(intent);
    }
}
