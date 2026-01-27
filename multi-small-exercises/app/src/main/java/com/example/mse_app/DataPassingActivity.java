package com.example.mse_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DataPassingActivity extends AppCompatActivity {
    EditText etName, etAge;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data_passing);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        btnSubmit = findViewById(R.id.btnSubmitData);

        btnSubmit.setOnClickListener(v -> {
            try {
                String name = etName.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());

                Intent intent = new Intent(DataPassingActivity.this, DataReceivingActivity.class);
                intent.putExtra("USER_NAME", name);
                intent.putExtra("USER_AGE", age);

                startActivity(intent);

            } catch (Exception e) {
                Log.d("Exception Occurred", e.toString());
            }
        });

    }
}