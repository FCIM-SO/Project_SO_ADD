public class Main_lab6 {
    public static void main(String[] args) {
        Library library = new Library();

        Thread[] writers = new Thread[2];
        Thread[] readers = new Thread[10];

        for (int i = 0; i < writers.length; i++) {
            writers[i] = new Thread(new Writer(library), "Writer " + (i + 1));
            writers[i].start();
        }

        for (int i = 0; i < readers.length; i++) {
            readers[i] = new Thread(new Reader(library), "Reader " + (i + 1));
            readers[i].start();
        }
    }
}