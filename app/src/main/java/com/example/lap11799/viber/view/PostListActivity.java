package com.example.lap11799.viber.view;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lap11799.viber.PostConstract;
import com.example.lap11799.viber.presenter.PostPresenter;
import com.example.lap11799.viber.R;
import com.example.lap11799.viber.entity.Post;

import java.util.List;

public class PostListActivity extends AppCompatActivity implements PostConstract.IPostView {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    private PostAdapter adapter;
    PostPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        hideProgressBar();
        presenter = new PostPresenter(this);
        presenter.getPost();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showPost(List<Post> data) {
        adapter = new PostAdapter(this,data,presenter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PostListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

}
