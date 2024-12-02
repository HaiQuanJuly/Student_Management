import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        StudentManagementSystem studentSystem = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\nSelect an option:");
                System.out.println("1. Add students");
                System.out.println("2. Show student list");
                System.out.println("3. Edit student information");
                System.out.println("4. Delete student");
                System.out.println("5. Sort students by score");
                System.out.println("6. Exit");
                int choice = Integer.parseInt(scanner.nextLine()); // Use nextLine and parse int
                if (choice < 1 || choice > 6) {
                    throw new IllegalArgumentException("Invalid selection. Please enter between 1 and 6.");
                }
                switch (choice) {
                    case 1:
                        // Add student
                        System.out.print("Enter student ID: ");
                        String id = scanner.nextLine();

                        String name;
                        while (true) {
                            System.out.print("Enter student name: ");
                            name = scanner.nextLine();
                            if (name.matches("[a-zA-Z ]+")) { // Check if name is a letter
                                break;
                            } else {
                                System.out.println("Error: Name can only contain letters. Please re-enter.");
                            }
                        }
                        double mark = 0;
                        while (true) {
                            try {
                                System.out.print("Enter student scores: ");
                                mark = Double.parseDouble(scanner.nextLine()); // Check input number
                                break; // If there is no error, exit the loop
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Please enter a valid number for points.");
                            }
                        }
                        Student student = new Student(id, name, mark);
                        studentSystem.addStudent(student);
                        break;
                    case 2:
                        // Display the list of students
                        System.out.println("List of students:");
                        studentSystem.displayStudents();
                        break;
                    case 3:
                        // Edit student information
                        System.out.print("Enter the student ID to be edited: ");
                        String editId = scanner.nextLine();
                        String newName;
                        while (true) {
                            System.out.print("Enter new name: ");
                            newName = scanner.nextLine();
                            if (newName.matches("[a-zA-Z ]+")) { // Check if name is a letter
                                break;
                            } else {
                                System.out.println("Error: Name can only contain letters. Please re-enter.");
                            }
                        }
                        double newMark = 0;
                        while (true) {
                            try {
                                System.out.print("Enter new score: ");
                                newMark = Double.parseDouble(scanner.nextLine()); // Check input number
                                break; // If there is no error, exit the loop
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Please enter a valid number for points.");
                            }
                        }
                        studentSystem.editStudent(editId, newName, newMark);
                        break;
                    case 4:
                        // Delete student
                        System.out.print("Enter the student ID to delete: ");
                        String deleteId = scanner.nextLine();
                        studentSystem.removeStudent(deleteId);
                        break;
                    case 5:
                        // Sort students by score
                        studentSystem.sortStudentsByMark();
                        break;
                    case 6:
                        System.out.println("Exit program.");
                        scanner.close();
                        return;
                    default:
                        throw new IllegalArgumentException("Invalid selection. Please enter between 1 and 6.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}