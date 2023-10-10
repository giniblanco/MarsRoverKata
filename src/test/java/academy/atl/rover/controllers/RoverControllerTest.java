package academy.atl.rover.controllers;

import academy.atl.rover.dto.CommandDto;
import academy.atl.rover.services.RoverService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RoverControllerTest {

    @Mock
    private RoverService service;

    @InjectMocks
    private RoverController controller;

    @Test
    public void callService_whenCommandIsReceived() {
        controller = new RoverController();
        CommandDto commandDto = new CommandDto();
        List<String> commandsList = new ArrayList<>();
        commandsList.add("F");
        commandDto.setCommands(commandsList);
        controller.sendCommand(commandDto);

        verify(service, times(1)).getRover();
    }

}
