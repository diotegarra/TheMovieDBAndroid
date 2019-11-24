package com.dio.themoviedbandroid.main

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dio.themoviedbandroid.BuildConfig.URL_POSTER
import com.dio.themoviedbandroid.R
import com.dio.themoviedbandroid.model.Movie
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import com.dio.themoviedbandroid.R.id.movie_poster
import com.dio.themoviedbandroid.R.id.movie_title

class MainAdapter (private val result: List<Movie>, private val listener: (Movie) -> Unit)
    : RecyclerView.Adapter<MovieViewHolder>(){

    override fun onCreateViewHolder(Parent: ViewGroup, ViewType: Int): MovieViewHolder {
        return MovieViewHolder(MovieUI().createView(AnkoContext.create(Parent.context, Parent)))
    }

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(Parent: MovieViewHolder, ViewType: Int) {
        Parent.bindItem(result[ViewType], listener)
    }

}

class MovieViewHolder(view: View) :RecyclerView.ViewHolder(view) {
    private val moviePoster: ImageView = view.find(movie_poster)
    private val movieTitle: TextView = view.find(movie_title)

    fun bindItem(movies: Movie, listener: (Movie) -> Unit){
        Picasso.get().load(URL_POSTER + movies.poster).into(moviePoster)
        // Log.d("GAMBAR", "url = "+ URL_POSTER)
        movieTitle.text = movies.title

        moviePoster.onClick {
            listener(movies)
        }

    }

}

class MovieUI : AnkoComponent<ViewGroup>{
    override fun createView (ui: AnkoContext<ViewGroup>): View{
        return with(ui){
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(5)
                orientation =  LinearLayout.VERTICAL

                imageView{
                    id = R.id.movie_poster
                }.lparams{
                    height = dip(250)
                    width = wrapContent
                }

                textView {
                    id = R.id.movie_title
                    textSize = 16f
                }.lparams{
                    margin = dip(16)
                }
            }
        }

    }
}