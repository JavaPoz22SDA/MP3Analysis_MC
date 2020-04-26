public class Song {

    private String artist;
    private String year;
    private String album;
    private String title;
    private Long size;

    public Song(String artist, String year, String album, String title, Long size) {
        this.artist = artist;
        this.year = year;
        this.album = album;
        this.title = title;
        this.size = size;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Song{" +
                "artist='" + artist + '\'' +
                ", year='" + year + '\'' +
                ", album='" + album + '\'' +
                ", title='" + title + '\'' +
                ", size=" + size +
                '}';
    }
}
