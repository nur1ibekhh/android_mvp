package com.example.android_mvp.view

import com.example.android_mvp.model.Post

interface MainView {

    fun postListOnSucsess(posts: ArrayList<Post>)

    fun postListOnFailure(error:String)

    fun postDeletOnSucsess(posts: Post?)

    fun postDeletOnFailure(error:String)
}