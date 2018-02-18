package json;

import com.google.gson.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class JsonModifier {

    public JsonModifier(String json) {
        JsonParser parser = new JsonParser();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(json);

        Reader reader = new InputStreamReader(inputStream);

        rootElement = parser.parse(reader);
    }

    public String getValue(String jsonPath) {
        String[] parsedPath = parsePath(jsonPath);
        return getNode(jsonPath).get(parsedPath[parsedPath.length - 1]).getAsString();
    }

    public JsonElement changeValueParameter(String jsonPath, String newValue) {
        String[] parsedPath = parsePath(jsonPath);

        JsonObject node = getNode(jsonPath);

        node.addProperty(parsedPath[parsedPath.length - 1], newValue);

        return rootElement;
    }

    private JsonObject getNode(String jsonPath) {
        JsonObject nodeObject = rootElement.getAsJsonObject();
        JsonObject temp = nodeObject;

        String[] path = parsePath(jsonPath);

        for (int i = 0; i < path.length - 1; i++ ) {

            temp = temp.getAsJsonObject().get(path[i]).getAsJsonObject();

            if (temp.isJsonObject()) { nodeObject = temp; }
            else { break; }
        }

        return nodeObject;
    }

    private String[] parsePath(String jsonPath) {
        return jsonPath.split("\\.");
    }

    private JsonElement rootElement;
}
