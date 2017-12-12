package com.song.common.resume.vo;

import java.util.Date;

/**
 * Created by 00013708 on 2017/8/6.
 */
public class BasicInfoVo{

        private String name;
        //男，女，搞任何东西，都是要最快的速度开发出来
        private String gender;
        //年龄
        private int age;

        private Date birthday;
        //毕业院校
        private String college;
        //专业
        private String major;
        //毕业日期
        private Date graduationDate;
        //工作年限
        private int workingYears;

        private String phone;

        private String email;
        //籍贯
        private String nativePlace;
        //目前居住地
        private String currentResidence;

        public BasicInfoVo() {
        }

        public BasicInfoVo(String name, String gender, int age, Date birthday, String college, String major, Date graduationDate, int workingYears, String phone, String email, String nativePlace, String currentResidence) {
                this.name = name;
                this.gender = gender;
                this.age = age;
                this.birthday = birthday;
                this.college = college;
                this.major = major;
                this.graduationDate = graduationDate;
                this.workingYears = workingYears;
                this.phone = phone;
                this.email = email;
                this.nativePlace = nativePlace;
                this.currentResidence = currentResidence;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getGender() {
                return gender;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        public Date getBirthday() {
                return birthday;
        }

        public void setBirthday(Date birthday) {
                this.birthday = birthday;
        }

        public String getCollege() {
                return college;
        }

        public void setCollege(String college) {
                this.college = college;
        }

        public String getMajor() {
                return major;
        }

        public void setMajor(String major) {
                this.major = major;
        }

        public Date getGraduationDate() {
                return graduationDate;
        }

        public void setGraduationDate(Date graduationDate) {
                this.graduationDate = graduationDate;
        }

        public int getWorkingYears() {
                return workingYears;
        }

        public void setWorkingYears(int workingYears) {
                this.workingYears = workingYears;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getNativePlace() {
                return nativePlace;
        }

        public void setNativePlace(String nativePlace) {
                this.nativePlace = nativePlace;
        }

        public String getCurrentResidence() {
                return currentResidence;
        }

        public void setCurrentResidence(String currentResidence) {
                this.currentResidence = currentResidence;
        }
}
