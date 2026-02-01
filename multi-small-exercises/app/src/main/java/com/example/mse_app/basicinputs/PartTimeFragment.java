package com.example.mse_app.basicinputs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mse_app.R;

public class PartTimeFragment extends Fragment {

    EditText ptNameEditText, ratePerHoursEditText, hoursWorkedEditText;
    TextView ptName, ptWage;
    Button totalWageBtn;
    double totalWage = 0;

    public PartTimeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_part_time, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

            ptNameEditText = view.findViewById(R.id.pt_nameInput);
            ratePerHoursEditText = view.findViewById(R.id.RpHEditText);
            hoursWorkedEditText = view.findViewById(R.id.HrsWEditText);

            ptName = view.findViewById(R.id.employeeName);
            ptWage = view.findViewById(R.id.employeeWage);

            totalWageBtn = view.findViewById(R.id.getTotalWageBtn);

            totalWageBtn.setOnClickListener(new GetTotalWage());
    }

    private class GetTotalWage implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            try {
                double ratePerHour = Double.parseDouble(ratePerHoursEditText.getText().toString()),
                       hoursWorked = Double.parseDouble(hoursWorkedEditText.getText().toString());
                totalWage = ratePerHour * hoursWorked;

                String name = "Employee Name: " + ptNameEditText.getText().toString(),
                        wage = String.format("Wage: %.2f", totalWage);

                ptName.setText(name);
                ptWage.setText(wage);
            }
            catch (Exception e) {
                Toast.makeText(getContext(), "Incomplete Input", Toast.LENGTH_SHORT).show();
            }
        }
    }
}