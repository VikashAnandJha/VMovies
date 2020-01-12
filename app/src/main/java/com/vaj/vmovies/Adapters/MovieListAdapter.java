package com.vaj.vmovies.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vaj.vmovies.Modal.MoviesListModal;
import com.vaj.vmovies.R;

import java.util.ArrayList;

public class MovieListAdapter extends RecyclerView
        .Adapter<MovieListAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MovieAdpter";
    private ArrayList<MoviesListModal> mDataset;
    private static MyClickListener myClickListener;
    private Context context;
    ViewGroup parentt;
    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        TextView title;
        ImageView poster;

        View view;

        LinearLayout ll;
        public DataObjectHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);

            poster=(ImageView)itemView.findViewById(R.id.poster) ;





            Log.i(LOG_TAG, "Adding Listener");
            /// itemView.setOnClickListener(this);
            view=itemView;


        }

        @Override
        public void onClick(View v) {
//            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;

    }

    public MovieListAdapter(Context context, ArrayList<MoviesListModal> myDataset) {
        mDataset = myDataset;
        this.context=context;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movieitem, parent, false);
        parentt=parent;
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(final DataObjectHolder holder, final int position) {


        holder.title.setText(mDataset.get(position).getTitle());


        Glide.with(context).load(mDataset.get(position).getPosterUrl()).placeholder(R.drawable.loadingposter).into(holder.poster);




    }







    public void addItem(MoviesListModal dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);

    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }
    public void clear() {
        int size = this.mDataset.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                this.mDataset.remove(0);
            }

            this.notifyItemRangeRemoved(0, size);
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}





