import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestApiClient {

    public static void main(String[] args) {

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://official-joke-api.appspot.com/random_joke"))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            String setup = json.split("\"setup\":\"")[1].split("\"")[0];
            String punchline = json.split("\"punchline\":\"")[1].split("\"")[0];

            System.out.println("===== JOKE FROM API =====");
            System.out.println("Question : " + setup);
            System.out.println("Answer   : " + punchline);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
