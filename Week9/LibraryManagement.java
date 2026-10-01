import java.sql.*;
import java.util.Scanner;

public class LibraryManagement {

    static final String URL =
        "jdbc:mysql://localhost:3306/librarydb";

    static final String USER = "root";

    static final String PASSWORD =
        "Darrang10@";

    // 1. INSERT BOOK
    static void insertBook() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con =
                DriverManager.getConnection(
                    URL, USER, PASSWORD
                );

            String sql =
                "INSERT INTO Book VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps =
                con.prepareStatement(sql);

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setDouble(4, price);

            // New book is available
            ps.setBoolean(5, true);

            ps.executeUpdate();

            System.out.println(
                "Book inserted successfully."
            );

            con.close();

        } catch (SQLException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }

    // 2. SEARCH BOOK
    static void searchBook() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con =
                DriverManager.getConnection(
                    URL, USER, PASSWORD
                );

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();

            String sql =
                "SELECT * FROM Book WHERE BookID = ?";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs =
                ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                    "\nBook ID: " +
                    rs.getInt("BookID")
                );

                System.out.println(
                    "Title: " +
                    rs.getString("Title")
                );

                System.out.println(
                    "Author: " +
                    rs.getString("Author")
                );

                System.out.println(
                    "Price: " +
                    rs.getDouble("Price")
                );

                System.out.println(
                    "Availability: " +
                    rs.getBoolean("Availability")
                );

            } else {

                System.out.println(
                    "Book not found."
                );
            }

            con.close();

        } catch (SQLException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }

    // 3. DISPLAY AVAILABLE BOOKS
    static void displayAvailableBooks() {

        try {

            Connection con =
                DriverManager.getConnection(
                    URL, USER, PASSWORD
                );

            String sql =
                "SELECT * FROM Book " +
                "WHERE Availability = TRUE";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ResultSet rs =
                ps.executeQuery();

            System.out.println(
                "\nAvailable Books:"
            );

            while (rs.next()) {

                System.out.println(
                    rs.getInt("BookID") + " | " +
                    rs.getString("Title") + " | " +
                    rs.getString("Author") + " | " +
                    rs.getDouble("Price")
                );
            }

            con.close();

        } catch (SQLException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }

    // 4. ISSUE BOOK
    static void issueBook() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con =
                DriverManager.getConnection(
                    URL, USER, PASSWORD
                );

            System.out.print("Enter Book ID to issue: ");
            int id = sc.nextInt();

            String sql =
                "UPDATE Book SET Availability = FALSE " +
                "WHERE BookID = ?";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows =
                ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                    "Book issued successfully."
                );

            } else {

                System.out.println(
                    "Book not found."
                );
            }

            con.close();

        } catch (SQLException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }

    // MAIN
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println(
                "\n===== LIBRARY MANAGEMENT ====="
            );

            System.out.println("1. Insert Book");
            System.out.println("2. Search Book");
            System.out.println("3. Display Available Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    insertBook();
                    break;

                case 2:
                    searchBook();
                    break;

                case 3:
                    displayAvailableBooks();
                    break;

                case 4:
                    issueBook();
                    break;

                case 5:
                    System.out.println(
                        "Program ended."
                    );
                    System.exit(0);

                default:
                    System.out.println(
                        "Invalid choice."
                    );
            }
        }
    }
}