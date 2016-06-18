package techkids.mad3.learnmediaplayer;

import android.content.ContentResolver;
import android.database.Cursor;
import android.media.AudioManager;
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
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnReplay, btnAction, btnPrevious, btnNext;
    private ListView lvListFileMusic;
    private ArrayList<Song> arrSongList;
    private ContentResolver musicResolver;
    private Uri musicUri;
    private Cursor musicCursor;
    private int titleColumn, idColumn, artistColumn, dateColumn, timeColumn;
    private long id;
    private String title, artist, date, time;
    private SongAdapter songAdapter;
    private MediaPlayer mediaPlayer;
    private String path;

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

        //du lieu gia lap
        Song song = new Song(1, "Trung", "Hello", "today", "24h");
        songs.add(song);

        songAdapter = new SongAdapter(getApplicationContext(), songs);
        lvListFileMusic.setAdapter(songAdapter);
        Log.d("path", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getPath());
    }

    private void initComponents() {
        btnReplay = (Button) this.findViewById(R.id.btnReplay);
        btnAction = (Button) this.findViewById(R.id.btnAction);
        btnPrevious = (Button) this.findViewById(R.id.btnBack);
        btnNext = (Button) this.findViewById(R.id.btnNext);

        btnReplay.setOnClickListener(this);
        btnAction.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);

        lvListFileMusic = (ListView) this.findViewById(R.id.lvListFileMusic);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id)
        {
            case R.id.btnReplay:
                break;
            case R.id.btnAction:
                break;
            case R.id.btnBack:
                break;
            case R.id.btnNext:
                break;
        }
    }
}
