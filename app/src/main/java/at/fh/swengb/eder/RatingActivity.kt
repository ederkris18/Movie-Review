package at.fh.swengb.eder

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_rating.*

class RatingActivity : AppCompatActivity() {
    private val rating = Rating("movie01")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)
    }

    fun saveRating(v: View) {
        rating.feedback = feedback_input.text.toString() //von movie_rating
        rating.rating = rating_bar.rating.toDouble()

        movie.text = rating.movie
        feedback.text = rating.feedback
        rating_value.text = rating.rating?.toString() ?: "0"
    }
}
