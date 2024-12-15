package studentListTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import students.Student;
import students.StudentList;

/**
 * Test class for the {@link students.StudentList} class.
 * Contains unit tests to verify the functionality of managing a list of students.
 */
class StudentListTest {

    /**
     * A sample student used in tests.
     */
    private Student student;

    /**
     * A second sample student used in tests.
     */
    private Student secondStudent;

    /**
     * An ArrayList used for initializing StudentList instances.
     */
    private ArrayList<Student> list;

    /**
     * A {@link students.StudentList} instance with no students.
     */
    private StudentList listWithNoStudents;

    /**
     * A {@link students.StudentList} instance initialized with one student.
     */
    private StudentList listWithOneStudent;

    /**
     * Sets up the test environment before each test.
     * Initializes sample Student instances and StudentList instances with different configurations.
     *
     * @throws Exception if any error occurs during setup
     */
    @BeforeEach
    void setUp() throws Exception {
        student = new Student("Yuval");
        secondStudent = new Student("Daniel");

        listWithNoStudents = new StudentList();
        list = new ArrayList<>();

        listWithOneStudent = new StudentList(list);
        listWithOneStudent.addStudent(student);
    }

    /**
     * Tests that removing a student from an empty list fails.
     */
    @Test
    void removeFromEmptyListTest() {
        assertFalse(listWithNoStudents.removeStudentFromStudentList(student), 
            "Removing a student from an empty list should return false.");
    }

    /**
     * Tests successfully removing a student from the list after adding them.
     */
    @Test
    void removeFromEmptyListTestSuccess() {
        listWithNoStudents.addStudent(student);
        assertTrue(listWithNoStudents.removeStudentFromStudentList(student), 
            "Removing a student after adding them to an empty list should return true.");
    }

    /**
     * Tests that removing a student who is not in the list fails.
     */
    @Test
    void removeStudentFromListFail() {
        assertFalse(listWithOneStudent.removeStudentFromStudentList(secondStudent), 
            "Removing a student who is not in the list should return false.");
    }

    /**
     * Tests that a student is correctly identified as being in the list.
     */
    @Test
    void isStudentInListTestSuccess() {
        assertTrue(listWithOneStudent.isStudentInList(student), 
            "A student in the list should be identified as present.");
    }

    /**
     * Tests that adding a student who is already in the list fails.
     */
    @Test
    void addStudentFailStudentInList() {
        assertFalse(listWithOneStudent.addStudent(student), 
            "Adding a student who is already in the list should return false.");
    }

    /**
     * Tests successfully adding a student to the list.
     */
    @Test
    void addStudentSucceess() {
        assertTrue(listWithOneStudent.addStudent(secondStudent), 
            "Adding a student not already in the list should return true.");
    }

    /**
     * Tests successfully editing a student in the list.
     */
    @Test
    void editStudentInListSuccess() {
        assertTrue(listWithOneStudent.editStudentInStudentList(student, secondStudent), 
            "Editing a student in the list should return true.");
    }

    /**
     * Tests that editing a student not found in the list fails.
     */
    @Test
    void editStudentInListFailStudentNotFound() {
        assertFalse(listWithOneStudent.editStudentInStudentList(secondStudent, student), 
            "Editing a student not found in the list should return false.");
    }
}
