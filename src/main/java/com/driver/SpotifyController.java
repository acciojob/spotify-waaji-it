package com.driver;

import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("spotify")
public class SpotifyController {

    //Autowire will not work in this case, no need to change this and add autowire
    SpotifyService spotifyService = new SpotifyService();

    @PostMapping("/add-user")
    public String createUser(@RequestParam(name = "name") String name, String mobile){
        //create the user with given name and number
        User user = spotifyService.createUser(name, mobile);
        //spotifyService.addUser(user);
        return "Success";
    }

    @PostMapping("/add-artist")
    public String createArtist(@RequestParam(name = "name") String name){
        //create the artist with given name
        Artist artist = spotifyService.createArtist(name);
        //spotifyService.addArtist(artist);
        return "Success";
    }

    @PostMapping("/add-album")
    public String createAlbum(@RequestParam(name = "title") String title, String artistName){
        //If the artist does not exist, first create an artist with given name
        //Create an album with given title and artist
      /*  Artist artist = spotifyService.findArtistByName(artistName);
        if (artist == null) {
            artist = new Artist(artistName);
            spotifyService.addArtist(artist);
        }

        // Create an album with given title and artist
        Album album = new Album(title, artist);
        spotifyService.addAlbum(album);
       */
        Album album = spotifyService.createAlbum(title, artistName);
        return "Success";
    }


    @PostMapping("/add-song")
    public String createSong(String title, String albumName, int length) throws Exception{
        //If the album does not exist in database, throw "Album does not exist" exception
        //Create and add the song to respective album

//        Album album = spotifyService.findAlbumByName(albumName);
//        if (album == null) {
//            throw new Exception("Album does not exist");
//        }
//
//        // Create and add the song to respective album
//        Song song = new Song(title, album, length);
//        spotifyService.addSong(song);
        Song song = spotifyService.createSong(title, albumName, length);
        return "Success";
    }

    @PostMapping("/add-playlist-on-length")
    public String createPlaylistOnLength(String mobile, String title, int length) throws Exception{
        //Create a playlist with given title and add all songs having the given length in the database to that playlist
        //The creater of the playlist will be the given user and will also be the only listener at the time of playlist creation
        //If the user does not exist, throw "User does not exist" exception
//        User user = spotifyService.findUserByMobile(mobile);
//        if (user == null) {
//            throw new Exception("User does not exist");
//        }
//
//        Playlist playlist = new Playlist(title, user);
//        for (Song song : spotifyService.getAllSongs()) {
//            if (song.getLength() == length) {
//                playlist.addSong(song);
//            }
//        }
//
//        spotifyService.addPlaylist(playlist);
        Playlist playlist = spotifyService.createPlaylistOnLength(mobile, title, length);
        return "Success";

    }

    @PostMapping("/add-playlist-on-name")
    public String createPlaylistOnName(String mobile, String title, List<String> songTitles) throws Exception{
//        try {
//            spotifyService.createPlaylistOnName(mobile, title, songTitles);
//            return "Success";
//        } catch (UserNotFoundException e) {
//            return "User not found";
//        } catch (SongNotFoundException e) {
//            return "Song not found";
//        }
        Playlist playlist = spotifyService.createPlaylistOnName(mobile,title,songTitles);
        return "Success";
    }
    @PutMapping("/find-playlist")
    public String findPlaylist(String mobile, String playlistTitle) throws Exception{
//        try {
//            spotifyService.findPlaylist(mobile, playlistTitle);
//            return "Success";
//        } catch (UserNotFoundException e) {
//            return "User not found";
//        } catch (PlaylistNotFoundException e) {
//            return "Playlist not found";
//        } catch (UserAlreadyExistsInPlaylistException e) {
//            return "User already exists in playlist";
//        }
        Playlist playlist = spotifyService.findPlaylist(mobile, playlistTitle);

        return "Success";
    }


    @PutMapping("/like-song")
    public String likeSong(String mobile, String songTitle) throws Exception {
//        User user = spotifyService.findUser(mobile);
//        if (user == null) {
//            throw new Exception("User does not exist");
//        }
//
//        Song song = spotifyService.findSong(songTitle);
//        if (song == null) {
//            throw new Exception("Song does not exist");
//        }
//
//        if (user.getLikedSongs().contains(song)) {
//            // User has already liked the song, do nothing
//            return song;
//        }
//
//        // Add the song to user's liked songs list
//        user.getLikedSongs().add(song);
//
//        // Like the corresponding artist of the song
//        Artist artist = song.getArtist();
//        artist.setLikes(artist.getLikes() + 1);
//
//        return song;
        Song song = spotifyService.likeSong(mobile,songTitle);
        return "Success";
    }

    @GetMapping("/popular-artist")
    public String mostPopularArtist(){
        //Return the artist name with maximum likes
        return spotifyService.mostPopularArtist();
//        List<Artist> artists = spotifyService.getAllArtists();
//        Map<String, Integer> artistLikes = new HashMap<>();
//
//        for (Artist artist : artists) {
//            List<Song> songs = spotifyService.getSongsByArtist(artist.getName());
//
//            int artistTotalLikes = 0;
//            for (Song song : songs) {
//                artistTotalLikes += song.getLikes();
//            }
//
//            artistLikes.put(artist.getName(), artistTotalLikes);
//        }
//
//        String mostPopularArtist = "";
//        int maxLikes = 0;
//        for (String artist : artistLikes.keySet()) {
//            int likes = artistLikes.get(artist);
//            if (likes > maxLikes) {
//                mostPopularArtist = artist;
//                maxLikes = likes;
//            }
//        }
//
//        return mostPopularArtist;
    }

    @GetMapping("/popular-song")
    public String mostPopularSong(){
        //return the song title with maximum likes
//        List<Song> songs = spotifyService.getAllSongs();
//        String mostPopularSong = "";
//        int maxLikes = 0;
//
//        for (Song song : songs) {
//            if (song.getLikes() > maxLikes) {
//                mostPopularSong = song.getTitle();
//                maxLikes = song.getLikes();
//            }
//        }
//
//        return mostPopularSong;
        return spotifyService.mostPopularSong();
    }
}
