package at.fh.swengb.eder

object MovieRepository {
    private val movies: List<Movie>

    init {
        val personDirector = Person("Quantin Terentino") //unklar
        val personPitt = Person("Brad Pitt")
        val lecturerBloder = Person("Lukas Bloder")
        movies = listOf(
            Movie("0",
                "Avengers: End Game",
                "2019",
                "Nach den vorangegangenen Ereignissen liegt das Universum dank des Titanen Thanos in Schutt und Asche. Die übrig gebliebenen Avengers - Thor, Black Widow, Captain America and Bruce Banner - müssen versuchen, ihre besiegten Verbündeten ein letztes mal zu versammeln, um in einem finalen Kampf gegen Thanos zu bestehen und das Chaos im Universum umzukehren.",
                MovieGenre.ACTION//,
                //listOf( lecturerIllis, lecturerBloder ),
                //mutableListOf()
            ),
            Movie("1",
                "Forrest Gump",
                "1994",
                "Der gutmütige, leicht gehbehinderte und mit einem IQ von nur 75 ausgestattete Forrest Gump schlägt sich auf bemerkenswerte Weise durch 40 Jahre amerikanische Geschichte. Er macht Karriere als Football-Spieler, Langstreckenläufer, dekorierter Vietnam-Held und Tischtennis-Profi. Als Unternehmer wird er zum Millionär. Ganz nebenbei erfindet er Elvis Presleys berühmten Hüftschwung und deckt, ohne es zu wissen, den Watergate-Skandal auf. Doch all die Zeit denkt er an seine große Liebe Jenny.",
                MovieGenre.ACTION//,
                //listOf( lecturerIllis, lecturerBloder ),
                //mutableListOf()
            )
            )
    }

    fun moviesList(): List<Movie> {
        return movies
    }

    fun movieById(id: String): Movie? {
        return movies.find { it.id == id }
    }

    fun rateLesson(id: String, review: Review) {
        movieById(id)?.reviews?.add(review)
    }
}