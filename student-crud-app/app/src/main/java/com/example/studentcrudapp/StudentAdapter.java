package com.example.studentcrudapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {

    public StudentAdapter(Context context, List<Student> students) {
        super(context, 0, students);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Student student = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_student, parent, false);
        }

        TextView tvId = convertView.findViewById(R.id.tvId);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvAge = convertView.findViewById(R.id.tvAge);
        TextView tvIsRegular = convertView.findViewById(R.id.tvIsRegular);

        if (student != null) {
            tvId.setText("Student No: " + student.getId());

            String fullName = student.getLastName() + ", " + student.getFirstName() + " " + student.getMiddleName();
            tvName.setText(fullName);

            tvAge.setText("Age: " + student.getAge());

            if (student.isRegular()) {
                tvIsRegular.setText("Regular");
                tvIsRegular.setTextColor(Color.parseColor("#4CAF50")); // Green
            } else {
                tvIsRegular.setText("Irregular");
                tvIsRegular.setTextColor(Color.parseColor("#F44336")); // Red
            }
        }

        return convertView;
    }
}