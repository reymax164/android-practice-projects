package com.example.mse_app.basicinputs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mse_app.R;

public class UserInputActivity extends AppCompatActivity {
    // declarations
    Button enterBtn;
    EditText lastNameEditText, firstNameEditText, ageEditText, genderEditText;
    TextView fullNameTextView, ageTextView, genderTextView;

    // variables
    String fullName, age, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_input);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.setTitle("User Input");

        // Button and EditText
        enterBtn = findViewById(R.id.enterBtn);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        genderEditText = findViewById(R.id.genderEditText);

        // TextView
        fullNameTextView = findViewById(R.id.fullNameTextView);
        ageTextView = findViewById(R.id.ageTextView);
        genderTextView = findViewById(R.id.genderTextView);
    }

    public void enterOnClick(View v) {
        fullName = "Full Name: " + firstNameEditText.getText() + " " + lastNameEditText.getText();
        age = "Age: " + ageEditText.getText().toString();
        gender = "Gender: " + genderEditText.getText().toString();

        fullNameTextView.setText(fullName);
        ageTextView.setText(age);
        genderTextView.setText(gender);
    }
}