import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\malgo\\Desktop\\mp3";
        if(args.length > 0){
            filePath = args[0];
        }
        System.out.println(Arrays.toString(args));
        MP3Analysis mp3Analysis = new MP3Analysis();
        List<Song> listOfSongs;

        listOfSongs = mp3Analysis.getListOfSongs(filePath);
        for (Song song : listOfSongs){
            System.out.println(song.toString());
        }
    }
}
