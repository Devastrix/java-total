package training.collection.songsortingdemo;

import java.util.Comparator;

public class RatingComparator implements Comparator<Album> {
    @Override
    public int compare(Album o1, Album o2) {
        return o1.getRating()>o2.getRating()?1:(o1.getRating()==o2.getRating())?0:-1;
    }
}
