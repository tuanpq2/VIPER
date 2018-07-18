package com.example.lap11799.viber.presenter;

import android.app.Activity;

import com.example.lap11799.viber.PostConstract;
import com.example.lap11799.viber.interactor.PostInteractor;
import com.example.lap11799.viber.entity.Post;
import com.example.lap11799.viber.router.PostRouter;

import java.util.List;

public class PostPresenter implements PostConstract.IPostPresenter, PostConstract.PostListener {

    private PostConstract.IPostView photosView;
    private PostConstract.IPostInteractor postInteractor;
    private PostConstract.IPostRouter router;

    public PostPresenter(PostConstract.IPostView photosView) {
        this.photosView = photosView;
        this.postInteractor = new PostInteractor();
        this.router = new PostRouter((Activity) photosView);
    }


    @Override
    public void getPost() {
        photosView.showProgressBar();
        postInteractor.loadPost(this);
    }

    @Override
    public void gotoPostDetail(Post post) {
        router.goToPostDetail(post);
    }

    @Override
    public void onSuccess(List<Post> data) {
        photosView.showPost(data);
        photosView.hideProgressBar();
    }

    @Override
    public void onFailure(String message) {
        photosView.showError(message);
        photosView.hideProgressBar();
    }
}