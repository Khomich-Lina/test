package org.example.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class PlayerItemDto {
    @SerializedName("age")
    private Integer age;

    @SerializedName("gender")
    private String gender;

    @SerializedName("id")
    private Integer id;

    @SerializedName("role")
    private String role;

    @SerializedName("screenName")
    private String screenName;

    @Nullable // Use jakarta.annotation.Nullable instead of javax.annotation.Nullable
    @ApiModelProperty(value = "Player's age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Nullable // Use jakarta.annotation.Nullable instead of javax.annotation.Nullable
    @ApiModelProperty(value = "Player's gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Nullable // Use jakarta.annotation.Nullable instead of javax.annotation.Nullable
    @ApiModelProperty(value = "Player's ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Nullable // Use jakarta.annotation.Nullable instead of javax.annotation.Nullable
    @ApiModelProperty(value = "Player's role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Nullable // Use jakarta.annotation.Nullable instead of javax.annotation.Nullable
    @ApiModelProperty(value = "Player's screen name")
    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerItemDto that = (PlayerItemDto) o;
        return Objects.equals(age, that.age) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(id, that.id) &&
                Objects.equals(role, that.role) &&
                Objects.equals(screenName, that.screenName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, gender, id, role, screenName);
    }

    @Override
    public String toString() {
        return "PlayerItemDTO{" +
                "age=" + age +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                ", role='" + role + '\'' +
                ", screenName='" + screenName + '\'' +
                '}';
    }
}
