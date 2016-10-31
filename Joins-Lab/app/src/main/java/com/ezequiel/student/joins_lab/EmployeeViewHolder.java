package com.ezequiel.student.joins_lab;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by student on 10/28/16.
 */
public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    public TextView mNames;


    public EmployeeViewHolder(View itemView) {
        super(itemView);

        mNames = (TextView) itemView.findViewById(android.R.id.text1);
    }
}
