package com.dio.themoviedbandroid.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dio.themoviedbandroid.R
import com.dio.themoviedbandroid.detail.DetailActivity
import com.dio.themoviedbandroid.model.Movie
import com.dio.themoviedbandroid.networking.ApiRepository
import com.google.gson.Gson
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.wrapContent
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var listMovie : RecyclerView
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter
    private var movies: MutableList<Movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            padding = dip(16)

            listMovie = recyclerView{
                lparams(width = matchParent, height = wrapContent)
                layoutManager =  GridLayoutManager(ctx, 2)
            }
        }

        adapter = MainAdapter(movies){
            startActivity<DetailActivity>()
        }

        listMovie.adapter = adapter
        presenter = MainPresenter(this, ApiRepository(), Gson())
        presenter.getMovieList()
    }

    override fun showMovieList(data: List<Movie>) {
        movies.clear()
        movies.addAll(data)
        adapter.notifyDataSetChanged()
    }
}
