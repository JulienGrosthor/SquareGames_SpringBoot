package com.example.demo.heartbeat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartbeatController {

    @Autowired
    private HeartbeatSensor heartbeatSensor;

    @Autowired
    private RandomHeartbeat randomHeartbeat;

    @GetMapping("/heartbeat")
    public int getHeartbeat() {
        return randomHeartbeat.get();
    }
}
