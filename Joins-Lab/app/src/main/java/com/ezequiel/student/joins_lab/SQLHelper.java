package com.ezequiel.student.joins_lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 10/28/16.
 */
public class SQLHelper extends SQLiteOpenHelper {

    public static final String EMPLOYEE_TABLE_NAME = "employee";
    public static final String COL_SSN = "ssn";
    public static final String COL_FIRST_NAME = "first_name";
    public static final String COL_LAST_NAME = "last_name";
    public static final String COL_YEAR_OF_BIRTH = "year_of_birth";
    public static final String COL_CITY = "city";

    public static final String JOB_TABLE_NAME = "job";
    public static final String COL_COMPANY = "company";
    public static final String COL_SALARY = "salary";
    public static final String COL_EXPERIENCE = "experience";

    private SQLHelper(Context context){
        super(context, "db", null, 1);
    }

    private static SQLHelper mInstance;

    public static SQLHelper getInstance(Context context){
        if (mInstance == null){
            mInstance = new SQLHelper(context.getApplicationContext());
        }
        return mInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ENTRIES_EMPLOYEE);
        db.execSQL(CREATE_ENTRIES_JOB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_ENTRIES_EMPLOYEE);
        db.execSQL(DELETE_ENTRIES_JOB);
        onCreate(db);
    }

    public static final String CREATE_ENTRIES_EMPLOYEE = "CREATE TABLE " +
            EMPLOYEE_TABLE_NAME + " (" +
            COL_SSN + " INTEGER PRIMARY KEY," +
            COL_FIRST_NAME + " TEXT," +
            COL_LAST_NAME + " TEXT," +
            COL_YEAR_OF_BIRTH + " INT," +
            COL_CITY + " TEXT)";

    public static final String CREATE_ENTRIES_JOB = "CREATE TABLE " +
            JOB_TABLE_NAME + " (" +
            COL_SSN + " INTEGER PRIMARY KEY," +
            COL_COMPANY + " TEXT," +
            COL_SALARY + " INT," +
            COL_EXPERIENCE + " INT)";

    private static final String DELETE_ENTRIES_EMPLOYEE = "DROP TABLE IF EXISTS " +
            EMPLOYEE_TABLE_NAME;
    private static final String DELETE_ENTRIES_JOB = "DROP TABLE IF EXISTS " +
            JOB_TABLE_NAME;

    public void insertRowEmp(Employee employee){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_SSN, employee.getSSN());
        values.put(COL_FIRST_NAME, employee.getFirstName());
        values.put(COL_LAST_NAME, employee.getLastName());
        values.put(COL_YEAR_OF_BIRTH, employee.getYearOfBirth());
        values.put(COL_CITY, employee.getCity());
        db.insertOrThrow(EMPLOYEE_TABLE_NAME, null, values);
    }

    public void insertRowJob(Job job){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_SSN, job.getEmpSSN());
        values.put(COL_COMPANY, job.getCompany());
        values.put(COL_SALARY, job.getSalary());
        values.put(COL_EXPERIENCE, job.getExperience());
        db.insertOrThrow(JOB_TABLE_NAME, null, values);
    }

    public List<String> getEmpFromMacys(){
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT " + COL_FIRST_NAME + ", " + COL_LAST_NAME +
                " FROM " + EMPLOYEE_TABLE_NAME + " JOIN " + JOB_TABLE_NAME +
                " ON " + EMPLOYEE_TABLE_NAME+"."+COL_SSN + " = " + JOB_TABLE_NAME+"."+COL_SSN +
                " WHERE " + COL_COMPANY + " = 'Macys'";

        Cursor cursor = db.rawQuery(query, null);

        List<String> names = new ArrayList<>();

        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                names.add(cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))+" "+
                        cursor.getString(cursor.getColumnIndex(COL_LAST_NAME)));
                cursor.moveToNext();
            }
        }
        cursor.close();
        return names;
    }

    public List<String> getEmpFromBoston(){
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT " + COL_FIRST_NAME + ", " + COL_LAST_NAME +
                " FROM " + EMPLOYEE_TABLE_NAME + " JOIN " + JOB_TABLE_NAME +
                " ON " + EMPLOYEE_TABLE_NAME+"."+COL_SSN + " = " + JOB_TABLE_NAME+"."+COL_SSN +
                " WHERE " + COL_CITY + " = 'Boston'";

        Cursor cursor = db.rawQuery(query, null);

        List<String> names = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                names.add(cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_LAST_NAME)));
                cursor.moveToNext();
            }
        }
        cursor.close();
        return names;
    }

    public List<String> getHighSalary(){
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT " + COL_FIRST_NAME + ", " + COL_LAST_NAME +
                " FROM " + EMPLOYEE_TABLE_NAME + " JOIN " + JOB_TABLE_NAME +
                " ON " + EMPLOYEE_TABLE_NAME+"."+COL_SSN + " = " + JOB_TABLE_NAME+"."+COL_SSN +
                " ORDER BY " + COL_SALARY + " ";

        Cursor cursor = db.rawQuery(query, null);

        List<String> names = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                names.add(cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_LAST_NAME)));
                cursor.moveToNext();
            }
        }
        cursor.close();
        return names;
    }
}
