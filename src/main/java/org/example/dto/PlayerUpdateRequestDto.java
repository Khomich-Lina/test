package org.example.dto;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "PlayerUpdateRequestDto")
public class PlayerUpdateRequestDto {

    @SerializedName("age")
    private Integer age;

    @SerializedName("gender")
    private String gender;

    @SerializedName("login")
    private String login;

    @SerializedName("password")
    private String password;

    @SerializedName("role")
    private String role;

    @SerializedName("screenName")
    private String screenName;

    public PlayerUpdateRequestDto age(Integer age) {
        this.age = age;
        return this;
    }

    @ApiModelProperty(value = "")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public PlayerUpdateRequestDto gender(String gender) {
        this.gender = gender;
        return this;
    }

    @ApiModelProperty(value = "")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public PlayerUpdateRequestDto login(String login) {
        this.login = login;
        return this;
    }

    @ApiModelProperty(value = "")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public PlayerUpdateRequestDto password(String password) {
        this.password = password;
        return this;
    }

    @ApiModelProperty(value = "")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PlayerUpdateRequestDto role(String role) {
        this.role = role;
        return this;
    }

    @ApiModelProperty(value = "")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public PlayerUpdateRequestDto screenName(String screenName) {
        this.screenName = screenName;
        return this;
    }

    @ApiModelProperty(value = "")
    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerUpdateRequestDto that = (PlayerUpdateRequestDto) o;
        return Objects.equals(age, that.age) && Objects.equals(gender, that.gender)
                && Objects.equals(login, that.login) && Objects.equals(password, that.password)
                && Objects.equals(role, that.role) && Objects.equals(screenName, that.screenName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, gender, login, password, role, screenName);
    }

    @Override
    public String toString() {
        return "PlayerUpdateRequestDto{" + "age=" + age + ", gender='" + gender + '\'' + ", login='" + login + '\''
                + ", password='" + password + '\'' + ", role='" + role + '\'' + ", screenName='" + screenName + '\''
                + '}';
    }
}
