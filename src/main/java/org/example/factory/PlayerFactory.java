package org.example.factory;

import org.example.api.PlayersServiceApi;
import org.example.constants.Gender;
import org.example.constants.Role;
import org.example.dto.PlayerCreateResponseDto;

import java.util.Random;

import static org.apache.http.HttpStatus.SC_OK;

public class PlayerFactory {

    public static PlayerCreateResponseDto createRandomPlayer(Role role, Role editor) {
        PlayerModel playerModel = generateRandomPlayerModelWithRole(role);
        return PlayersServiceApi.createPlayer(SC_OK, playerModel, editor);
    }

    public static PlayerCreateResponseDto createPlayerWithSpecificAge(int age, Role playerRole, Role editorRole) {
        Random random = new Random();
        PlayerModel playerModel = generateRandomPlayerModelWithRole(playerRole);
        playerModel.setAge(age);
        playerModel.setGender(random.nextBoolean() ? Gender.FEMALE.getValue() : Gender.MALE.getValue());
        playerModel.setLogin(generateRandomString(8));
        playerModel.setScreenName(generateRandomString(10));
        playerModel.setPassword(generateRandomPassword());
        playerModel.setRole(playerRole.getValue());
        return PlayersServiceApi.createPlayer(SC_OK, playerModel, editorRole);
    }

    public static PlayerModel generateRandomPlayerModelWithRole(Role role) {
        Random random = new Random();
        PlayerModel playerModel = new PlayerModel();
        playerModel.setAge(16 + random.nextInt(45));
        playerModel.setGender(random.nextBoolean() ? Gender.FEMALE.getValue() : Gender.MALE.getValue());
        playerModel.setLogin(generateRandomString(8));
        playerModel.setScreenName(generateRandomString(10));
        playerModel.setPassword(generateRandomPassword());
        playerModel.setRole(role.getValue());
        return playerModel;
    }

    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    private static String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 7 + random.nextInt(9);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
}
