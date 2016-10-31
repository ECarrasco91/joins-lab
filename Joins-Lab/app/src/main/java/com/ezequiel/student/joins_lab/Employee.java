package com.ezequiel.student.joins_lab;

/**
 * Created by student on 10/28/16.
 */
public class Employee {
    private int mSSN;
    private String mFirstName;
    private String mLastName;
    private int mYearOfBirth;
    private String mCity;

    public Employee(int ssn, String firstname, String lastName, int yearofbirth, String city) {
        mSSN = ssn;
        mFirstName = firstname;
        mLastName = lastName;
        mYearOfBirth = yearofbirth;
        mCity = city;
    }

    public int getSSN() {
        return mSSN;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public int getYearOfBirth() {
        return mYearOfBirth;
    }

    public String getCity() {
        return mCity;
    }
}
