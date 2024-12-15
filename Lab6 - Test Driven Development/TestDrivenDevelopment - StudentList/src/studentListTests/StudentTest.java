package studentListTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import students.Student;

/**
 * Test class for the {@link students.Student} class.
 * This class contains unit tests to validate the behavior of the Student class,
 * ensuring proper functionality of name validation methods.
 */
class StudentTest {

    /**
     * Student instance with a blank name.
     */
    private Student blankName;

    /**
     * Student instance with digits in the name.
     */
    private Student NameWithDigits;

    /**
     * Student instance with special characters in the name.
     */
    private Student nameWithSpecialCharacter;

    /**
     * Student instance with spaces in the name.
     */
    private Student nameWithSpaces;

    /**
     * A valid Student instance.
     */
    private Student student;

    /**
     * Array of Student instances with problematic names for validation tests.
     */
    private Student[] problematicStudentList;

    /**
     * Array of expected results for problematic student validation tests.
     */
    private Boolean[] problematicStudentResultList;

    /**
     * Sets up the test environment before each test.
     * Initializes test data including valid and invalid Student instances.
     *
     * @throws Exception if any error occurs during setup
     */
    @BeforeEach
    void setUp() throws Exception {
        blankName = new Student("");
        NameWithDigits = new Student("5");
        nameWithSpecialCharacter = new Student("Yuv@l");
        nameWithSpaces = new Student("Yu val");
        student = new Student("Yuval");

        problematicStudentList = new Student[]{blankName, NameWithDigits, nameWithSpaces, nameWithSpecialCharacter};
        problematicStudentResultList = new Boolean[]{false, false, false, false};
    }

    /**
     * Tests whether a Student instance with a blank name is correctly identified as blank.
     */
    @Test
    void studentWithBlankNameTest() {
        assertTrue(blankName.getName().isBlank(), "The name should be identified as blank.");
    }

    /**
     * Tests whether a Student instance with digits in the name correctly identifies the digits.
     */
    @Test
    void studentWithDigitsInNameTest() {
        assertTrue(NameWithDigits.isNameContainsDigits(), "The name should contain digits.");
    }

    /**
     * Tests whether a Student instance with spaces in the name correctly identifies the spaces.
     */
    @Test
    void studentWithSpaceInNameTest() {
        assertTrue(nameWithSpaces.isNameContainsSpace(), "The name should contain spaces.");
    }

    /**
     * Tests whether a Student instance with special characters in the name
     * correctly identifies the special characters.
     */
    @Test
    void studentWithSpecialCharacterInNameTest() {
        assertTrue(nameWithSpecialCharacter.isNameContainsSpecialCharacter(),
                "The name should contain special characters.");
    }

    /**
     * Validates the behavior of the {@link students.Student#isNameValid()} method
     * for a list of problematic names, ensuring invalid names are correctly identified.
     */
    @Test
    void isValidTest() {
        Boolean[] resultList = new Boolean[4];
        for (int i = 0; i < problematicStudentList.length; i++) {
            resultList[i] = problematicStudentList[i].isNameValid();
        }

        assertArrayEquals(problematicStudentResultList, resultList,
                "The validation results for problematic names should match the expected results.");
    }

    /**
     * Tests whether a valid Student instance is correctly identified as valid.
     */
    @Test
    void studentNameValid() {
        assertTrue(student.isNameValid(), "The valid student name should pass validation.");
    }
}
