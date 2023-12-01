
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Book {
private final String genre;

public Book(String genre) {
this.genre = genre;
}

public String getGenre() {
return genre;
}
}