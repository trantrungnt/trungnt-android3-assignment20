# trungnt-android3-assignment20
##Yêu cầu
![BTVN Media Player1](http://i477.photobucket.com/albums/rr132/trungepu/13446281_861696833937103_789442249_o_zpsgxlzpwqs.jpg)
![BTVN Media Player2](http://i477.photobucket.com/albums/rr132/trungepu/13461295_861696870603766_1416147647_o_zpsvxpx1bxg.jpg)
![BTVN Mediao Player3](http://i477.photobucket.com/albums/rr132/trungepu/BTVN%20Media%20Player%202_zps3b9i4fax.jpg)

##Các bước để làm được bài
+ Truy cập vào External Storage - SDCARD
+ Sử dụng MediaMetadataRetriever class để truy cập thông tin về bài hát có định dạng mmp3 file
+ Xây dựng Adapter class để gắn dữ liệu cho Listview


##Chú ý khi code
+ Có 3 cách chạy file mp3: từ Application Resource, từ Stored in sd card và từ Internet
```
 private void displaySongList() {
        arrSongList = new ArrayList<Song>();
        musicResolver = getContentResolver();
        musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        musicCursor = musicResolver.query(musicUri, null, null, null, null);

        if(musicCursor!=null && musicCursor.moveToFirst()){
            //get columns
            idColumn = musicCursor.getColumnIndex(android.provider.MediaStore.Audio.Media._ID);
            titleColumn = musicCursor.getColumnIndex(android.provider.MediaStore.Audio.Media.TITLE);
            artistColumn = musicCursor.getColumnIndex(android.provider.MediaStore.Audio.Media.ARTIST);
            dateColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media.DATE_ADDED);
            timeColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
            //add songs to list
            do {
                long id = musicCursor.getLong(idColumn);
                title = musicCursor.getString(titleColumn);
                artist = musicCursor.getString(artistColumn);
                date = musicCursor.getColumnName(dateColumn);
                time = musicCursor.getColumnName(timeColumn);
                arrSongList.add(new Song(id, title, artist, date, time));
            }
            while (musicCursor.moveToNext());
        }

        songAdapter = new SongAdapter(getApplicationContext(), arrSongList);
        lvListFileMusic.setAdapter(songAdapter);
    }

```

+ Truy cập: cách lấy đường dẫn của thư mục MUSIC trong SD Card
```
 Log.d("path", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getPath());
```
hoặc: 
```
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

        songAdapter = new SongAdapter(getApplicationContext(), songs);
        lvListFileMusic.setAdapter(songAdapter);
    }

```
Trong đó, file Helper chứa nội dung đường dẫn của cách này
```
public class Helper {
    public static String PATH_STORAGE_MUSIC = Environment.getExternalStorageDirectory().getPath() + "/Music/";
}
```
Kết quả đường dẫn của thư mục Music của SD Card trên máy tính: 
```
 D/path: /storage/emulated/0/Music/How Will I Know Who You Are - Jessica.mp3
 D/path: /storage/emulated/0/Music
```


##Tham khảo
+ [List all music in media store with the paths](http://stackoverflow.com/questions/13568798/list-all-music-in-mediastore-with-the-paths)
+ [Create a music player on android project setup mobile](http://code.tutsplus.com/tutorials/create-a-music-player-on-android-project-setup--mobile-22764)
+ [Material Design Icons](https://materialdesignicons.com/)
+ [Create a Music Player on Android: User Controls](http://code.tutsplus.com/tutorials/create-a-music-player-on-android-user-controls--mobile-22787)
+ [Meida Player in Android](https://developer.android.com/reference/android/media/MediaPlayer.html)
+ [Android Media Player](http://www.tutorialspoint.com/android/android_mediaplayer.htm)
+ [Media Player](https://developer.android.com/guide/topics/media/mediaplayer.html)
+ [Android building audio player tutorial](http://www.androidhive.info/2012/03/android-building-audio-player-tutorial/)
+ [Playing audio in Android example](http://www.javatpoint.com/playing-audio-in-android-example)
+ [Play MP3 in Android Tutorial Android Media Player Example](http://jmsliu.com/2499/play-mp3-in-android-tutorial-android-mediaplayer-example.html)
+ [Using an ArrayAdapter with ListView](https://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
+ [Audio Playback and Recording](https://guides.codepath.com/android/Audio-Playback-and-Recording)
+ [Get file .mp3 from SDCard and display to listview](https://googleandroid4you.wordpress.com/2011/11/16/get-file-from-sdcard-and-display-to-listview/)
+ [Displaying the List of music files Stored in SD card and playing music in the background](http://z4android.blogspot.com/2011/06/displaying-list-of-music-files-stored.html)
+ [Audio Player](http://www.srikanthtechnologies.com/blog/android/audioplayer.aspx)
+ [How to get the file creation data in Java](http://www.mkyong.com/java/how-to-get-the-file-creation-date-in-java/)
+ [Android - How to get a files creation date](http://stackoverflow.com/questions/2389225/android-how-to-get-a-files-creation-date)
+ [SimpleDateFormat convert data to string formatted parse](http://alvinalexander.com/java/simpledateformat-convert-date-to-string-formatted-parse)
+ [Change date format to String in Java](http://stackoverflow.com/questions/4772425/change-date-format-in-a-java-string)
