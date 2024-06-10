package org.example.builder;
import org.example.dto.PlayerGetByPlayerIdRequestDto;

public class PlayerGetByPlayerIdRequestDtoBuilder {
    private Integer playerId;

    public PlayerGetByPlayerIdRequestDtoBuilder withPlayerId(Integer playerId) {
        this.playerId = playerId;
        return this;
    }

    public PlayerGetByPlayerIdRequestDto build() {
        PlayerGetByPlayerIdRequestDto requestDto = new PlayerGetByPlayerIdRequestDto();
        requestDto.setPlayerId(playerId);
        return requestDto;
    }
}
