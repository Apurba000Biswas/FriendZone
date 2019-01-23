package com.example.apurba.friendzone;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DataRecyclerAdapter extends RecyclerView.Adapter<DataRecyclerAdapter.ViewHolder>{


    private List<DataModel> mDataSet;
    private DataRVClickedListener mListener;

    public DataRecyclerAdapter(List<DataModel> dataSet, DataRVClickedListener listener){
        mDataSet = dataSet;
        mListener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.data_model_item,
                parent,
                false);
        return  new ViewHolder(view, mDataSet, mListener);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModel currentData = mDataSet.get(position);
        //holder.imageView.setText(currentData.getText1());
        holder.tvName.setText(currentData.getName());

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class ViewHolder extends
            RecyclerView.ViewHolder implements View.OnClickListener {

        private View mView;
        private List<DataModel> mDataset;
        public ImageView imageView;
        public TextView tvName;
        private DataRVClickedListener mListner;

        // Constructor - also initialize all fields with views
        public ViewHolder(View v, List<DataModel> dataset, DataRVClickedListener listener) {
            super(v);
            mView = v;
            v.setOnClickListener(this);
            mDataset = dataset;
            mListner = listener;
            initAllViews();
        }
        // initializes all fields to its appropriate view
        private void initAllViews(){
            imageView = mView.findViewById(R.id.iv_image);
            tvName = mView.findViewById(R.id.tv_name);
        }

        @Override
        public void onClick(View view) {
            DataModel clickedItem = mDataset.get(getAdapterPosition());
            // now pass this clicked item to your interface object
            mListner.onClick(clickedItem);
        }
    }

}
