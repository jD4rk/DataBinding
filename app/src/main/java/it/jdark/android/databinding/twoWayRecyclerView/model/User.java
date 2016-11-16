package it.jdark.android.databinding.twoWayRecyclerView.model;

/**
 * Created on 18/04/16.
 *
 * @Autor jDark
 */
public class User {

    private String firstName;
    private String lastName;


    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
