package com.example.lap11799.viber.router;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.lap11799.viber.PostConstract;
import com.example.lap11799.viber.R;
import com.example.lap11799.viber.entity.Post;
import com.example.lap11799.viber.view.PostListActivity;

public class PostRouter implements PostConstract.IPostRouter {

    private Activity activity;

    public PostRouter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void goToPostDetail(Post post) {
        View view = LayoutInflater.from(activity).inflate(R.layout.post_detail, null);
        new AlertDialog.Builder(activity)
                .setView(view)
                .create().show();
        TextView title = view.findViewById(R.id.title);
        TextView body = view.findViewById(R.id.body);
        title.setText(post.getTitle());
        body.setText(post.getBody());
    }
}
