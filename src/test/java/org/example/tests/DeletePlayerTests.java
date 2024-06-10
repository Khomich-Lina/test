package org.example.tests;

import org.example.api.PlayersServiceApi;
import org.example.builder.PlayerDeleteRequestDtoBuilder;
import org.example.constants.Role;
import org.example.dto.PlayerCreateResponseDto;
import org.example.dto.PlayerGetByPlayerIdRequestDto;
import org.example.dto.PlayerGetByPlayerIdResponseDto;
import org.example.dto.ResponseEntityDto;
import org.example.factory.PlayerFactory;
import org.example.factory.PlayerModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertNotNull;

public class DeletePlayerTests extends BaseTest{
    private PlayerCreateResponseDto userToDelete;

    @BeforeMethod
    public void createUserForDeletion() {
        PlayerModel userToDeleteModel = PlayerFactory.generateRandomPlayerModelWithRole(Role.USER);
        userToDelete = PlayersServiceApi.createPlayer(SC_OK, userToDeleteModel, Role.SUPERVISOR);
        assertNotNull(userToDelete);
    }

    @Test
    public void testDeleteUserWithSupervisorRole() {
        PlayersServiceApi.deletePlayer(SC_OK, userToDelete.getId(), Role.SUPERVISOR);

        PlayerGetByPlayerIdResponseDto deletedUserResponse = PlayersServiceApi.playerGetByPlayerId(SC_OK,
                userToDelete.getId());
        assertTrue(deletedUserResponse == null || deletedUserResponse.getId() == null);
        PlayersServiceApi.deletePlayer(SC_OK, userToDelete.getId(), Role.ADMIN);
    }
}
