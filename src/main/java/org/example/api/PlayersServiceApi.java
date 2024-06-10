package org.example.api;

import io.restassured.response.Response;
import org.example.builder.PlayerDeleteRequestDtoBuilder;
import org.example.builder.PlayerGetByPlayerIdRequestDtoBuilder;
import org.example.builder.PlayerUpdateRequestDtoBuilder;
import org.example.constants.Role;
import org.example.dictionary.PlayerControllerApiDictionary;
import org.example.dto.*;
import org.example.factory.PlayerModel;

public class PlayersServiceApi {

    public static PlayerGetAllResponseDto getAllPlayers(int status) {
        return PlayerControllerApiDictionary.getAllPlayers()
                .withExpectedStatusCode(status)
                .executeWithResponseAs(PlayerGetAllResponseDto.class);
    }

    public static PlayerCreateResponseDto createPlayer (int status, PlayerModel player, Role role){
        return PlayerControllerApiDictionary.createPlayer()
                .withAge(player.getAge())
                .withGender(player.getGender())
                .withLogin(player.getLogin())
                .withPassword(player.getPassword())
                .withRole(player.getRole())
                .withScreenName(player.getScreenName())
                .withEditor(role.getValue())
                .withExpectedStatusCode(status)
                .executeWithResponseAs(PlayerCreateResponseDto.class);
    }

    public static ResponseEntityDto deletePlayer(int status, Integer playerId, Role editor) {
        Response response = PlayerControllerApiDictionary.deletePlayer()
                .withEditor(editor.getValue())
                .withBody(new PlayerDeleteRequestDtoBuilder().withPlayerId(playerId).build())
                .withExpectedStatusCode(status)
                .execute();

        if (response.getStatusCode() == 204 || response.getBody().asString().isEmpty()) {
            return new ResponseEntityDto();
        }

        return response.as(ResponseEntityDto.class);
    }

    public static PlayerGetByPlayerIdResponseDto playerGetByPlayerId(int status, Integer playerId) {
        return PlayerControllerApiDictionary.getPlayerByIdApi()
                .withBody(new PlayerGetByPlayerIdRequestDtoBuilder().withPlayerId(playerId).build())
                .withExpectedStatusCode(status)
                .executeWithResponseAs(PlayerGetByPlayerIdResponseDto.class);
    }

    public static PlayerUpdateResponseDto playerUpdate (int status, PlayerModel player,  Role editor){
        return PlayerControllerApiDictionary.updatePlayerApi()
                .withEditor(editor.getValue())
                .withPlayerId(player.getId())
                .withBody(new PlayerUpdateRequestDtoBuilder()
                        .withAge(player.getAge())
                        .withGender(player.getGender())
                        .withLogin(player.getLogin())
                        .withPassword(player.getPassword())
                        .withScreenName(player.getScreenName()))
                .withExpectedStatusCode(status)
                .executeWithResponseAs(PlayerUpdateResponseDto.class);
    }

}