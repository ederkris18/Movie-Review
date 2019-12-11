package at.fh.swengb.eder

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_movie_list.*

class MovieListActivity : AppCompatActivity() {
    companion object {
        val EXTRA_MOVIE_ID = "MOVIE_ID_EXTRA" //anstatt text view über rating bar soll movie name stehen
        val ADD_OR_EDIT_RATING_REQUEST = 1
    }
    val MovieAdapter = MovieAdapter() { movie ->
        val implicitIntent = Intent(this, MovieRatingActivity::class.java)
        implicitIntent.putExtra(EXTRA_LESSON_ID, movie.id)
        startActivityForResult(implicitIntent, ADD_OR_EDIT_RATING_REQUEST)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        lessonAdapter.updateList(MovieRepository.lessonsList())
        movie_recycler_view.layoutManager = LinearLayoutManager(this)
        movie_recycler_view.adapter = lessonAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if ( resultCode == Activity.RESULT_OK && requestCode == ADD_OR_EDIT_RATING_REQUEST) {
            lessonAdapter.updateList(MessonRepository.lessonsList())
        }
    }

}