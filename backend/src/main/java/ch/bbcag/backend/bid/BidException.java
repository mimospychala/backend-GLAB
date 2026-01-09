package ch.bbcag.backend.bid;

import org.springframework.http.HttpStatus;

public class BidException extends RuntimeException {
    private final HttpStatus status;

    public BidException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    // Komfort-Factorys
    public static BidException conflict(String message) {
        return new BidException(HttpStatus.CONFLICT, message);
    }

    public static BidException badRequest(String message) {
        return new BidException(HttpStatus.BAD_REQUEST, message);
    }
}
