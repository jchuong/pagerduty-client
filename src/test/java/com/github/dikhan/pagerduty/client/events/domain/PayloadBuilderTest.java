package com.github.dikhan.pagerduty.client.events.domain;

import org.json.JSONObject;
import org.junit.Test;

public class PayloadBuilderTest {

    @Test(expected = IllegalArgumentException.class)
    public void notAbleToCreatePayloadIfMandatoryFieldSummaryIsMissing() {
        Payload.Builder.newBuilder().setSeverity(Severity.INFO).setSource("source").build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void notAbleToCreatePayloadIfMandatoryFieldSourceIsMissing() {
        Payload.Builder.newBuilder().setSeverity(Severity.INFO).setSummary("summary").build();
    }

    @Test(expected = NullPointerException.class)
    public void notAbleToCreatePayloadIfMandatoryFieldSeverityIsMissing() {
        Payload.Builder.newBuilder().setSummary("summary").setSource("source").build();
    }

    @Test
    public void successfulCreation() {
        Payload.Builder.newBuilder().setSummary("summary").setSource("source")
                .setSeverity(Severity.INFO).build();
    }

    @Test
    public void testCustomeDetailWithValidJson() {
        JSONObject details = new JSONObject("{\"Name\":\"Hello\"}");

        Payload.Builder.newBuilder().setSummary("summary").setSource("source")
                .setSeverity(Severity.INFO).setCustomDetails(details).build();
    }
}
