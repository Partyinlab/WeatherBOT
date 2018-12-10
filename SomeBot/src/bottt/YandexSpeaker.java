package bottt;
import java.net.URL;
import java.net.HttpURLConnection;

public class YandexSpeaker {
	String url = "https://www.yandex.ru/";

	URL obj = new URL(url);
	HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

	connection.setRequestMethod("GET");

	BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();

	while ((inputLine = in.readLine()) != null) {
	    response.append(inputLine);
	}
	in.close();

	System.out.println(response.toString());

}
