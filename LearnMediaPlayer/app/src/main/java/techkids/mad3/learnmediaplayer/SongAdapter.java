package techkids.mad3.learnmediaplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by TrungNT on 6/17/2016.
 */
public class SongAdapter extends BaseAdapter {
    private ArrayList<Song> songArrayList;
    private LayoutInflater songInf;
    private Context context;
    private TextView txtNameSong, txtAuthor, txtCurrentDate, txtTimeSong;
    private Song song;

    public SongAdapter(Context c, ArrayList<Song> songs){
        this.songArrayList = songs;
        this.context = c;
        this.songInf = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return songArrayList.size();
    }

    @Override
    public Song getItem(int position) {
        return songArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.song_item, parent, false);
        }

        txtNameSong = (TextView) convertView.findViewById(R.id.txtNameSong);
        txtAuthor = (TextView) convertView.findViewById(R.id.txtAuthor);
        txtCurrentDate = (TextView) convertView.findViewById(R.id.txtCurrentDate);
        txtTimeSong = (TextView) convertView.findViewById(R.id.txtTimeSong);

        song = songArrayList.get(position);
        txtNameSong.setText(song.getTitle());
        txtAuthor.setText(song.getArtist());
        txtCurrentDate.setText(song.getCurrentDate());
        txtTimeSong.setText(song.getTime());

        return convertView;
    }
}
