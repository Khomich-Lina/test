package org.example.tests;

import org.example.api.PlayersServiceApi;
import org.example.constants.Role;
import org.example.dto.PlayerCreateResponseDto;
import org.example.factory.PlayerFactory;
import org.example.factory.PlayerModel;
import org.example.mapper.PlayerMapper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.example.assertions.PlayerModelAssertion.assertThat;
public class CreatePlayerTests extends BaseTest {

    private PlayerCreateResponseDto createdPlayer;

    @Test
    public void testSupervisorCanCreateUserWithUserRole() {
        Role newPlayerRole = Role.USER;
        Role editorRole = Role.SUPERVISOR;
        createdPlayer = PlayerFactory.createRandomPlayer(newPlayerRole, editorRole);
        PlayerModel createdPlayerModel = PlayerMapper.mapToPlayerModel(createdPlayer);
        assertThat(createdPlayerModel).hasIdField();
        PlayerModel expectedPlayerModel = PlayerFactory.generateRandomPlayerModelWithRole(newPlayerRole);
        assertThat(createdPlayerModel).isEqualTo(expectedPlayerModel);
    }

    @Test
    public void testAdminCanCreateUserWithUserRole() {
        Role newPlayerRole = Role.USER;
        Role editorRole = Role.ADMIN;
        createdPlayer = PlayerFactory.createRandomPlayer(newPlayerRole, editorRole);
        PlayerModel createdPlayerModel = PlayerMapper.mapToPlayerModel(createdPlayer);
        assertThat(createdPlayerModel).hasIdField();
        PlayerModel expectedPlayerModel = PlayerFactory.generateRandomPlayerModelWithRole(newPlayerRole);
        assertThat(createdPlayerModel).isEqualTo(expectedPlayerModel);
    }

    @Test
    public void testUserAged16YearsOldCanBeCreated() {
        int playerAge = 16;
        Role newPlayerRole = Role.USER;
        Role editorRole = Role.SUPERVISOR;
        createdPlayer = PlayerFactory.createPlayerWithSpecificAge(playerAge, newPlayerRole, editorRole);
        PlayerModel createdPlayerModel = PlayerMapper.mapToPlayerModel(createdPlayer);
        assertThat(createdPlayerModel).hasIdField();
        assertThat(createdPlayerModel).hasAge(playerAge);
    }

    @AfterMethod
    public void cleanup() {
        if (createdPlayer != null && createdPlayer.getId() != null) {
            PlayersServiceApi.deletePlayer(204, createdPlayer.getId(), Role.SUPERVISOR);
        }
    }
}
