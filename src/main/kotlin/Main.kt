abstract class Video(val title: String)

enum class MovieGenre {
   ACTION, 
   COMEDY,
   DRAMA,
   FANTASY,
   HORROR,
   MYSTERY,
   ROMANCE,
   THRILLER
}

class Movie(title: String, val genre: MovieGenre, val releaseYear: Int) : Video(title)

class YoutubeVideo(title: String, val link: String) : Video(title)

class TvShowEpisode(title: String, val season: Int, val series: Int) : Video(title)

class PlayList() {
   val videos: MutableList<Video> = mutableListOf()

   fun addVideo(video: Video) {
       videos.add(video)
   }

   fun playNext():String {
       if (videos.size!=0){
            val tmp:String="Now playing: " + videos[0].title
            videos.removeAt(0)
            return tmp
       }
       return ""
   }

   fun getAllVideos():MutableList<Video> {
       return videos
   }
}

fun main() {
    val firstMovie: Movie = Movie("Lock, Stock and Two Smoking Barrels", MovieGenre.COMEDY, 1998)
    val secondMovie: Movie = Movie("Fight Club", MovieGenre.THRILLER, 1999)
    val firstYoutubeVideo: YoutubeVideo = YoutubeVideo("PSY - GANGNAM STYLE(강남스타일) M/V", "https://www.youtube.com/watch?v=9bZkp7q19f0")
    val secondYoutubeVideo: YoutubeVideo = YoutubeVideo("Pink Panther Prances Through Cornfields | 35 Minute Compilation | The Pink Panther Show", "https://www.youtube.com/watch?v=3ZnC4DTshc4")
    val firstTvShowEpisode: TvShowEpisode = TvShowEpisode("eps2.1_k3rnel-pan1c.ksd", 2, 3)
    val secondTvShowEpisode: TvShowEpisode = TvShowEpisode("Family Tree", 1, 5)
    val playList: PlayList = PlayList()

    println(playList.playNext())
    println("")

    playList.addVideo(firstMovie)
    playList.addVideo(firstYoutubeVideo)
    playList.addVideo(firstTvShowEpisode)

    var tmpVideos: MutableList<Video> = playList.getAllVideos()
    println("Videos in playlist:")
    for (video in tmpVideos){
        println(video.title)
    }
    println("")

    println(playList.playNext())
    println("")

    playList.addVideo(secondMovie)
    playList.addVideo(secondYoutubeVideo)

    tmpVideos=playList.getAllVideos()
    println("Videos in playlist:")
    for (video in tmpVideos){
        println(video.title)
    }
    println("")

    println(playList.playNext())
    println("")

    playList.addVideo(secondTvShowEpisode)

    tmpVideos=playList.getAllVideos()
    println("Videos in playlist:")
    for (video in tmpVideos){
        println(video.title)
    }
    println("")

    println(playList.playNext())
}