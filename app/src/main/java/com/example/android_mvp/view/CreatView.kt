package com.example.android_mvp.view

import com.example.android_mvp.model.Post

interface CreatView {

    fun onCreatSucsess(post: Post)
    fun onCreatFailure(error:String)
}