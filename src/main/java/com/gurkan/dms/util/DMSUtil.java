package com.gurkan.dms.util;

import java.util.Base64;

public class DMSUtil {

    public static String encodeBase64(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    public static String decodeBase64(String input) {
        return new String(Base64.getDecoder().decode(input));
    }
}
