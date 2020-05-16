import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.FileWriter;
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
                ID3v1 id3Tag = null;
                if (mp3file.hasId3v1Tag()){
                    id3Tag = mp3file.getId3v1Tag();
                } else if (mp3file.hasId3v2Tag()){
                    id3Tag = mp3file.getId3v2Tag();
                }
                if (id3Tag != null){
                    Song song = new Song (id3Tag.getArtist(),id3Tag.getYear(),id3Tag.getAlbum(),id3Tag.getTitle(),Files.size(entry));
                    listOfSongs.add(song);
                }
            }
        } catch (IOException | InvalidDataException | UnsupportedTagException x) {
            x.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter(filePath + "\\description.txt");
            for (Song song : listOfSongs){
                fileWriter.write(song.toString() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfSongs;
    }
}
