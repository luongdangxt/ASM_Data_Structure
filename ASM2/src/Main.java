import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tự động chọn ADT dựa trên tình hình
        Object manager = chooseADT();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add student");
            System.out.println("2. Edit student information");
            System.out.println("3. Delete student");
            System.out.println("4. Print student list");
            System.out.println("5. Sort students by score (low to high)");
            System.out.println("6. Sort students by score (high to low)");
            System.out.println("7. Search student by ID");
            System.out.println("8. Search student by score (Binary Search)");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");

            int action = 0;
            try {
                action = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            switch (action) {
                case 1:
                    // Add student
                    String id;
                    while (true) {
                        System.out.print("Enter student ID (must contain both letters and numbers, no special characters): ");
                        id = scanner.nextLine();
                        if (isValidID(id)) {
                            break;
                        } else {
                            System.out.println("Error: ID must contain at least one letter and one number.");
                        }
                    }

                    String name;
                    while (true) {
                        System.out.print("Enter student name: ");
                        name = scanner.nextLine();
                        if (isValidName(name)) {
                            break;
                        } else {
                            System.out.println("Error: Name must contain only letters.");
                        }
                    }

                    double marks = 0;
                    while (true) {
                        try {
                            System.out.print("Enter student score (0-10): ");
                            marks = scanner.nextDouble();
                            scanner.nextLine();
                            if (marks >= 0 && marks <= 10) {
                                break;
                            } else {
                                System.out.println("Error: Score must be between 0 and 10.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Please enter a valid number.");
                            scanner.nextLine();
                        }
                    }

                    if (manager instanceof StudentLinkedList) {
                        ((StudentLinkedList) manager).addStudent(new Student(id, name, marks));
                    } else {
                        ((StudentArrayList) manager).addStudent(new Student(id, name, marks));
                    }
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    // Edit student information
                    System.out.print("Enter student ID to edit: ");
                    String editId = scanner.nextLine();
                    Student editStudent = null;

                    if (manager instanceof StudentLinkedList) {
                        editStudent = ((StudentLinkedList) manager).searchStudent(editId);
                    } else {
                        editStudent = ((StudentArrayList) manager).searchStudent(editId);
                    }

                    if (editStudent != null) {
                        // Edit name
                        String newName;
                        while (true) {
                            System.out.print("Enter new name (current: " + editStudent.name + "): ");
                            newName = scanner.nextLine();
                            if (isValidName(newName)) {
                                break;
                            } else {
                                System.out.println("Error: Name must contain only letters.");
                            }
                        }

                        // Edit score
                        double newMarks = 0;
                        while (true) {
                            try {
                                System.out.print("Enter new score (current: " + editStudent.marks + "): ");
                                newMarks = scanner.nextDouble();
                                scanner.nextLine();
                                if (newMarks >= 0 && newMarks <= 10) {
                                    break;
                                } else {
                                    System.out.println("Error: Score must be between 0 and 10.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Please enter a valid number.");
                                scanner.nextLine();
                            }
                        }

                        // Update student
                        if (manager instanceof StudentLinkedList) {
                            ((StudentLinkedList) manager).updateStudent(editId, newName, newMarks);
                        } else {
                            ((StudentArrayList) manager).updateStudent(editId, newName, newMarks);
                        }
                        System.out.println("Student information updated successfully.");
                    } else {
                        System.out.println("Error: Student with ID " + editId + " not found.");
                    }
                    break;

                case 3:
                    // Delete student
                    System.out.print("Enter student ID to delete: ");
                    String delId = scanner.nextLine();
                    if (manager instanceof StudentLinkedList) {
                        ((StudentLinkedList) manager).deleteStudent(delId);
                    } else {
                        ((StudentArrayList) manager).deleteStudent(delId);
                    }
                    System.out.println("Student deleted successfully (if existed).");
                    break;

                case 4:
                    // Print student list
                    System.out.println("\nStudent List:");
                    if (manager instanceof StudentLinkedList) {
                        ((StudentLinkedList) manager).printStudents();
                    } else {
                        ((StudentArrayList) manager).printStudents();
                    }
                    break;

                case 5:
                    // Sort students by score (low to high)
                    if (manager instanceof StudentLinkedList) {
                        ((StudentLinkedList) manager).sortStudentsByMarks();
                    } else {
                        ((StudentArrayList) manager).sortStudentsByMarks();
                    }
                    System.out.println("Students sorted by score (low to high).");
                    break;

                case 6:
                    // Sort students by score (high to low)
                    if (manager instanceof StudentLinkedList) {
                        ((StudentLinkedList) manager).quickSortStudentsByMarks();
                    } else {
                        ((StudentArrayList) manager).quickSortStudentsByMarks();
                    }
                    System.out.println("Students sorted by score (high to low).");
                    break;

                case 7:
                    // Search student by ID
                    System.out.print("Enter student ID to search: ");
                    String searchId = scanner.nextLine();
                    Student result;
                    if (manager instanceof StudentLinkedList) {
                        result = ((StudentLinkedList) manager).searchStudent(searchId);
                    } else {
                        result = ((StudentArrayList) manager).searchStudent(searchId);
                    }
                    if (result != null) {
                        System.out.println("Student found: " + result);
                    } else {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;

                case 8:
                    // Binary search by score
                    if (manager instanceof StudentLinkedList) {
                        System.out.println("Error: Binary Search is not available for LinkedList.");
                    } else {
                        System.out.print("Enter score to search: ");
                        double searchMarks = 0;
                        try {
                            searchMarks = scanner.nextDouble();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Please enter a valid number.");
                            scanner.nextLine();
                            continue;
                        }
                        Student binaryResult = ((StudentArrayList) manager).binarySearchStudentByMarks(searchMarks);
                        if (binaryResult != null) {
                            System.out.println("Student found: " + binaryResult);
                        } else {
                            System.out.println("No student found with score " + searchMarks + ".");
                        }
                    }
                    break;

                case 9:
                    // Exit
                    scanner.close();
                    System.out.println("Exiting program. Goodbye!");
                    return;

                default:
                    System.out.println("Error: Invalid option. Please try again.");
            }
        }
    }

    // Method to automatically choose ADT
    public static Object chooseADT() {
        int initialStudentCount = 50;

        if (initialStudentCount > 100) {
            return new StudentArrayList();
        } else {
            return new StudentLinkedList();
        }
    }

    // Method to validate ID using Regex
    public static boolean isValidID(String id) {
        String regex = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$";
        return Pattern.matches(regex, id);
    }

    // Method to validate name
    // Method to validate name (including Vietnamese characters)
    public static boolean isValidName(String name) {
        String regex = "^[\\p{L}\\s]+$";
        return Pattern.matches(regex, name);
    }
}