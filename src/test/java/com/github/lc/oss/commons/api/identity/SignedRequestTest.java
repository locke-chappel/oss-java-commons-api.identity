package com.github.lc.oss.commons.api.identity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SignedRequestTest {
    @Test
    public void test_getSignatureData_nulls() {
        SignedRequest sr = new SignedRequest() {
            @Override
            public String getSignature() {
                return null;
            }

            @Override
            public long getCreated() {
                return 0;
            }

            @Override
            public String getBody() {
                return null;
            }

            @Override
            public String getApplicationId() {
                return null;
            }
        };

        Assertions.assertEquals("0nullnull", sr.getSignatureData());
    }

    @Test
    public void test_getSignatureData() {
        SignedRequest sr = new SignedRequest() {
            @Override
            public String getSignature() {
                return "sig";
            }

            @Override
            public long getCreated() {
                return 1000;
            }

            @Override
            public String getBody() {
                return "body";
            }

            @Override
            public String getApplicationId() {
                return "app-id";
            }
        };

        Assertions.assertEquals("1000app-idbody", sr.getSignatureData());
    }
}
