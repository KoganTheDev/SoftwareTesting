package students;

import java.util.ArrayList;

/**
 * Represents a list of students with methods to add, remove, and validate student entries.
 * <p>
 * This class enforces the uniqueness of student names in the list. It provides operations
 * to manage and validate the list, ensuring no duplicate entries exist.
 */
public class StudentList {
    /**
     * A list of students. This list enforces unique student names and does not allow duplicates.
     */
    private ArrayList<Student> studentList;

    /**
     * Constructs an empty StudentList.
     */
    public StudentList() {
        studentList = new ArrayList<>();
    }

    /**
     * Constructs a StudentList with the provided list of students.
     * 
     * @param studentList an {@code ArrayList} of students to initialize the list
     */
    public StudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * Adds a new student to the list if they are not already present.
     * 
     * @param student the student to be added to the list. Must not be {@code null}.
     * @return {@code true} if the student was successfully added; 
     *         {@code false} if the student is already in the list or if an exception occurred
     */
    public boolean addStudent(Student student) {
        if (isStudentInList(student)) {
            System.out.println(student.getName() + " is already in the list.");
            return false;
        }
        try {
            studentList.add(student);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Checks if a student is already in the list.
     * 
     * @param student the student to check for presence in the list. Must not be {@code null}.
     * @return {@code true} if the student is in the list; {@code false} otherwise
     */
    public boolean isStudentInList(Student student) {
        for (Student studentInList : studentList) {
            if (studentInList.getName().equals(student.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes a student from the list.
     * 
     * @param student the student to remove. Must not be {@code null}.
     * @return {@code true} if the student was successfully removed; {@code false} otherwise
     */
    public boolean removeStudentFromStudentList(Student student) {
        if (isStudentInList(student)) {
            try {
                studentList.remove(student);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Edits a student by replacing the specified old student with a new student.
     * 
     * @param oldStudent the student to be replaced. Must exist in the list.
     * @param newStudent the student to replace the old student. Must not be {@code null}.
     * @return {@code true} if the student was successfully updated; {@code false} otherwise
     */
    public boolean editStudentInStudentList(Student oldStudent, Student newStudent) {
        if (!isStudentInList(oldStudent)) {
            return false;
        }

        // Replace the old student in the list
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().equals(oldStudent.getName())) {
                studentList.set(i, newStudent);
                return true;
            }
        }

        return false;
    }

    /**
     * Retrieves all students in the list.
     * 
     * @return an {@code ArrayList} containing all students in the list
     */
    public ArrayList<Student> getStudents() {
        return new ArrayList<>(studentList); // Return a copy to protect internal list integrity
    }
}
