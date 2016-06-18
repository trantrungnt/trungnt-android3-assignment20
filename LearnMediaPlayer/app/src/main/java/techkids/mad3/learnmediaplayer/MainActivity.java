package techkids.mad3.learnmediaplayer;

import android.content.ContentResolver;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnReplay, btnPlay, btnStop, btnPrevious, btnNext;
    private ListView lvListFileMusic;
    private ContentResolver musicResolver;
    private String title, artist, date, time;
    private SongAdapter songAdapter;
    private MediaPlayer mediaPlayer;
    private String path;
    private MediaMetadataRetriever mediaMetadataRetriever;
    private File musicFolder;
    private SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        displaySongList();
    }

    private void displaySongList() {
        ArrayList songs=new ArrayList();

        playMediaPlayer();

        musicFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        for (File f : musicFolder.listFiles())
        {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(musicFolder + "/" + f.getName());

            int secs = Integer.parseInt(mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)) / 1000;
            int mins = secs / 60;
            secs =  secs % 60;
            String singer = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);

            if ( singer == null || singer.equals(""))
                singer = "Unknown";
            String songtitle  = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);

            if ( songtitle == null )
                songtitle = f.getName();

            simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String date = simpleDateFormat.format(f.lastModified());

            String duration = String.format("%02d:%02d", mins, secs);

            Log.d("test", musicFolder + "/" + f.getName());
//            if (songtitle.toUpperCase().contains(title.toUpperCase())) {
                Song song = new Song(songtitle, singer, date , duration);
                songs.add(song);
//            }
        }

        songAdapter = new SongAdapter(getApplicationContext(), songs);
        lvListFileMusic.setAdapter(songAdapter);
        Log.d("path", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getPath());
    }

    private void initComponents() {
        btnReplay = (Button) this.findViewById(R.id.btnReplay);
        btnPlay = (Button) this.findViewById(R.id.btnPlay);
        btnPrevious = (Button) this.findViewById(R.id.btnBack);
        btnNext = (Button) this.findViewById(R.id.btnNext);
        btnStop = (Button) this.findViewById(R.id.btnStop);

        btnReplay.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        lvListFileMusic = (ListView) this.findViewById(R.id.lvListFileMusic);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id)
        {
            case R.id.btnReplay:
                repeatMediaPlayer();
                break;
            case R.id.btnPlay:
                playMediaPlayer();
                break;
            case R.id.btnBack:

                break;
            case R.id.btnNext:
                break;
            case R.id.btnStop:
                stopMediaPlayer();
                break;
        }
    }

    private void stopMediaPlayer()
    {
        if (mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        Log.d("path", "Stop");
    }

    private void playMediaPlayer()
    {
        mediaPlayer = new MediaPlayer();
        try {
            path = Helper.PATH_STORAGE_MUSIC + "How Will I Know Who You Are - Jessica.mp3";
            Log.d("path", path);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
            mediaPlayer.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
        Log.d("path", "Start");
    }

    private void repeatMediaPlayer()
    {
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
}
