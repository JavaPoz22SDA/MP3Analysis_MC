import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MP3Analysis mp3Analysis = new MP3Analysis();
        List<Song> listOfSongs = new ArrayList<>();
        String filePath = "C:\\Users\\malgo\\Desktop\\mp3";
        listOfSongs = mp3Analysis.getListOfSongs(filePath);
        for (Song song : listOfSongs){
            System.out.println(song.toString());
        }
    }
}
