package com.example.domain;

import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;


@Entity
public class ApplicationUser implements UserDetails {


    @Id
    @GeneratedValue (strategy  = GenerationType.IDENTITY)
    private int id;


    @Column(unique = true)
    private String username;
    @NonNull
    private String password;
    @NonNull
    private  String firstName;
    @NonNull
    private String lastName;
    private String datOfBirth;
    private String bio;

    public ApplicationUser(String username,
                           @NonNull String hashedPassword,
                           @NonNull String firstName,
                           @NonNull String lastName,
                           String datOfBirth,
                           String bio) {
        this.username = username;
        this.password = hashedPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.datOfBirth = datOfBirth;
        this.bio = bio;

    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public String getDatOfBirth() {
        return datOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public ApplicationUser() {

    }

    @OneToMany(mappedBy = "applicationUser")
    Set<Post> posts;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
