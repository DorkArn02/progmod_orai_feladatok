package register;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class NewRegisterMain {
    /**
     * Task 0: Update the project:
     *          - From menu: Git / "Update Project...", OR
     *          - In right upper corner: blue arrow, OR
     *          - Keyboard shortcut: Ctrl+T
     * In "Update the project" popup click on Ok button.
     */

    /**
     * Task 1: Create a main method, where:
     *          - Create a new list of User objects.
     *          - Add 3 users to the list:
     *              - Tony Stark, 1970, 10880 Malibu Point, Malibu
     *              - Stephen Strange, 1930, 177A Bleecker Street, New York City
     *              - Steve Rogers, 1918, 569 Leaman Place, Brooklyn
     *          - Print the list
     *          - Remove Tony Stark from the list
     *          - Print the list
     *          - Add to the 2nd position a new user:
     *              - Peter Parker, 2001, 20 Ingram Street, New York
     *          - Print the list
     */
    public static void main(String[] args) throws IOException {
        List<User> u = new ArrayList<>();

        User u1 = new User("Tony Stark", 1970, "10880 Malibu Point, Malibu");
        User u2 = new User("Stephen Strange", 1930, "177A Bleecker Street, New York City");
        User u3 = new User("Steve Rogers", 1918, "569 Leaman Place, Brooklyn");
        u.add(u1);
        u.add(u2);
        u.add(u3);
        /*
        printList(u);

        u.remove(u1);

        printList(u);

        u.add(2, new User("Peter Parker", 2001, "2001, 20 Ingram Street, New York"));

        printList(u);
        */

        writeUsersIntoFile(u, "./src/main/resources/users.csv");

        List<User> lis = readUsersFromFile("./src/main/resources/users.csv");

        printList(lis);

    }

    /**
     * Task 2: Create a printList method to print the name of users in the list:
     * 1. Tony Stark
     * 2. Stephen Strange
     * 3. Steve Rogers
     * Use this method in main to print the list.
     */
    public static void printList(List<User> u){
        u.forEach(i -> System.out.print(i.getName() + ", "));
        System.out.println();
    }

    /**
     * Task 3: Create a writeUsersIntoFile method to save data of users into a file.
     * The method should get the list of users and the filepath.
     * Add a header to the file: Name;BirthYear;Address.
     * After the header write the name, year of birth and address data of users.
     * Each data of the same user should be separated by semicolon (';') character.
     * Data of users should be listed in separated rows.
     * Call the method with previously created list and "src/main/resources/users.csv" string as filepath.
     * Hint: Use BufferedWriter or FileOutputStream to write a file.
     * Hint: You should convert Strings to bytearrays with getBytes() method of String class.
     * Hint: Do not forget to add new line characters.
     * Hint: Create new method for repeating code snippets.
     */
    public static void writeUsersIntoFile(List<User> u, String filepath) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));

        bw.write("Name;BirthYear;Address\n");

        for (User user : u) {
            bw.write(user.getName() + ";" + user.getBirthYear() + ";" + user.getAddress() + "\n");
        }
        bw.close();
        /* TANÁRI MEGOLDÁS
        FileOutputStream w = new FileOutputStream(filepath);
        w.write("Name;BirthYear;Address\r\n".getBytes(StandardCharsets.UTF_8));
        String r;
        for (User user : u) {
            r = user.getName() + ";" + user.getBirthYear() + ";" + user.getAddress();
            w.write(r.getBytes(StandardCharsets.UTF_8));
        }
        */
    }

    /**
     * Task 4: Create a readUsersFromFile method to read user's data from the file.
     * The method should return with the list of users.
     * Hint: Use BufferedReader or FileInputStream to read from a file.
     * Hint: Take care about the header row.
     */
    public static ArrayList<User> readUsersFromFile(String filepath) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(filepath));

        br.readLine(); // Skips the header...

        ArrayList<User> u = new ArrayList<>();

        String l;
        while((l = br.readLine()) != null){
            String[] d = l.split(";");
            u.add(new User(d[0], Integer.parseInt(d[1]), d[2]));
        }

        return u;
    }

    /**
     * Task 5: Create similar reader and writer methods to read and write Song objects.
     */
    public static void writeSongsIntoFile(ArrayList<Song> u, String path) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));

        bw.write("Band;Title;Length in minutes\n");

        for (Song s : u) {
            bw.write(s.getBand() + ";" + s.getTitle() + ";" + s.getLengthInMinutes() + "\n");
        }
        bw.close();
    }

    public static ArrayList<Song> readSongsFromFile(String path) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(path));

        br.readLine(); // Skips the header...

        ArrayList<Song> u = new ArrayList<>();

        String l;
        while((l = br.readLine()) != null){
            String[] d = l.split(";");
            u.add(new Song(d[0], d[1], Double.parseDouble(d[2])));
        }
        return u;
    }

    /**
     * Task 6: Create similar reader and writer methods to read and write Note objects.
     */
    public static void writeNotesIntoFile(ArrayList<Note> u, String path) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));

        bw.write("Name;Topic;Text\n");

        for (Note nt : u) {
            bw.write(nt.getName() +";" + nt.getTopic() + ";" + nt.getText() + "\n");
        }
        bw.close();
    }

    public static ArrayList<Note> readNotesFromFile(String path) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(path));

        br.readLine(); // Skips the header...

        ArrayList<Note> u = new ArrayList<>();

        String l;

        while((l = br.readLine()) != null){
            String[] d = l.split(";");
            u.add(new Note(d[0], d[1], d[2]));
        }
        return u;
    }

    /**
     * Task 7: Create similar reader and writer methods to read and write Book objects.
     */

    public static void writeBooksIntoFile(ArrayList<Book> u, String path) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));

        bw.write("Author;Title;Isbn\n");

        for (Book nt : u) {
            bw.write(nt.getAuthor() +";" + nt.getTitle() + ";" + nt.getTitle() + "\n");
        }
        bw.close();
    }

    public static ArrayList<Book> readBooksFromFile(String path) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(path));

        br.readLine(); // Skips the header...

        ArrayList<Book> u = new ArrayList<>();

        String l;

        while((l = br.readLine()) != null){
            String[] d = l.split(";");
            u.add(new Book(d[0], d[1], d[2]));
        }
        return u;
    }

}
