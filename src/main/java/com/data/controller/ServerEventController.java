package com.data.controller;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/SEC")
public class ServerEventController {

    @GetMapping(value = "/server-events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> streamEvents() throws IOException {

        Stream<String> lines = Files.lines(Path.of("src/main/resources/data.txt"));
        AtomicInteger atomicInteger = new AtomicInteger(1);
        return Flux.fromStream(lines)
                .filter(line -> !line.isEmpty())
                .map(line -> ServerSentEvent.builder(line)
                        .id(String.valueOf(atomicInteger.getAndIncrement()))
                        .event("data")
                        .build())
                .delayElements(Duration.ofSeconds(1));
    }
}