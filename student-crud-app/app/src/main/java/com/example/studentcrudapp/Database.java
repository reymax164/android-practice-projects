package com.example.studentcrudapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {


    private static final String studentsTable = "Student";
    private static final String studentNoColumn = "studentNo";
    private static final String lastNameColumn = "lastName";
    private static final String firstNameColumn = "firstName";
    private static final String middleNameColumn = "middleName";
    private static final String ageColumn = "age";
    private static final String isRegularColumn = "isRegular";

    public Database(@Nullable Context context) {
        super(context, "student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + studentsTable + " (" + studentNoColumn + " INTEGER PRIMARY KEY, " + lastNameColumn + " TEXT, " + firstNameColumn + " TEXT, " + middleNameColumn + " TEXT, " + ageColumn + " INT, " + isRegularColumn + " BOOL)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean register(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(studentNoColumn, student.getId());
        cv.put(lastNameColumn, student.getLastName());
        cv.put(firstNameColumn, student.getFirstName());
        cv.put(middleNameColumn, student.getMiddleName());
        cv.put(ageColumn, student.getAge());
        cv.put(isRegularColumn, student.isRegular());

        long insert = db.insert(studentsTable, null, cv);
        return insert != -1;
    }

    public void deleteStudent(int studentId) {
        SQLiteDatabase db = this.getWritableDatabase();
        String deleteStatement = "DELETE FROM " + studentsTable + " WHERE " + studentId + "=" + studentNoColumn;
        db.execSQL(deleteStatement);
        db.close();
    }

    public boolean updateStudentPartial(int studentNo, String lastName, String firstName, String middleName, String ageStr, boolean isRegular) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        if (lastName != null && !lastName.trim().isEmpty()) {
            values.put(lastNameColumn, lastName);
        }

        if (firstName != null && !firstName.trim().isEmpty()) {
            values.put(firstNameColumn, firstName);
        }

        if (middleName != null && !middleName.trim().isEmpty()) {
            values.put(middleNameColumn, middleName);
        }

        if (ageStr != null && !ageStr.trim().isEmpty()) {
            values.put(ageColumn, Integer.parseInt(ageStr));
        }

        int regularity = isRegular ? 1 : 0;
        values.put(isRegularColumn, regularity);

        if (values.size() == 0) {
            db.close();
            return false;
        }

        int rowsAffected = db.update(studentsTable, values, studentNoColumn + "=?", new String[]{String.valueOf(studentNo)});
        db.close();

        return rowsAffected > 0;
    }

    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();

        String selectStatement = "SELECT * FROM " + studentsTable;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectStatement, null);

        if(cursor.moveToFirst()) {
            do {
                int studentID = cursor.getInt(0);
                String lastName = cursor.getString(1);
                String firstName = cursor.getString(2);
                String middleName = cursor.getString(3);
                int age = cursor.getInt(4);
                boolean isRegular = cursor.getInt(5) == 1;

                Student student = new Student(studentID, lastName, firstName, middleName, age, isRegular);
                studentList.add(student);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return studentList;
    }
}
