package org.example.builder;

import org.example.dto.PlayerUpdateRequestDto;

public class PlayerUpdateRequestDtoBuilder {
    private Integer age;
    private String gender;
    private String login;
    private String password;
    private String role;
    private String screenName;

    public PlayerUpdateRequestDtoBuilder withAge(Integer age) {
        this.age = age;
        return this;
    }

    public PlayerUpdateRequestDtoBuilder withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public PlayerUpdateRequestDtoBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    public PlayerUpdateRequestDtoBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public PlayerUpdateRequestDtoBuilder withRole(String role) {
        this.role = role;
        return this;
    }

    public PlayerUpdateRequestDtoBuilder withScreenName(String screenName) {
        this.screenName = screenName;
        return this;
    }

    public PlayerUpdateRequestDto build() {
        PlayerUpdateRequestDto requestDto = new PlayerUpdateRequestDto();
        requestDto.setAge(age);
        requestDto.setGender(gender);
        requestDto.setLogin(login);
        requestDto.setPassword(password);
        requestDto.setRole(role);
        requestDto.setScreenName(screenName);
        return requestDto;
    }
}
