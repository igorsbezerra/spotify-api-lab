package dev.igor.apispotify.clients.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginResponse(
        @JsonProperty("access_token") String accessToken) {
}
