package com.example.demo.heartbeat;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class RandomHeartbeat implements HeartbeatSensor {
    @Override
    public int get() {
        return ThreadLocalRandom.current().nextInt(40,200);
    }
}
