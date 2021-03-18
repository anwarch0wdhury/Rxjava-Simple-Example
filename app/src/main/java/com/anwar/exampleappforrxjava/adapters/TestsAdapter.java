package com.anwar.exampleappforrxjava.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anwar.exampleappforrxjava.R;
import com.anwar.exampleappforrxjava.model.TeststoryModel;

import java.util.ArrayList;
import java.util.List;

public class TestsAdapter extends RecyclerView.Adapter<TestsAdapter.PostViewHolder> {
    private List<TeststoryModel> stories = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.tv_Title.setText(stories.get(position).getTitle());
        holder.tv_User.setText(stories.get(position).getUserId()+"");
        holder.tv_Body.setText(stories.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public void setList(List<TeststoryModel> moviesList) {
        this.stories = moviesList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView tv_Title, tv_User, tv_Body;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_Title = itemView.findViewById(R.id.tv_title);
            tv_User = itemView.findViewById(R.id.tv_userID);
            tv_Body = itemView.findViewById(R.id.tv_body);
        }
    }
}
