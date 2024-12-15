package students;

/**
 * Represents a student with a name and provides methods to validate the name
 * based on specific criteria such as the presence of digits, spaces, or special characters.
 */
public class Student {
    /**
     * The name of the student.
     */
    private String name;

    /**
     * Constructs a new {@code Student} object with the specified name.
     * 
     * @param name the name of the student
     */
    public Student(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the student.
     * 
     * @return the name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * Validates the student's name by checking for blank spaces, digits, special characters, or spaces.
     * Prints messages indicating the specific validation failure.
     * 
     * @return {@code true} if the name is valid, {@code false} otherwise
     */
    public boolean isNameValid() {
        if (name.isBlank()) {
            System.out.println("The name of the student is empty.\n");
            return false;
        } else if (isNameContainsDigits()) {
            System.out.println("The name contains digits.\n");
            return false;
        } else if (isNameContainsSpace()) {
            System.out.println("The name has space in it.\n");
            return false;
        } else if (isNameContainsSpecialCharacter()) {
            System.out.println("The name has special characters in it.\n");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if the name contains any digits.
     * 
     * @return {@code true} if the name contains digits, {@code false} otherwise
     */
    public boolean isNameContainsDigits() {
        int numberASCIILowerBoundry = 48; // ASCII value of '0'
        int numberASCIIHighBoundry = 57; // ASCII value of '9'

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) >= numberASCIILowerBoundry && name.charAt(i) <= numberASCIIHighBoundry) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the name contains any spaces.
     * 
     * @return {@code true} if the name contains spaces, {@code false} otherwise
     */
    public boolean isNameContainsSpace() {
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the name contains any special characters.
     * 
     * @return {@code true} if the name contains special characters, {@code false} otherwise
     */
    public boolean isNameContainsSpecialCharacter() {
        char[] specialCharacterList = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+', '_', '=',
                '~', '`', '\'', '{', '}', '[', ']', '"', ',', '<', '>', '.', '/', '\\'};

        for (int i = 0; i < name.length(); i++) {
            for (int j = 0; j < specialCharacterList.length; j++) {
                if (name.charAt(i) == specialCharacterList[j]) {
                    return true; // Found a special character.
                }
            }
        }

        return false;
    }
}
