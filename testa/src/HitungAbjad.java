import java.io.*;
import java.nio.file.*;






 class HitungAbjad {
    private char lookFor;
    private Path file;

    HitungAbjad(char input, Path file) {
        this.lookFor = input;
        this.file = file;
    }

    public int counter() throws IOException {
        int count = 0;
        try (InputStream in = Files.newInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
            {
            String line = null;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (lookFor == line.charAt(i)) {
                        count++;
                    }
                }
            }
        } catch (IOException x) {
            System.err.println();
        }
        return count;
    }

    static void banyak() {
        System.out.println("usage: java CountLetter <letter>");
        System.exit(-1);
    }

    public static void main(String[] args) throws IOException {

        if (args.length != 1 || args[0].length() != 1)
            banyak();

        char lookFor = args[0].charAt(0);
         Path file = Paths.get("xanadu.txt");
        int count = new HitungAbjad(lookFor, file).counter();
        System.out.format("File '%s' has %d instances of letter '%c'.%n",
                file, count, lookFor);
    }
}