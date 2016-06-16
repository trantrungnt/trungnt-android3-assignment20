package techkids.mad3.learnmediaplayer;

/**
 * Created by TrungNT on 6/17/2016.
 */
public class Song {
    private long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String title;
    private String artist;
    private String currentDate;
    private String time;

    public Song(long id, String title, String artist, String currentDate, String time) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.currentDate = currentDate;
        this.time = time;
    }
}
