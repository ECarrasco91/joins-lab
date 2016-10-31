package com.ezequiel.student.joins_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public RecyclerView mRecyclerView;
    public EmployeeAdapter mAdapter;
    public Button mMacy, mBoston, mHiSal;
    public List<String> mNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recylerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));

        mMacy = (Button) findViewById(R.id.macys);
        mBoston = (Button) findViewById(R.id.boston);
        mHiSal = (Button) findViewById(R.id.highestsalary);

        mNames = new ArrayList<>();

        final SQLHelper sqlHelper = SQLHelper.getInstance(MainActivity.this);

        Employee employee = new Employee(123045678, "John", "Smith", 1973, "NY");
        Employee employee1 = new Employee(123045679, "David", "McWill", 1982, "Seattle");
        Employee employee2 = new Employee(123045680, "Katerina", "Wise", 1973, "Boston");
        Employee employee3 = new Employee(123045681, "Donald", "Lee", 1992, "London");
        Employee employee4 = new Employee(123045682, "Gary", "Henwood", 1987, "Las Vegas");
        Employee employee5 = new Employee(123045683, "Anthony", "Bright", 1963, "Seattle");
        Employee employee6 = new Employee(123045684, "William", "Newey", 1995, "Boston");
        Employee employee7 = new Employee(123045685, "Melony", "Smith", 1970, "Chicago");

        Job job = new Job(123045678, "Fuzz", 60, 1);
        Job job1 = new Job(123045679, "GA", 70, 2);
        Job job2 = new Job(123045680, "Little Place", 120, 5);
        Job job3 = new Job(123045681, "Macys", 78, 3);
        Job job4 = new Job(123045682, "New Life", 65, 1);
        Job job5 = new Job(123045683, "Believe", 158, 6);
        Job job6 = new Job(123045684, "Macys", 200, 8);
        Job job7 = new Job(123045685, "Stop", 299, 12);

        sqlHelper.insertRowEmp(employee);
        sqlHelper.insertRowEmp(employee1);
        sqlHelper.insertRowEmp(employee2);
        sqlHelper.insertRowEmp(employee3);
        sqlHelper.insertRowEmp(employee4);
        sqlHelper.insertRowEmp(employee5);
        sqlHelper.insertRowEmp(employee6);
        sqlHelper.insertRowEmp(employee7);

        sqlHelper.insertRowJob(job);
        sqlHelper.insertRowJob(job1);
        sqlHelper.insertRowJob(job2);
        sqlHelper.insertRowJob(job3);
        sqlHelper.insertRowJob(job4);
        sqlHelper.insertRowJob(job5);
        sqlHelper.insertRowJob(job6);
        sqlHelper.insertRowJob(job7);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.macys:
                        mNames = sqlHelper.getEmpFromMacys();
                        break;
                    case R.id.boston:
                        mNames = sqlHelper.getEmpFromBoston();
                        break;
                    case R.id.highestsalary:
                        mNames = sqlHelper.getHighSalary();
                        break;
                }
                mAdapter.replaceData(mNames);
            }
        };

        mMacy.setOnClickListener(onClickListener);
        mBoston.setOnClickListener(onClickListener);
        mHiSal.setOnClickListener(onClickListener);

        mRecyclerView.setAdapter(mAdapter);


    }
}
