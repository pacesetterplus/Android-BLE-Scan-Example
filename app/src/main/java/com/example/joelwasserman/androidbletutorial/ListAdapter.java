package com.example.joelwasserman.androidbletutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.CustomViewHolder> {
    private List<String> mScanDetails;

    public static class CustomViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;

        public CustomViewHolder(View view){
            super(view);
            mTextView = (TextView)view.findViewById(R.id.textView);
        }
    }

    public ListAdapter(){
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        if (mScanDetails != null) {
            String current = mScanDetails.get(position);
            holder.mTextView.setText(current);
        } else {
            // Covers the case of data not being ready yet.
            holder.mTextView.setText("No Device Found");
        }
    }

    @Override
    public int getItemCount() {
        if (mScanDetails != null)
            return mScanDetails.size();
        else return 0;

    }

    void setDevices(List<String> devices){
        mScanDetails = devices;
        notifyDataSetChanged();
    }


}
