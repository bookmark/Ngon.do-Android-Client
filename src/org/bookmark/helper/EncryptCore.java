package org.bookmark.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptCore {

    public static String md5Encode(final String input) {
        try {
            // Create MD5 Hash
            final MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(input.getBytes());
            final byte messageDigest[] = digest.digest();

            // Create Hex String
            final StringBuffer hexString = new StringBuffer();
            for (final byte element : messageDigest)
                hexString.append(Integer.toHexString(0xFF & element));
            return hexString.toString();

        } catch (final NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
