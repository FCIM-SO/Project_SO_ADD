
// Reader.java
public class Reader implements Runnable {
    private static final int BOOKS_TO_READ = 9;
    private final Library library;

    public Reader(Library library) {
        this.library = library;
    }

    @Override
    public void run() {
        for (int i = 0; i < BOOKS_TO_READ; i++) {
            readBook();
        }
    }

    private void readBook() {
        Book adventureBook = new Book("Adventure");
        System.out.println(Thread.currentThread().getName() + " is reading an " + adventureBook.getGenre() + " book.");
        // Simulating the process of reading a book
        try {
            Thread.sleep(50); // Reading takes less time than writing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        library.borrowBook(adventureBook); // Reader borrows a book from the library
    }
}