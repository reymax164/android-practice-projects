package com.example.mse_app;

import static android.content.SharedPreferences.*;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SharedPreferencesActivity extends AppCompatActivity {
    TextView txt_center;
    EditText et_input;
    Button btn_save, btn_refresh;
    private static final String sharedPreferencesKey = "key";
    private static final String defaultValue = "No text found.";
    SharedPreferences sp;
    Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shared_preferences);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txt_center = findViewById(R.id.txt_center);
        et_input = findViewById(R.id.et_input);
        btn_save = findViewById(R.id.btn_save);
        btn_refresh = findViewById(R.id.btn_refresh);

        sp = getSharedPreferences(sharedPreferencesKey, MODE_PRIVATE);
        editor = sp.edit();

        // save button
        btn_save.setOnClickListener(v -> {
            if (!et_input.getText().toString().isEmpty()) {
                sp = getSharedPreferences(sharedPreferencesKey, MODE_PRIVATE);
                editor = sp.edit();
                editor.putString(sharedPreferencesKey, et_input.getText().toString());
                editor.commit();
                Toast.makeText(this, "Input Saved", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please input a text", Toast.LENGTH_SHORT).show();
            }
        });

        // refresh button
        btn_refresh.setOnClickListener(v -> {
            String text = sp.getString(sharedPreferencesKey, defaultValue);
            txt_center.setText(text);
        });
    }
}