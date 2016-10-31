package com.ezequiel.student.joins_lab;

/**
 * Created by student on 10/28/16.
 */
public class Job {
    private int mEmpSSN;
    private String mCompany;
    private int mSalary;
    private int mExperience;

    public Job(int ssn, String company, int salary, int experience) {
        mEmpSSN = ssn;
        mCompany = company;
        mSalary = salary;
        mExperience = experience;
    }

    public int getEmpSSN() {
        return mEmpSSN;
    }

    public String getCompany() {
        return mCompany;
    }

    public int getSalary() {
        return mSalary;
    }

    public int getExperience() {
        return mExperience;
    }
}
