# trungnt-android3-assignment20
##Yêu cầu
![BTVN Media Player1](http://i477.photobucket.com/albums/rr132/trungepu/13446281_861696833937103_789442249_o_zpsgxlzpwqs.jpg)
![BTVN Media Player2](http://i477.photobucket.com/albums/rr132/trungepu/13461295_861696870603766_1416147647_o_zpsvxpx1bxg.jpg)
![BTVN Mediao Player3](http://i477.photobucket.com/albums/rr132/trungepu/BTVN%20Media%20Player%202_zps3b9i4fax.jpg)

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
