package at.fh.swengb.eder

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast


class MovieRatingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rating)

        val movieId = intent.getStringExtra(MovieListActivity.EXTRA_MOVIE_ID) //wo ist diese id

        if (movieId == null) { //wo ist lesson id
            Toast.makeText(this, "No movieID given", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            val lessonName = MovieRepository.movieById(movieId)?.name
            movie_rating_header.text = movieName

            rate_movie.setOnClickListener{
                val ratingValue = movie_rating_bar.rating.toDouble() //vom lesson_rating.xml
                val feedback = movie_feedback.text.toString()
                val rating = MovieRating(ratingValue, feedback)

                MovieRepository.rateMovie(movieId,rating)

                setResult(Activity.RESULT_OK)
                finish()
            }


            movie_rating_bar.rating.toDouble()
            movie_feedback.text.toString()
        }

    }

}
