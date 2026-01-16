package com.example.mse_app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class PayrollActivity extends AppCompatActivity {

    Button switchBtn;
    TextView payrollTitle;
    String fullTimeStr, partTimeStr;
    boolean inPartTime = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payroll);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fullTimeStr =  "Switch to Full Time";
        partTimeStr = "Switch to Part Time";

        payrollTitle = findViewById(R.id.payrollTitle);
        switchBtn = findViewById(R.id.switchBtn);

        switchBtn.setOnClickListener(v -> {
            if (!inPartTime) {
                payrollTitle.setText(R.string.part_time_title);
                switchBtn.setText(partTimeStr);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.payrollFragmentContainer, PartTimeFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();

                inPartTime = true;
            }
            else {
                payrollTitle.setText(R.string.full_time_title);
                switchBtn.setText(fullTimeStr);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.payrollFragmentContainer, FullTimeFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();

                inPartTime = false;
            }
        });


    }
}