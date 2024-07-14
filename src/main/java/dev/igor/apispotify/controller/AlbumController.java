package dev.igor.apispotify.controller;

import dev.igor.apispotify.clients.AlbumsSpotifyClient;
import dev.igor.apispotify.clients.AuthSpotifyClient;
import dev.igor.apispotify.clients.request.LoginRequest;
import dev.igor.apispotify.clients.response.Album;
import dev.igor.apispotify.clients.response.AlbumResponse;
import dev.igor.apispotify.clients.response.LoginResponse;
import dev.igor.apispotify.config.SpotifyConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("spotify/api")
public class AlbumController {
    private final AuthSpotifyClient client;
    private final AlbumsSpotifyClient albunsSpotifyClient;
    private final SpotifyConfig config;

    public AlbumController(AuthSpotifyClient client, AlbumsSpotifyClient albunsSpotifyClient, SpotifyConfig config) {
        this.client = client;
        this.albunsSpotifyClient = albunsSpotifyClient;
        this.config = config;
    }

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAlbums() {
        var request = new LoginRequest(
                "client_credentials",
                config.getClientId(),
                config.getClientSecret()
        );
        LoginResponse login = client.login(request);

        AlbumResponse response = albunsSpotifyClient.getAlbumsSpotifyNewReleases("Bearer " + login.accessToken());

        return ResponseEntity.ok(response.albums().items());
    }
}
