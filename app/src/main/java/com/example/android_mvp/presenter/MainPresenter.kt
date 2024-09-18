package com.example.android_mvp.presenter

import android.util.Log
import com.example.android_mvp.model.Post
import com.example.android_mvp.network.RetrofitHttp
import com.example.android_mvp.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(var mainView: MainView):MainPresenterImpl {

    override fun apiPostList() {
        RetrofitHttp.postService.listPost().enqueue(object : Callback<ArrayList<Post>> {
            override fun onResponse(call: Call<ArrayList<Post>>, response: Response<ArrayList<Post>>) {
               mainView.postListOnSucsess(response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
                mainView.postListOnFailure(t.toString())
            }
        })
    }

    override fun apiPostDelet(post: Post) {
        RetrofitHttp.postService.deletePost(post.id).enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
               mainView.postDeletOnSucsess(response.body()!!)
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                mainView.postDeletOnFailure(t.toString())
            }
        })
    }
}