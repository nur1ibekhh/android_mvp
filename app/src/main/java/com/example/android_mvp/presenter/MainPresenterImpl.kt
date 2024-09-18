package com.example.android_mvp.presenter

import com.example.android_mvp.model.Post

interface MainPresenterImpl {
    fun apiPostList()
    fun apiPostDelet(post: Post)
}