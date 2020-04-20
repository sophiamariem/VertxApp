package api;

import java.time.LocalDateTime;

public class TestOutput {
    private final LocalDateTime localDateTime;
    private final String value;

    public TestOutput(LocalDateTime localDateTime, String value) {
        this.localDateTime = localDateTime;
        this.value = value;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getValue() {
        return value;
    }
}
