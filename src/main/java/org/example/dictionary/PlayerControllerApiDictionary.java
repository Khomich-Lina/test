package org.example.dictionary;

import io.restassured.http.Method;
import org.example.dto.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PlayerControllerApiDictionary {

    private static final String BASE_PATH = "/";
    private static String BASE_URL;

    static {
        Properties prop = new Properties();
        try (InputStream input = PlayerControllerApiDictionary.class.getClassLoader().getResourceAsStream("config.properties")) {
            prop.load(input);
            BASE_URL = prop.getProperty("base_url");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static GetAllPlayersApi getAllPlayers() {
        return new GetAllPlayersApi();
    }

    public static CreatePlayerApi createPlayer() {
        return new CreatePlayerApi();
    }

    public static DeletePlayerApi deletePlayer() {
        return new DeletePlayerApi();
    }

    public static GetPlayerByIdApi getPlayerByIdApi() {
        return new GetPlayerByIdApi();
    }

    public static UpdatePlayerApi updatePlayerApi(){
        return new UpdatePlayerApi();
    }

    public static class GetAllPlayersApi extends AbstractApiCall<PlayerGetAllResponseDto, GetAllPlayersApi> {

        private static final String GET_ALL_PLAYERS_PATH = "player/get/all";

        public GetAllPlayersApi() {
            super(PlayerGetAllResponseDto.class);
        }

        @Override
        public Method getMethod() {
            return Method.GET;
        }

        @Override
        public String getBasePath() {
            return BASE_PATH;
        }

        @Override
        public String getPath() {
            return GET_ALL_PLAYERS_PATH;
        }

        @Override
        public String getBaseUri() {
            return BASE_URL;
        }

        @Override
        public GetAllPlayersApi getSelf() {
            return this;
        }
    }

    public static class CreatePlayerApi extends AbstractApiCall<PlayerCreateResponseDto, CreatePlayerApi> {
        private static final String CREATE_PLAYER_PATH = "player/create/{editor}";

        public CreatePlayerApi() {
            super(PlayerCreateResponseDto.class);
        }

        @Override
        public Method getMethod() {
            return Method.GET;
        }

        @Override
        public String getBasePath() {
            return BASE_PATH;
        }

        @Override
        public String getPath() {
            return CREATE_PLAYER_PATH;
        }

        @Override
        public String getBaseUri() {
            return BASE_URL;
        }

        @Override
        public CreatePlayerApi getSelf() {
            return this;
        }

        public CreatePlayerApi withAge(Integer age) {
            withQueryParam("age", age.toString());
            return getSelf();
        }

        public CreatePlayerApi withGender(String gender) {
            withQueryParam("gender", gender);
            return getSelf();
        }

        public CreatePlayerApi withLogin(String login) {
            withQueryParam("login", login);
            return getSelf();
        }

        public CreatePlayerApi withPassword(String password) {
            withQueryParam("password", password);
            return getSelf();
        }

        public CreatePlayerApi withRole(String role) {
            withQueryParam("role", role);
            return getSelf();
        }

        public CreatePlayerApi withScreenName(String screenName) {
            withQueryParam("screenName", screenName);
            return getSelf();
        }

        public CreatePlayerApi withEditor(String editor) {
            withPathParam("editor", editor);
            return getSelf();
        }

    }

    public static class DeletePlayerApi extends AbstractApiCall<ResponseEntityDto, DeletePlayerApi> {
        private static final String DELETE_PLAYER_PATH = "player/delete/{editor}";

        private PlayerDeleteRequestDto requestBody;

        public DeletePlayerApi() {
            super(ResponseEntityDto.class);
        }

        @Override
        public Method getMethod() {
            return Method.DELETE;
        }

        @Override
        public String getBasePath() {
            return BASE_PATH;
        }

        @Override
        public String getPath() {
            return DELETE_PLAYER_PATH;
        }

        @Override
        public String getBaseUri() {
            return BASE_URL;
        }

        @Override
        public DeletePlayerApi getSelf() {
            return this;
        }

        public DeletePlayerApi withEditor(String editor) {
            withPathParam("editor", editor);
            return getSelf();
        }
    }

    public static class GetPlayerByIdApi extends AbstractApiCall<PlayerGetByPlayerIdResponseDto, GetPlayerByIdApi> {

        private static final String GET_PLAYER_PATH = "player/get";

        private Long playerId;

        public GetPlayerByIdApi() {
            super(PlayerGetByPlayerIdResponseDto.class);
        }

        @Override
        public Method getMethod() {
            return Method.POST;
        }

        @Override
        public String getBasePath() {
            return BASE_PATH;
        }

        @Override
        public String getPath() {
            return GET_PLAYER_PATH;
        }

        @Override
        public String getBaseUri() {
            return BASE_URL;
        }

        @Override
        public GetPlayerByIdApi getSelf() {
            return this;
        }

        public GetPlayerByIdApi withPlayerId(Long playerId) {
            this.playerId = playerId;
            return getSelf();
        }
    }

    public static class UpdatePlayerApi extends AbstractApiCall<PlayerUpdateResponseDto, UpdatePlayerApi> {
        private static final String UPDATE_PLAYER_PATH = "player/update/{editor}/{id}";

        private PlayerUpdateRequestDto requestBody;
        private Integer playerId;

        public UpdatePlayerApi() {
            super(PlayerUpdateResponseDto.class);
        }

        @Override
        public Method getMethod() {
            return Method.PATCH;
        }

        @Override
        public String getBasePath() {
            return BASE_PATH;
        }

        @Override
        public String getPath() {
            return UPDATE_PLAYER_PATH;
        }

        @Override
        public String getBaseUri() {
            return BASE_URL;
        }

        @Override
        public UpdatePlayerApi getSelf() {
            return this;
        }

        public UpdatePlayerApi withEditor(String editor) {
            withPathParam("editor", editor);
            return getSelf();
        }

        public UpdatePlayerApi withPlayerId(Integer playerId) {
            this.playerId = playerId;
            return getSelf();
        }
    }


}
