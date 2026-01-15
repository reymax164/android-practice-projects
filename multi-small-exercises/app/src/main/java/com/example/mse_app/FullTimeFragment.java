package com.example.mse_app;

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

public class FullTimeFragment extends Fragment {
    Button getTotalBtn;
    EditText nameEditText, salaryEditText, otPay, otHours;
    TextView nameTextView, salaryTextView;
    int otHoursInt = 0;
    double  salary, baseSalary, totalOverTimePay, otPayDouble = 0;

    public FullTimeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_full_time, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getTotalBtn  = view.findViewById(R.id.getTotalSalaryBtn);

        nameEditText = view.findViewById(R.id.ft_nameInput);
        salaryEditText = view.findViewById(R.id.salaryInput);

        nameTextView = view.findViewById(R.id.employeeName);
        salaryTextView = view.findViewById(R.id.employeeSalary);

        otHours = view.findViewById(R.id.otHourEditText);
        otPay = view.findViewById(R.id.otPayEditText);

        getTotalBtn.setOnClickListener(new GetTotalSalary());
    }

    private class GetTotalSalary implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            try {
                nameTextView.setText("Employee Name: " + nameEditText.getText().toString());
                baseSalary = Double.parseDouble((salaryEditText.getText().toString()));

                otPayDouble = Double.parseDouble((otPay.getText().toString()));
                otHoursInt = Integer.parseInt(otHours.getText().toString());

                totalOverTimePay = otHoursInt * otPayDouble;
                salary = baseSalary + totalOverTimePay;

                String total = "Salary: ₱" + salary;
                salaryTextView.setText(total);

            } catch (Exception e) {
                Toast.makeText(getContext(), "Incomplete Input", Toast.LENGTH_SHORT).show();
            }
        }
    }
}