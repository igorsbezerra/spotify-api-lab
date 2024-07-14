package dev.igor.apispotify.clients.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Album(
        String id,
        String name,
        @JsonProperty("release_date") String releaseDate) {
}
