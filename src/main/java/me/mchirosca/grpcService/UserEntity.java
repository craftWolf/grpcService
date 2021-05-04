package me.mchirosca.grpcService;


import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name = "users")
public class UserEntity {

    @Id
    String email;
    String firstName;
    String lastName;
    String address;

    public UserEntity(String _email, String _firstName, String _lastName, String _address) {
        this.email = _email;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.address = _address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
