package Playlist;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {

    private final String playlistName;
    private ArrayList<String> playlist = new ArrayList<>();

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public PlayListResult addTrack(String newTrack) {
        if (newTrack == null ||
                newTrack.isEmpty() ||
                playlist.contains(newTrack)) {
            return new PlayListResult(false, PlayListResult.ADD_FAIL_MESSAGE);
        }
        playlist.add(newTrack);
        return new PlayListResult(true, PlayListResult.ADD_SUCCESS_MESSAGE);
    }

    public PlayListResult deleteTrack(String newTrack) {
        if (newTrack == null ||
                newTrack.isEmpty() ||
                !playlist.contains(newTrack)) {
            return new PlayListResult(false, PlayListResult.DELETE_FAIL_MESSAGE);
        }
        playlist.remove(newTrack);
        return new PlayListResult(true, PlayListResult.DELETE_SUCCESS_MESSAGE);
    }

    public PlayListResult updateTrack(int index, String newTrack) {
        if (newTrack == null ||
                newTrack.isEmpty() ||
                index < 0 ||
                index >= playlist.size()) {
            return new PlayListResult(false, PlayListResult.UPDATE_FAIL_MESSAGE);
        }
        playlist.set(index, newTrack);
        return new PlayListResult(true, PlayListResult.UPDATE_SUCCESS_MESSAGE);
    }

    public PlayListResult getTrack(int index) {
        if (index < 0 ||
                index >= playlist.size()) {
            return new PlayListResult(false, PlayListResult.GET_FAIL_MESSAGE);
        }
        return new PlayListResult(true, PlayListResult.GET_SUCCESS_MESSAGE + playlist.get(index));
    }

    @Override
    public String toString() {
        return "Playlist.Playlist{" +
                "playlist=" + playlist +
                ", playlistName='" + playlistName + '\'' +
                '}';
    }

    public void playTrack(int index) {
        try {
            File audioFile = new File(findAudioFile(playlist.get(index)));
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();

            Scanner scanner = new Scanner(System.in);
            String answer;

            do {
                System.out.println("Хотите воспрозивести трек? y/n");
                answer = scanner.nextLine();
            } while (!answer.equalsIgnoreCase("y"));

            clip.open(audioStream);
                clip.start();
                    Thread.sleep(clip.getMicrosecondLength() / 1000);
                clip.close();
            audioStream.close();


        } catch (Exception e) {
            System.out.println("Ошибка воспроизведения: " + e.getMessage());
        }
    }

    private String findAudioFile(String fileName) {
        String[] possiblePaths = {
                fileName,
                "./" + fileName,
                "../" + fileName,
                "8 cringe/" + fileName,
                "../8 cringe/" + fileName,
                System.getProperty("user.dir") + "/" + fileName,
                System.getProperty("user.dir") + "/8 cringe/" + fileName
        };

        for (String path : possiblePaths) {
            File file = new File(path);
            if (file.exists()) {
                return file.getAbsolutePath();
            }
        }
        return null;
    }

}
