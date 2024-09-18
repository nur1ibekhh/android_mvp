package com.example.android_mvp.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android_mvp.R
import com.example.android_mvp.model.Post
import com.example.android_mvp.network.RetrofitHttp
import com.example.android_mvp.presenter.CreatePresenter
import com.example.android_mvp.view.CreatView

class CreatePostActivity : AppCompatActivity(), CreatView {

    private lateinit var etTitle: EditText
    private lateinit var etBody: EditText
    private lateinit var btnSave: Button
    private lateinit var createPresenter: CreatePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        etTitle = findViewById(R.id.et_title)
        etBody = findViewById(R.id.et_body)
        btnSave = findViewById(R.id.btn_save)
        createPresenter = CreatePresenter(this)

        btnSave.setOnClickListener {
            val title = etTitle.text.toString()
            val body = etBody.text.toString()
            if (title.isNotEmpty() && body.isNotEmpty()) {
                val post = Post(0, title, body) // Post obyektini yaratish
                createPresenter.creatPost(post)  // Post obyektini yuborish
            } else {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreatSucsess(post: Post) {
        Log.d("creat",post.toString())
        Toast.makeText(this, "Post update successfully", Toast.LENGTH_SHORT).show()

        finish() // Faoliyatni tugatish yoki boshqa sahifaga o'tish
    }

    override fun onCreatFailure(error: String) {
        Toast.makeText(this, "Failed to create post:", Toast.LENGTH_SHORT).show()
    }

}

