package com.example.android_mvp.activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_mvp.R
import com.example.android_mvp.adapter.PostAdapter
import com.example.android_mvp.model.Post
import com.example.android_mvp.presenter.MainPresenter
import com.example.android_mvp.view.MainView

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var recyclerView: RecyclerView
    lateinit var mainPresenter:MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }
    /*
    Basic Method
     */
    override fun postListOnSucsess(posts: ArrayList<Post>) {
        Log.d("MainActivity",posts.toString())
        refreshAdapter(posts!!)
    }

    override fun postListOnFailure(error: String) {

    }

    override fun postDeletOnSucsess(post: Post?) {
        Log.d("MainActivity",post.toString())
    }

    override fun postDeletOnFailure(error: String) {

    }
    private fun initViews() {
        var btn_update = findViewById<Button>(R.id.btn_update)
        btn_update.setOnClickListener {
            openCreatePostActivity()

            //  openUpdatePostActivity()

        }
        mainPresenter = MainPresenter(this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))
        mainPresenter.apiPostList()
    }
    private fun refreshAdapter(posts: ArrayList<Post>) {
        val adapter = PostAdapter(this, posts)
        recyclerView.adapter = adapter
    }

               // Activitylarni chaqirish uchun
    private fun oppenUpdatePostActivity() {
        val intent = Intent(this, UpdatePostActivity::class.java)
        startActivity(intent)
    }
    private fun openDetailPage() {
        val intent = Intent(this, PostDetailsActivity::class.java)
        startActivity(intent)
    }
    private fun openCreatePostActivity() {
        val intent = Intent(this, CreatePostActivity::class.java)
        startActivity(intent)
    }

}






    /*
    Api Method ol version for mvc
     */

//    private fun aipPostList(){
//        RetrofitHttp.postService.listPost().enqueue(object : Callback<ArrayList<Post>>{
//            override fun onResponse(
//                call: Call<ArrayList<Post>>,
//                response: Response<ArrayList<Post>>
//            ) {
//                Log.d("MainActivity",response.body().toString())
//                refreshAdapter(response.body()!!)
//            }
//
//            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
//
//            }
//        })
//    }

//    private fun apiPostDelet(post: Post){
//        RetrofitHttp.postService.deletePost(post.id).enqueue(object : Callback<Post>{
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                Log.d("Clear",post.id.toString() +"lik post o'chirildi")
//                aipPostList()
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//
//            }
//        })
//    }