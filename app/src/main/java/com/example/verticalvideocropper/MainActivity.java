package com.example.verticalvideocropper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchNewProjectActivity(View view) {
        Intent intent = new Intent(this, NewProjectActivity.class);
        startActivity(intent);
    }
}