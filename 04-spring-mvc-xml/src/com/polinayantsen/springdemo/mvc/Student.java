package com.polinayantsen.springdemo.mvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favouriteLanguage;
    private LinkedHashMap<String, String> favouriteLanguageOptions;
    private String[] operatingSystems;

//    private LinkedHashMap<String, String> countryOptions;

    public Student() {
//        countryOptions = new LinkedHashMap<>();
//        countryOptions.put("CA", "Canada");
//        countryOptions.put("IC", "Iceland");
//        countryOptions.put("NZ", "New Zealand");
//        countryOptions.put("GB", "Great Britain");
//        countryOptions.put("US", "United States");
        favouriteLanguageOptions = new LinkedHashMap<>();
        favouriteLanguageOptions.put("C#", "C#");
        favouriteLanguageOptions.put("C++", "C++");
        favouriteLanguageOptions.put("Java", "Java");
        favouriteLanguageOptions.put("Python", "Python");
        favouriteLanguageOptions.put("Pascal", "Pascal");
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

    public LinkedHashMap<String, String> getFavouriteLanguageOptions() {
        return favouriteLanguageOptions;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

//    public LinkedHashMap<String, String> getCountryOptions() {
//        return countryOptions;
//    }
}
