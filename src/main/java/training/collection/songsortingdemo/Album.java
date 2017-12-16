package training.collection.songsortingdemo;

public class Album {

    private int albumNo;
    private String artistName;
    private int NoOfSongs;
    private String genre;
    private float rating;

    public Album(int albumNo, String artistName, int noOfSongs, String genre, float rating) {
        this.albumNo = albumNo;
        this.artistName = artistName;
        NoOfSongs = noOfSongs;
        this.genre = genre;
        this.rating = rating;
    }

    public int getAlbumNo() {
        return albumNo;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getNoOfSongs() {
        return NoOfSongs;
    }

    public String getGenre() {
        return genre;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumNo=" + albumNo +
                ", artistName='" + artistName + '\'' +
                ", NoOfSongs=" + NoOfSongs +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
}
