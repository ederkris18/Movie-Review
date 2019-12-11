package at.fh.swengb.eder

class Movie (val id:String,
             val title:String,
             val release: String,
             val plot: String,
             val genre: MovieGenre,
             val director: Person,
             val actors: List<Person>,
             val reviews: MutableList<Review>)

{

    fun ratingAverage(): Double {
        var sum = 0.0
        reviews.forEach {
            sum += it.reviewValue
        }

        val average = String.format("%.3f", sum / reviews.count()).toDouble()
        return average
    }

    override fun toString(): String {
        return "Movie(id='$id', title='$title', release='$release', plot='$plot', genre=$genre, director=$director, actors=$actors, reviews=$reviews)"
    }

}