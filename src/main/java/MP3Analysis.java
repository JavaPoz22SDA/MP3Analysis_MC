import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class MP3Analysis {

    public List<Song> getListOfSongs (String filePath){
        Path path = Paths.get(filePath);
        List<Song> listOfSongs = new ArrayList<>();
        try (DirectoryStream<Path> files = Files.newDirectoryStream(path, "*.mp3")) {
            for (Path entry: files) {
                Mp3File mp3file = new Mp3File(entry);
                ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                Song song = new Song (id3v1Tag.getArtist(),id3v1Tag.getYear(),id3v1Tag.getAlbum(),id3v1Tag.getTitle(),mp3file.getLengthInSeconds());
//                System.out.println("Artist: " + id3v1Tag.getArtist());
//                System.out.println("Title: " + id3v1Tag.getTitle());
//                System.out.println("Album: " + id3v1Tag.getAlbum());
//                System.out.println("Year: " + id3v1Tag.getYear());
//                System.out.println("Length of this mp3 is: " + mp3file.getLengthInSeconds() + " seconds");
                listOfSongs.add(song);
            }
        } catch (IOException x) {
            System.err.println(x);
        } catch (InvalidDataException e) {
            e.printStackTrace();
        } catch (UnsupportedTagException e) {
            e.printStackTrace();
        }

        return listOfSongs;
    }


}
