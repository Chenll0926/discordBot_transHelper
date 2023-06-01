package main.api;

import io.github.cdimascio.dotenv.Dotenv;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

public class SpotifyApiConnection {
    private Dotenv config = Dotenv.configure().load();
    private String clientId = config.get("SPO_CLIENT_ID");
    private String clientSecret = config.get("SPO_CLIENT_SECRET");
    public SpotifyApiConnection() throws Exception {
        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .build();

        ClientCredentialsRequest credentialsRequest = spotifyApi.clientCredentials().build();
        String accessToken = credentialsRequest.execute().getAccessToken();
        if (accessToken == null) throw new Exception("No access token");

        spotifyApi.setAccessToken(accessToken);
    }
}
