import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Library {
private static final int TOTAL_BOOKS = 9;
private static final List<Book> availableBooks = new ArrayList<>();

static {
// Инициализация массива книг при создании библиотеки
for (int i = 0; i < TOTAL_BOOKS; i++) {
availableBooks.add(new Book("Adventure"));
}
}

private static final Lock lock = new ReentrantLock();

public static void borrowBook(Book book) {
lock.lock();
try {
if (availableBooks.contains(book)) {
System.out.println(Thread.currentThread().getName() + " borrowed an " + book.getGenre() + " book.");
availableBooks.remove(book);
} else {
System.out.println(Thread.currentThread().getName() + " couldn't borrow an " + book.getGenre() + " book. Not enough available.");
}
} finally {
lock.unlock();
}
}
}