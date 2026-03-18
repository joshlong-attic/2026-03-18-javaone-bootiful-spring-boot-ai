package com.example.scheduler;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class SchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerApplication.class, args);
    }

}

@Component
class DogAdoptionsScheduler {

    @McpTool(description = "schedule an appointment to pickup or adopt a dog from a Pooch Palace location")
    DogAdoptionPickupSuggestion dogAdoptionPickupSuggestion(
            @McpToolParam String dogName,
            @McpToolParam int dogId) {

        var das = new DogAdoptionPickupSuggestion(Instant
                .now()
                .plus(3, ChronoUnit.DAYS));
        IO.println("schedule an appointment for " + das + ":" + dogName + '/' + dogId);
        return das;
    }
}

record DogAdoptionPickupSuggestion(Instant when) {
}