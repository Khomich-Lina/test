package org.example.dto;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "PlayerUpdateResponseDto")
public class PlayerUpdateResponseDto {

    @SerializedName("age")
    private Integer age;

    @SerializedName("gender")
    private String gender;

    @SerializedName("id")
    private Long id;

    @SerializedName("login")
    private String login;

    @SerializedName("role")
    private String role;

    @SerializedName("screenName")
    private String screenName;

    public PlayerUpdateResponseDto age(Integer age) {
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

    public PlayerUpdateResponseDto gender(String gender) {
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

    public PlayerUpdateResponseDto id(Long id) {
        this.id = id;
        return this;
    }

    @ApiModelProperty(value = "")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerUpdateResponseDto login(String login) {
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

    public PlayerUpdateResponseDto role(String role) {
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

    public PlayerUpdateResponseDto screenName(String screenName) {
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
        PlayerUpdateResponseDto that = (PlayerUpdateResponseDto) o;
        return Objects.equals(age, that.age) && Objects.equals(gender, that.gender)
                && Objects.equals(id, that.id) && Objects.equals(login, that.login)
                && Objects.equals(role, that.role) && Objects.equals(screenName, that.screenName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, gender, id, login, role, screenName);
    }

    @Override
    public String toString() {
        return "PlayerUpdateResponseDto{" + "age=" + age + ", gender='" + gender + '\''
                + ", id=" + id + ", login='" + login + '\'' + ", role='" + role + '\''
                + ", screenName='" + screenName + '\'' + '}';
    }
}
