package services;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/robot")
public class RoboController {

    private String direction;
    private int speed;

    public RoboController() {
        this.direction = "forward"; //eteenpäin suunta atm
        this.speed = 0; // Oletusnopeus 0
    }

    // GET-pyyntö suunnan ja nopeuden hakemiseen
    @GetMapping("/status")
    public String getStatus() {
        return "Direction: " + direction + ", Speed: " + speed;
    }

    // POST-pyyntö nopeuden muokkaamiseen
    @PostMapping("/speed")
    public void setSpeed(@RequestParam int newSpeed) {
        this.speed = newSpeed;
    }

    // POST-pyyntö suunnan muuttamiseen, vaikka eteen ja taakse tms
    @PostMapping("/direction")
    public void setDirection(@RequestParam String newDirection) {
        this.direction = newDirection;
    }

    // POST-pyyntö liikkeellelähtöön
    @PostMapping("/start")
    public void start() {
        this.speed = 1; // Asetetaan nopeus 1, kun robotti lähtee liikkeelle
    }

    // POST-pyyntö pysäyttämiseen
    @PostMapping("/stop")
    public void stop() {
        this.speed = 0; // Asetetaan nopeus 0, kun robotti pysähtyy
    }
}
