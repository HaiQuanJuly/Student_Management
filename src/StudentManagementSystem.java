import java.util.ArrayList;

class StudentManagementSystem {
    private ArrayList<Student> students;
    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student binarySearch(ArrayList<Student> students, String id) {
        int left = 0;
        int right = students.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (students.get(mid).getId().equals(id)) {
                return students.get(mid);
            }
            if (students.get(mid).getId().compareTo(id) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
// Sort students by mark using Bubble Sort
    public void sortStudentsByMark() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMark() > students.get(j + 1).getMark()) {
                    // Hoán đổi sinh viên ở vị trí j và j+1
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
            System.out.println("Students with ID " + id + " has been deleted.");
        } else {
            System.out.println("No student found with ID: " + id);
        }
    }

    public void sortStudentsByIdSelection() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (students.get(j).getId().compareTo(students.get(minIndex).getId()) < 0) {
                    minIndex = j;  // Cập nhật chỉ số của ID nhỏ nhất
                }
            }
            // Hoán đổi sinh viên ở vị trí i và minIndex
            if (minIndex != i) {
                Student temp = students.get(i);
                students.set(i, students.get(minIndex));
                students.set(minIndex, temp);
            }
        }
        System.out.println("The list of students has been sorted by ID using Selection Sort.");
        displayStudents();  // Hiển thị danh sách sau khi sắp xếp
    }

}