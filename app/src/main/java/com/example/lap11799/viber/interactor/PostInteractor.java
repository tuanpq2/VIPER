package com.example.lap11799.viber.interactor;

import com.example.lap11799.viber.PostConstract;
import com.example.lap11799.viber.data.GetDataService;
import com.example.lap11799.viber.data.RetrofitInstance;
import com.example.lap11799.viber.entity.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostInteractor implements PostConstract.IPostInteractor {

    @Override
    public void loadPost(final PostConstract.PostListener listener) {
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Post>> call = service.getAllData();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                listener.onFailure(t.getMessage());
            }
        });
    }
}