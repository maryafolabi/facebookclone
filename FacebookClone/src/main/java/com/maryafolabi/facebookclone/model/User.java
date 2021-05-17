package com.maryafolabi.facebookclone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    private String password;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    private String gender;

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", fullName='" + fullName + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", dateOfBirth='" + dateOfBirth + '\'' +
//                ", gender='" + gender + '\'' +
//                '}';
 //   }
}