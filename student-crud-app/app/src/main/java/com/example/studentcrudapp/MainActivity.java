package com.example.studentcrudapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText et_studentNumber, et_lastName, et_firstName, et_middleName, et_age;
    Switch regularSwitch;
    Button btn_register, btn_refresh, btn_update, btn_delete;
    ListView lv_studentList;
    Database db;
    StudentAdapter adapter;

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
        btn_refresh = findViewById(R.id.btn_search);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);

        lv_studentList = findViewById(R.id.studentListView);

        db = new Database(MainActivity.this);
        getStudentList();

        // button click events
        btn_register.setOnClickListener(v -> {
            Student student;
            try {
                 student = new Student(
                        Integer.parseInt(et_studentNumber.getText().toString()),
                        et_lastName.getText().toString(),
                        et_firstName.getText().toString(),
                        et_middleName.getText().toString(),
                        Integer.parseInt(et_age.getText().toString()),
                        regularSwitch.isChecked());

                // System.out.println(student.toString());
            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                // student = new Student(-1, "error", "error", "error", 0, false);
                return;
            }

            boolean success = db.register(student);
            if (success) Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();

            getStudentList();
        });


        btn_refresh.setOnClickListener(v -> {
            Toast.makeText(this, "Retrieving Students", Toast.LENGTH_SHORT).show();
            getStudentList();
        });

        btn_update.setOnClickListener(v -> {
            Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show();
        });

        btn_delete.setOnClickListener(v -> {
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
        });
    }

    private void getStudentList() {
        adapter = new StudentAdapter(MainActivity.this, db.getStudents());
        lv_studentList.setAdapter(adapter);
    }
}