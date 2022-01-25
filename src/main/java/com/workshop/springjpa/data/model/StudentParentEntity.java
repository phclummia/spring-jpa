package com.workshop.springjpa.data.model;


import lombok.*;

import javax.persistence.*;

@Entity(name = "StudentParentEntity")
@Table(name = "student_parent_entity")
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter
@Getter
public class StudentParentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 80)
    private String name;
    @Column(name = "surname", nullable = false, length = 80)
    private String surname;
    @Column(name = "mail_address", nullable = false, length = 160)
    private String mailAddress;

    @OneToOne
    private StudentInformationEntity studentInformation;


}
