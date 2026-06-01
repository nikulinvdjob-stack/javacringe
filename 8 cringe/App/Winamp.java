package App;

import Playlist.Playlist;

public class Winamp {

    static void main() {
        Playlist playlist = new Playlist("summer2002");

        playlist.addTrack("TrackZ.wav").log();
        playlist.addTrack("Track2.mp3").log();
        playlist.addTrack("Track3.wav").log();

        playlist.deleteTrack("Track2.mp3").log();

        playlist.updateTrack(0, "Track1.wav").log();

        playlist.getTrack(99).log();
        playlist.getTrack(1).log();

        System.out.println(playlist.toString());

        playlist.addTrack("ahem_x.wav").log();
        playlist.playTrack(2);
        playlist.updateTrack(2, "boing_x.wav").log();
        playlist.playTrack(2);
    }

}
