package org.example.dto; // Replace com.example with your package name

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerGetAllResponseDto {
    public static final String SERIALIZED_NAME_PLAYERS = "players";

    @SerializedName(SERIALIZED_NAME_PLAYERS)
    private List<PlayerItemDto> players;

    public PlayerGetAllResponseDto players(List<PlayerItemDto> players) {
        this.players = players;
        return this;
    }

    public PlayerGetAllResponseDto addPlayersItem(PlayerItemDto playersItem) {
        if (this.players == null) {
            this.players = new ArrayList<>();
        }
        this.players.add(playersItem);
        return this;
    }

    @Nullable
    @ApiModelProperty(value = "List of players")
    public List<PlayerItemDto> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerItemDto> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerGetAllResponseDto that = (PlayerGetAllResponseDto) o;
        return Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    @Override
    public String toString() {
        return "PlayerGetAllResponseDTO{" +
                "players=" + players +
                '}';
    }
}
