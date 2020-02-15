package ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
    @NotNull(message = "First Name should not be Empty")
    @Size(min = 2,message = "First Name at least 2 character")
    private  String firstName;

    @NotNull(message = "Last Name should not be Empty")
    @Size(min = 2,message = "Last Name at least 2 character")
    private String lastName;

    @NotNull(message = "Email should not be Empty")
    @Email(message = "Email should be Valid")
    private String  email;

    @NotNull(message = "Password should not be Empty")
    @Size(min = 8,max = 16,message = "Password should not be less than 8 and greater than 16")
    private String password;

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

    public String getEmail() {
        return email;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
