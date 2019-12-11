package at.fh.swengb.eder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_movies.view.*

class MovieAdapter(val clickListener: (movie: Movie) -> Unit): RecyclerView.Adapter<MovieViewHolder>() {

    private var movieList = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val movieItemView = inflater.inflate(R.layout.item_movies, parent, false)
        return MovieViewHolder(movieItemView, clickListener)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val lesson = movieList[position]
        holder.bindItem(lesson)
    }

    fun updateList(newList: List<Movie>) {
        movieList = newList
        notifyDataSetChanged()
    }
}

class MovieViewHolder(itemView: View, val clickListener: (lesson: Movie) -> Unit): RecyclerView.ViewHolder(itemView) {
    fun bindItem(movie: Movie) {
        itemView.item_movie_name.text = movie.name //von item_movies
        itemView.item_movie_director.text = movie.director
        itemView.item_movie_actors.text = movie.actors
        itemView.item_movie_plot.text = movie.plot
        itemView.item_movie_genre.text = movie.genre
        itemView.item_movie_release.text = movie.release

        itemView.item_movie_person.text = movie.person.map { it.name }.joinToString() //von item_movies
        itemView.item_movie_avg_rating_bar.rating = movie.ratingAverage().toFloat()
        itemView.item_movie_avg_rating_value.text = movie.ratingAverage().toString()
        itemView.item_movie_rating_count.text = movie.reviews.size.toString()


        itemView.setOnClickListener {
            clickListener(movie)
        }
    }
}