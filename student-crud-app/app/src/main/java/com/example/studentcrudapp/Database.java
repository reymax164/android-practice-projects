package com.example.studentcrudapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {


    private static final String studentsTable = "Student";
    private static final String idColumn = "id";
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
        String createTableStatement = "CREATE TABLE " + studentsTable + " (" + idColumn + " INTEGER PRIMARY KEY AUTOINCREMENT, " + lastNameColumn + " TEXT, " + firstNameColumn + " TEXT, " + middleNameColumn + " TEXT, " + ageColumn + " INT, " + isRegularColumn + " BOOL)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean register(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(lastNameColumn, student.getLastName());
        cv.put(firstNameColumn, student.getFirstName());
        cv.put(middleNameColumn, student.getMiddleName());
        cv.put(ageColumn, student.getAge());
        cv.put(isRegularColumn, student.isRegular());

        long insert = db.insert(studentsTable, null, cv);
        return insert != -1;
    }
}
