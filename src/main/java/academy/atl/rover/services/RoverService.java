package academy.atl.rover.services;

import academy.atl.rover.models.Rover;
import org.springframework.stereotype.Service;

@Service
public interface RoverService {
    public Rover getRover();
    void sendCommand(String command);
}
