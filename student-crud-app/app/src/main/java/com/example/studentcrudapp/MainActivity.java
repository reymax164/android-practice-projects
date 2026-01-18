package com.example.studentcrudapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et_studentNumber, et_lastName, et_firstName, et_middleName, et_age;
    Switch regularSwitch;
    Button btn_register, btn_search, btn_update, btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        et_studentNumber = findViewById(R.id.et_studentNumber);
        et_lastName = findViewById(R.id.et_lastName);
        et_firstName = findViewById(R.id.et_firstName);
        et_middleName = findViewById(R.id.et_middleName);
        et_age = findViewById(R.id.et_age);
        regularSwitch = findViewById(R.id.regularSwitch);

        btn_register = findViewById(R.id.btn_register);
        btn_search = findViewById(R.id.btn_search);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);

        // button click events
        btn_register.setOnClickListener(v -> {
            Student student;
            try {
                 student = new Student(-1,
                        et_lastName.getText().toString(),
                        et_firstName.getText().toString(),
                        et_middleName.getText().toString(),
                        Integer.parseInt(et_age.getText().toString()),
                        regularSwitch.isChecked());

                // System.out.println(student.toString());
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                // student = new Student(-1, "error", "error", "error", 0, false);
                return;
            }

            Database database = new Database(MainActivity.this);
            boolean success = database.register(student);
        });


        btn_search.setOnClickListener(v -> {
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
        });

        btn_update.setOnClickListener(v -> {
            Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show();
        });

        btn_delete.setOnClickListener(v -> {
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
        });
    }
}