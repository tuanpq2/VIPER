package com.example.lap11799.viber.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lap11799.viber.R;
import com.example.lap11799.viber.entity.Post;
import com.example.lap11799.viber.presenter.PostPresenter;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.DataViewHolder>  {
    private List<Post> postList;
    private Context context;
    private PostPresenter presenter;

    public PostAdapter(Context context, List<Post> postList, PostPresenter presenter){
        this.context = context;
        this.postList = postList;
        this.presenter = presenter;
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_row, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, final int position) {
        holder.id.setText(postList.get(position).getId());
        holder.title.setText(postList.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.gotoPostDetail(postList.get(position));
            }
        });
    }

    class DataViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        TextView id;
        TextView title;

        DataViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            id = mView.findViewById(R.id.id);
            title = mView.findViewById(R.id.title);
        }
    }
}

