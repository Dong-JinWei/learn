package com.dowei.empsys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor // 表示无参的构造方法
@AllArgsConstructor // 表示有参的构造方法
@Data // 表示set和get方法，toString方法
@EqualsAndHashCode // 生成equals和hashCode方法
public class User implements Serializable {
    private Integer userId;
    private String username;
    private String password;
    private String nickname;


    //public User() {
    //}
    //
    //public User(Integer userId, String username, String password, String nickname) {
    //    this.userId = userId;
    //    this.username = username;
    //    this.password = password;
    //    this.nickname = nickname;
    //}
    //
    //public Integer getUserId() {
    //    return userId;
    //}
    //
    //public void setUserId(Integer userId) {
    //    this.userId = userId;
    //}
    //
    //public String getUsername() {
    //    return username;
    //}
    //
    //public void setUsername(String username) {
    //    this.username = username;
    //}
    //
    //public String getPassword() {
    //    return password;
    //}
    //
    //public void setPassword(String password) {
    //    this.password = password;
    //}
    //
    //public String getNickname() {
    //    return nickname;
    //}
    //
    //public void setNickname(String nickname) {
    //    this.nickname = nickname;
    //}
    //
    //@Override
    //public String toString() {
    //    return "User{" +
    //            "userId=" + userId +
    //            ", username='" + username + '\'' +
    //            ", password='" + password + '\'' +
    //            ", nickname='" + nickname + '\'' +
    //            '}';
    //}
}
