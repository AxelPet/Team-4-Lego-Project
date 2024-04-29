package services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.Duration;
import java.time.Instant;

@Path("/robot")
public class RobotServices {
    @PersistenceContext
    private EntityManager entityManager;

    private Instant startTime;

    @POST
    @Path("/start")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String startRobot(int speed) {
        // Start the robot at the specified speed
        // For now, just return a success message
        return "Robot started running at speed " + speed + ".";
    }

    @POST
    @Path("/stop")
    @Produces(MediaType.APPLICATION_JSON)
    public String stopRobot() {
        // Stop the robot
        // For now, just return a success message
        return "Robot stopped.";
    }

    @POST
    @Path("/run")
    @Produces(MediaType.APPLICATION_JSON)
    public String runRobot() {
        // Start the robot
        // For now, just return a success message
        return "Robot started running.";
    }

    @GET
    @Path("/track-time")
    @Produces(MediaType.APPLICATION_JSON)
    public String trackTime() {
        if (startTime == null) {
            return "Robot not started yet.";
        } else {
            Instant currentTime = Instant.now();
            Duration duration = Duration.between(startTime, currentTime);
            long seconds = duration.getSeconds();
            return "Time elapsed since robot started: " + seconds + " seconds.";
        }
    }

    @POST
    @Path("/save-time")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String saveTime(@FormParam("startTime") String startTimeStr, @FormParam("stopTime") String stopTimeStr) {
        // Parse start time and stop time from string to Instant
        Instant startInstant = Instant.parse(startTimeStr);
        Instant stopInstant = Instant.parse(stopTimeStr);

        // Calculate duration
        Duration duration = Duration.between(startInstant, stopInstant);
        long seconds = duration.getSeconds();

        // Save duration to database or perform other operations
        // For now, just return the duration in seconds
        return "Time elapsed: " + seconds + " seconds.";
    }
}
