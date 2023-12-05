
public class Writer implements Runnable {
    private static final int BOOKS_TO_WRITE = 9;
    private final Library library;

    public Writer(Library library) {
        this.library = library;
    }

    @Override
    public void run() {
        for (int i = 0; i < BOOKS_TO_WRITE; i++) {
            writeBook();
        }
    }

    private void writeBook() {
        Book adventureBook = new Book("Adventure");
        System.out.println(Thread.currentThread().getName() + " is writing an " + adventureBook.getGenre() + " book.");
        // Simulating the process of writing a book
        try {
            Thread.sleep(100); // Writing takes time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        library.borrowBook(adventureBook); // Writer borrows a book from the library
    }
}
