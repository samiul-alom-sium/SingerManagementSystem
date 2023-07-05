package com.singer.singer.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "singer")
public class Singer implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id; 
    
    @Version
    @Column(name = "VERSION")
    private int version;
    
    @NotBlank(message = "{validation.firstName.NotBlank.message}")
    @Size(min = 2, max = 60, message = "{validation.firstName.Size.message}")
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @NotBlank(message = "{validation.lastName.NotBlank.message}")
    @Size(min = 1, max = 40, message = "{validation.lastName.Size.message}")
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "PHOTO")
    private byte[] photo;
    
    // create getter and setter for id
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    // create getter and setter for version
    public int getVersion(){
        return version;
    }
    
    public void setVersion(int version){
        this.version = version;
    }
    
    // create getter and setter for firstName
    public String getFirstName(){
        return firstName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    // create lastName
    public String getLastName(){
        return lastName; 
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    // create getter method for birthDate
    public Date getBirthDate(){
        return birthDate;
    }
    
    // create getter and setter for description
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    // create getter and setter for photo
    public byte[] getPhoto(){
        return photo;
    }
    
    public void setPhoto(byte[] photo){
        this.photo = photo;
    }   
    
    @Transient
    public String getBirthDateString(){
        String birthDateString = "";
        if(birthDateString != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            birthDateString = sdf.format(birthDate);
        }
        return birthDateString;
    }
    
    // create toString() method for singer
    @Override
    public String toString(){
        return "Singer - id: " + id + ", firstName: " + firstName + 
                ", lastName: " + lastName + ", birthDay: " + birthDate +
                ", description: " + description;
    }

    public void setBirthDate(Date date) {
        this.birthDate = date;
    }
}