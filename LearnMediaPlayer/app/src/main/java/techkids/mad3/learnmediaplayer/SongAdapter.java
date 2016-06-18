package techkids.mad3.learnmediaplayer;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

    private class ViewHolder{
        TextView txtNameSong;
        TextView txtAuthor;
        TextView txtCurrentDate;
        TextView txtTimeSong;
    }

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
        final ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.song_item, parent, false);

            holder = new ViewHolder();
            holder.txtNameSong = (TextView) convertView.findViewById(R.id.txtNameSong);
            holder.txtAuthor = (TextView) convertView.findViewById(R.id.txtAuthor);
            holder.txtCurrentDate = (TextView) convertView.findViewById(R.id.txtCurrentDate);
            holder.txtTimeSong = (TextView) convertView.findViewById(R.id.txtTimeSong);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        song = songArrayList.get(position);
        holder.txtNameSong.setText(song.getTitle());
        holder.txtAuthor.setText(song.getArtist());
        holder.txtCurrentDate.setText(song.getCurrentDate());
        holder.txtTimeSong.setText(song.getTime());

        return convertView;
    }
}
