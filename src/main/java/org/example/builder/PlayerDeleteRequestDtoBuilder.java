package org.example.builder;

import org.example.dto.PlayerDeleteRequestDto;

public class PlayerDeleteRequestDtoBuilder {
    private Integer playerId;

    public PlayerDeleteRequestDtoBuilder withPlayerId(Integer playerId) {
        this.playerId = playerId;
        return this;
    }

    public PlayerDeleteRequestDto build() {
        PlayerDeleteRequestDto requestDto = new PlayerDeleteRequestDto();
        requestDto.setPlayerId(playerId);
        return requestDto;
    }
}
