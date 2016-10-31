package com.ezequiel.student.joins_lab;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by student on 10/28/16.
 */
public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {
    private List<String> mList;

    public EmployeeAdapter(List<String> list){
        mList = list;
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new EmployeeViewHolder(inflater.inflate(
                android.R.layout.simple_list_item_1, parent, false));
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, int position) {
        holder.mNames.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void replaceData(List<String> list){
        mList = list;
        notifyDataSetChanged();
    }
}
