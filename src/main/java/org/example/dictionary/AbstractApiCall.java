package org.example.dictionary;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractApiCall<T, R extends AbstractApiCall<T, R>> {

    private static final Logger logger = LogManager.getLogger(AbstractApiCall.class);
    protected static final ObjectMapper objectMapper = new ObjectMapper();

    private final Class<T> responseType;
    private final Map<String, String> pathParams = new HashMap<>();
    private final Map<String, String> queryParams = new HashMap<>();
    private final Map<String, String> headers = new HashMap<>();
    private T requestBody;
    private Object body;
    private int expectedStatusCode;

    static {
        RestAssured.config = RestAssured.config().logConfig(new LogConfig().enableLoggingOfRequestAndResponseIfValidationFails());
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public AbstractApiCall(Class<T> responseType) {
        this.responseType = responseType;
    }

    public abstract String getBasePath();
    public abstract String getPath();
    public abstract String getBaseUri();
    public abstract Method getMethod();
    public abstract R getSelf();

    public R withPathParam(String name, String value) {
        pathParams.put(name, value);
        return getSelf();
    }

    public R withQueryParam(String name, String value) {
        queryParams.put(name, value);
        return getSelf();
    }

    public R withHeaders(Map<String, String> headers) {
        this.headers.putAll(headers);
        return getSelf();
    }

    public R withHeader(String name, String value) {
        headers.put(name, value);
        return getSelf();
    }

    public R withBody(Object body) {
        this.body = body;
        return getSelf();
    }

    public R withExpectedStatusCode(int statusCode) {
        this.expectedStatusCode = statusCode;
        return getSelf();
    }

    String buildUrl() {
        String path = getPath();
        for (Map.Entry<String, String> param : pathParams.entrySet()) {
            path = path.replace("{" + param.getKey() + "}", param.getValue());
        }

        StringBuilder url = new StringBuilder(getBaseUri() + getBasePath() + path);
        if (!queryParams.isEmpty()) {
            url.append("?");
            queryParams.forEach((key, value) -> url.append(key).append("=").append(value).append("&"));
            url.deleteCharAt(url.length() - 1); // Remove last "&"
        }
        return url.toString();
    }

    protected Response buildRequest() {
        try {
            return RestAssured
                    .given()
                    .headers(headers)
                    .contentType(ContentType.JSON)
                    .body(objectMapper.writeValueAsString(body))
                    .request(getMethod().toString(), new URI(buildUrl()));
        } catch (JsonProcessingException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Response execute() {
        logger.info("Sending HTTP {} request to {}", getMethod(), buildUrl());
        Response response = buildRequest();
        logger.info("Received HTTP {} response with status code {}", getMethod(), response.statusCode());
        return response;
    }

    public <T> T executeWithResponseAs(Class<T> responseType) {
        Response response = execute();
        return response.as(responseType);
    }


    public int executeAndGetStatus() {
        logger.info("Sending HTTP {} request to {}", Method.DELETE, buildUrl());
        Response response = RestAssured
                .given()
                .headers(headers)
                .request(Method.DELETE.toString(), buildUrl());
        logger.info("Received HTTP {} response with status code {}", Method.DELETE, response.statusCode());
        return response.statusCode();
    }
}
