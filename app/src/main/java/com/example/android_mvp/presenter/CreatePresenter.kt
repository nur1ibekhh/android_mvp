package com.example.android_mvp.presenter

import android.util.Log
import android.widget.Toast
import com.example.android_mvp.model.Post
import com.example.android_mvp.network.RetrofitHttp
import com.example.android_mvp.view.CreatView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreatePresenter(var creatView: CreatView) : CreatePresenterImpl {

    override fun creatPost(post: Post) {
        RetrofitHttp.postService.createPost(post).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    creatView.onCreatSucsess(response.body()!!)
                } else {
                   Log.d("CreatePresenter faild",response.body().toString())
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                creatView.onCreatFailure(t.toString())
            }
        })
    }
}