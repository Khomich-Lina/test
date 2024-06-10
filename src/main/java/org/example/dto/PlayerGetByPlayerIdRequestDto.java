package org.example.dto;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * PlayerGetByPlayerIdRequestDto
 */
@ApiModel(description = "PlayerGetByPlayerIdRequestDto")
public class PlayerGetByPlayerIdRequestDto {

    @SerializedName("playerId")
    private Integer playerId;

    public PlayerGetByPlayerIdRequestDto playerId(Integer playerId) {
        this.playerId = playerId;
        return this;
    }

    /**
     * Get playerId
     *
     * @return playerId
     */
    @ApiModelProperty(value = "")

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerGetByPlayerIdRequestDto playerGetByPlayerIdRequestDto = (PlayerGetByPlayerIdRequestDto) o;
        return Objects.equals(this.playerId, playerGetByPlayerIdRequestDto.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PlayerGetByPlayerIdRequestDto {\n");
        sb.append("    playerId: ").append(toIndentedString(playerId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except
     * the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
