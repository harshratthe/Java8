package com.java.Bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Accounts {
   private int accountno;
   private String firstname;
   private String lastname;
   private String city;
   private String state;
   private Double amount;
   private String cheqfacil;
   private String accountype;
   
   

}
