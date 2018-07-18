package com.example.lap11799.viber;

import com.example.lap11799.viber.entity.Post;

import java.util.List;

public interface PostConstract {

    interface IPostView{
        void showProgressBar();
        void hideProgressBar();
        void showPost(List<Post> posts);
        void showError(String message);
    }

    interface IPostPresenter{
        void getPost();
        void gotoPostDetail(Post post);
    }

    interface IPostInteractor{
        void loadPost(PostConstract.PostListener listener);
    }

    interface PostListener{
        void onSuccess(List<Post> posts);
        void onFailure(String message);
    }

    interface IPostRouter{
        void goToPostDetail(Post post);
    }

}