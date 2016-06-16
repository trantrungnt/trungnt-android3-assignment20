package techkids.mad3.learnmediaplayer;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnReplay, btnAction, btnPrevious, btnNext, btnStop;
    private ListView lvListFileMusic;
    private ArrayList<Song> arrSongList;
    private ContentResolver musicResolver;
    private Uri musicUri;
    private Cursor musicCursor;

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
        arrSongList = new ArrayList<Song>();
        musicResolver = getContentResolver();
        musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        musicCursor = musicResolver.query(musicUri, null, null, null, null);
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
