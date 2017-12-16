package training.collection.songsortingdemo;

public class AlbumNotFoundException extends Exception {

    public AlbumNotFoundException(String message, Throwable cause) {
//        super(message, cause);
        System.out.println("Something went wrong. Message: [" + message +"] ");
    }
}
