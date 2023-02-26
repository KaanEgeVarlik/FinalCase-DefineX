package com.kaanege.definex.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDate bornDate;
    String fullName;
    BigDecimal income;
    String phoneNumber;
    String ssn;//social security number __ T.C. kimlik numarası
    boolean result = false;
    int creditScore;
    BigDecimal deposit;//teminat
    BigDecimal creditLimit;


}
