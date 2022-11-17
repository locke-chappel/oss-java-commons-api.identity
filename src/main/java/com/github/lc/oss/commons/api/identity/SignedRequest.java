package com.github.lc.oss.commons.api.identity;

public interface SignedRequest extends ApiObject {
    /**
     * The timestamp in milliseconds since the Unix epoch UTC that this request was
     * created. Requests over 30 seconds old are rejected even if otherwise valid.
     */
    long getCreated();

    /**
     * External ID of the application that signed the request.
     */
    String getApplicationId();

    /**
     * Base64 encoded JSON body of the request.
     */
    String getBody();

    /**
     * Signature of the value returned by {@link #getSignatureData()}
     */
    String getSignature();

    /**
     * Returns the data to verified via the signature.
     */
    default String getSignatureData() {
        return Long.toString(this.getCreated()) + this.getApplicationId() + this.getBody();
    }
}
