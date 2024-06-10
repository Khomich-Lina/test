package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseEntityDto {

    @JsonProperty("body")
    private Object body;

    @JsonProperty("statusCode")
    private String statusCode;

    @JsonProperty("statusCodeValue")
    private Integer statusCodeValue;

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getStatusCodeValue() {
        return statusCodeValue;
    }

    public void setStatusCodeValue(Integer statusCodeValue) {
        this.statusCodeValue = statusCodeValue;
    }

    @Override
    public String toString() {
        return "ResponseEntityDto{" +
                "body=" + body +
                ", statusCode='" + statusCode + '\'' +
                ", statusCodeValue=" + statusCodeValue +
                '}';
    }
}
