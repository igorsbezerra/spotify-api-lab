package dev.igor.apispotify.clients;

import dev.igor.apispotify.clients.response.AlbumResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "AlbumsSpotifyClient",
        url = "https://api.spotify.com"
)
public interface AlbumsSpotifyClient {
    @GetMapping("/v1/browse/new-releases")
    AlbumResponse getAlbumsSpotifyNewReleases(
            @RequestHeader("Authorization") String authorization
    );
}
