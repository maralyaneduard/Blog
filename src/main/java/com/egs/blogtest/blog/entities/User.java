/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egs.blogtest.blog.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author eduardm
 */
@Entity
@Table(name = "User")
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Size(max = 100)
    @Column(name = "userName")
    private String userName;
    
    @Size(max = 15)
    @Column(name = "password")
    private String password;
    
    @Size(max = 50)
    @Column(name = "firstName")
    private String firstName;
    
    @Size(max = 50)
    @Column(name = "lastName")
    private String lastName;
        
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    
    @Column(name = "registeredDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredDate;
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    public User()
    {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

enum Role {
  admin(0),user(1);

  private int role; // price of each apple 

  // Constructor 
  Role(int r) {
    role = r;
  }

  int getPrice() {
    return role;
  }
}
