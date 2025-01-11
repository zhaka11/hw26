package org.example;

public class Actor {
    private String fullName;
    private String role;

    public String getFullName() { return fullName; }
    public String getRole() { return role; }

    @Override
    public String toString() {
        return String.format("%s (%s)", fullName, role);
    }
}
