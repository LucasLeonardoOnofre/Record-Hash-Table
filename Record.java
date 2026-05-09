public class Record {
    private String genre;
    private int year;
    private String artist;
    private String title;

    public Record(String g, int y, String a, String t) {
        this.genre = g;
        this.year = y;
        this.artist = a;
        this.title = t;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return genre + "  |  " + String.valueOf(year) + "  |  " + artist;
    }
}