package com.mrshashankbisht.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mrshashankbisht.recyclerview.data.PostData;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PostDataHolder> {
    ArrayList<PostData> arrayListPostData;
    public RecyclerViewAdapter(ArrayList<PostData> arrayListPostData) {
        this.arrayListPostData = arrayListPostData;
    }

    @NonNull
    @Override
    public PostDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        System.out.println("onCreateViewHolder");
        View view = View.inflate(parent.getContext(), R.layout.item_post_layout, null);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        PostDataHolder holder = new PostDataHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostDataHolder holder, int position) {
        System.out.println("onBindViewHolder : " + position);
        PostData postData = arrayListPostData.get(position);
        TextView tv = holder.itemView.findViewById(R.id.item_post_profile_name);
        tv.setText(postData.name);

        ImageView profile = holder.itemView.findViewById(R.id.item_post_profile);

        Glide.with(holder.itemView.getContext())
                .load(postData.profile_image)
                .circleCrop()
                .into(profile);
    }

    @Override
    public int getItemCount() {
        System.out.println("getItemCount");
        return arrayListPostData.size();
    }

    public class PostDataHolder extends RecyclerView.ViewHolder {
        public PostDataHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
