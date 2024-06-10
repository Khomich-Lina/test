package org.example.mapper;

import org.example.dto.PlayerCreateResponseDto;
import org.example.factory.PlayerModel;

public class PlayerMapper {

    public static PlayerModel mapToPlayerModel(PlayerCreateResponseDto playerResponse) {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setAge(playerResponse.getAge());
        playerModel.setGender(playerResponse.getGender());
        playerModel.setLogin(playerResponse.getLogin());
        playerModel.setPassword(playerResponse.getPassword());
        playerModel.setRole(playerResponse.getRole());
        playerModel.setScreenName(playerResponse.getScreenName());
        return playerModel;
    }

    public static PlayerCreateResponseDto mapToPlayerResponse(PlayerModel playerModel) {
        PlayerCreateResponseDto playerResponse = new PlayerCreateResponseDto();
        playerResponse.setAge(playerModel.getAge());
        playerResponse.setGender(playerModel.getGender());
        playerResponse.setLogin(playerModel.getLogin());
        playerResponse.setPassword(playerModel.getPassword());
        playerResponse.setRole(playerModel.getRole());
        playerResponse.setScreenName(playerModel.getScreenName());
        return playerResponse;
    }
}
