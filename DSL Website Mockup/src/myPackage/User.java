package myPackage;

public class User {
    String PASS;

    // Getters and setters are not required for this example.
    // GSON sets the fields directly using reflection.

    @Override
    public String toString() {
        return PASS;
    }
}