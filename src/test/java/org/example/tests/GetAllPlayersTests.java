package org.example.tests;

import org.example.api.PlayersServiceApi;
import org.example.constants.Role;
import org.example.dto.PlayerCreateResponseDto;
import org.example.dto.PlayerItemDto;
import org.example.factory.PlayerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class GetAllPlayersTests extends BaseTest {

    private List<PlayerCreateResponseDto> createdPlayers = new ArrayList<>();

    @BeforeClass
    public void setup() {
        Role role = Role.USER;
        Role editor = Role.SUPERVISOR;
        for (int i = 0; i < 5; i++) {
            PlayerCreateResponseDto player = PlayerFactory.createRandomPlayer(role, editor);
            createdPlayers.add(player);
        }
    }

    @AfterClass
    public void cleanup() {
        Role editor = Role.SUPERVISOR;
        for (PlayerCreateResponseDto createdPlayer : createdPlayers) {
            PlayersServiceApi.deletePlayer(204, createdPlayer.getId(), editor);
        }
    }

    @Test
    public void testGetAllPlayers() {
        List<PlayerItemDto> allPlayers = PlayersServiceApi.getAllPlayers(200).getPlayers();
        for (PlayerCreateResponseDto createdPlayer : createdPlayers) {
            boolean found = false;
            for (PlayerItemDto player : allPlayers) {
                if (player.getId() == createdPlayer.getId()) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "Created player with ID " + createdPlayer.getId() + " not found in response");
        }
    }
}
