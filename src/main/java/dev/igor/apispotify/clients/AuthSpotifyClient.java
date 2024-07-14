package dev.igor.apispotify.clients;

import dev.igor.apispotify.clients.request.LoginRequest;
import dev.igor.apispotify.clients.response.LoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "AuthSpotifyClient",
        url = "https://accounts.spotify.com"
)
public interface AuthSpotifyClient {
    @PostMapping(
            value = "/api/token",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    LoginResponse login(@RequestBody LoginRequest request);
}
