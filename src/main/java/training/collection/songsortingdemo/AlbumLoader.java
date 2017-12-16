package training.collection.songsortingdemo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class AlbumLoader {

    public static void main(String[] args) throws AlbumNotFoundException {

        AlbumLoader albumLoader = new AlbumLoader();
        albumLoader.readFile(".\\src\\main\\resources\\data\\albums.txt");
    }
    private void readFile(String fileName) throws AlbumNotFoundException {

        File albumFile = new File(fileName);
//        File albumFile = new File(String.valueOf(this.getClass().getResource(fileName)));
//        File albumFile = new File(String.valueOf(this.getClass().getResourceAsStream(fileName)));
        ArrayList<Album> albums = new ArrayList<Album>();
        BufferedReader bufferedReader = null;
        try {
             bufferedReader = new BufferedReader(new FileReader(albumFile));
        } catch (FileNotFoundException e) {
            throw new AlbumNotFoundException("File not found", new Throwable());
        }
        try {
            String line="";
            //Ignoring the first line. As it is the instruction about the file.
            line = bufferedReader.readLine();
            while (true){
                line = "";
                line = bufferedReader.readLine();
                if(line==null){
                    break;
                }
                String[] parts = line.split(";");
                if(parts.length<5){
                    throw new AlbumNotFoundException(line, new Throwable());
                }
                Album album = new Album(Integer.parseInt(parts[0]),parts[1],Integer.parseInt(parts[2]),parts[3],Float.parseFloat(parts[4]));
                albums.add(album);
            }
        } catch (IOException e) {
            throw new AlbumNotFoundException("File not found", new Throwable());
        }

        System.out.println("Before sorting ");
        printList(albums);
        Collections.sort(albums,new RatingComparator());
        System.out.println("\nAfter sorting ");
        printList(albums);

    }

    public static void printList(ArrayList<Album> lst){
        for (Object object : lst) {
            System.out.println(object);
        }
    }
}
