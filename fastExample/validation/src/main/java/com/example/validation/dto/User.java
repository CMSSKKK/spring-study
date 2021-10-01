package com.example.validation.dto;

import com.example.validation.annotation.YearMonth;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
    @NotBlank
    private String name;
    @Min(value = 1)
    private int age;
    @Email
    private String email;
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$",message = "휴대전화 번호의 양식과 맞지 않습니다. 01x-xxxx-xxxx")
    private String phoneNumber;
    @YearMonth
    private String reqYearMonth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReqYearMonth() {
        return reqYearMonth;
    }

    public void setReqYearMonth(String reqYearMonth) {
        this.reqYearMonth = reqYearMonth;
    }

//    @AssertTrue(message = "yyyyMM 형식에 맞지 않습니다.")
//    public boolean isReqYearMonthValidation(){ // AssertTrue 메서드는 'is'로 시작해야한다.
//        try{
//            LocalDate localDate = LocalDate.parse(getReqYearMonth()+"01", DateTimeFormatter.ofPattern("yyyyMMdd"));
//        } catch(Exception e){
//            return false;
//        }
//        return true;
//    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", reqYearMonth='" + reqYearMonth + '\'' +
                '}';
    }
}
