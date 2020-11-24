package com.example.verticalvideocropper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class NewProjectActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Intent fileIntent;
    private Button fileSelectButton;
    private String filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_project);

        Spinner aspectRatioSpinner = findViewById(R.id.aspect_ratio_spinner);
        Spinner resolutionSpinner = findViewById(R.id.resolution_spinner);

        // Got help with this part of the code from a YouTube tutorial: https://www.youtube.com/watch?v=on_OrrX7Nw4
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.aspect_ratio_values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aspectRatioSpinner.setAdapter(adapter);
        aspectRatioSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.resolution_values, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resolutionSpinner.setAdapter(adapter2);
        resolutionSpinner.setOnItemSelectedListener(this);

        fileSelectButton = (Button) findViewById(R.id.project_select_files_button);
        filePath = "";

        fileSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                fileIntent.setType("*/*");
                startActivityForResult(fileIntent, 10);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 10:
                if (requestCode == RESULT_OK) {
                    String path = data.getData().getPath();
                    filePath = path;
                }
                break;
        }
    }
}