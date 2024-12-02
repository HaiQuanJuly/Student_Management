import java.util.LinkedList;
class StudentManagementSystem {
    private LinkedList<Student> students;

    public StudentManagementSystem() {
        students = new LinkedList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    // Sort students by mark using Bubble Sort
    public void sortStudentsByMark() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMark() > students.get(j + 1).getMark()) {
                    // Swap students at positions j and j+1
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
        System.out.println("The list of students has been sorted by score.");
    }
    // Display the list of students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("The student list is empty.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
    // Find student by ID
    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
    // Edit student information
    public void editStudent(String id, String newName, double newMark) {
        Student student = findStudentById(id);
        if (student != null) {
            student.setName(newName);
            student.setMark(newMark);
            System.out.println("Student information has been updated.");
        } else {
            System.out.println("No student found with ID: " + id);
        }
    }
    // Delete student
    public void removeStudent(String id) {
        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student with ID " + id + " has been deleted.");
        } else {
            System.out.println("No student found with ID: " + id);
        }
    }
}
