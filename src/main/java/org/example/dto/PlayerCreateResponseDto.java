package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerCreateResponseDto {
    @ApiModelProperty(value = "Age of the player")
    private Integer age;

    @ApiModelProperty(value = "Gender of the player")
    private String gender;

    @ApiModelProperty(value = "ID of the player")
    private Integer id;

    @ApiModelProperty(value = "Login of the player")
    private String login;

    @ApiModelProperty(value = "Password of the player")
    private String password;

    @ApiModelProperty(value = "Role of the player")
    private String role;

    @ApiModelProperty(value = "Screen name of the player")
    private String screenName;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }
}
