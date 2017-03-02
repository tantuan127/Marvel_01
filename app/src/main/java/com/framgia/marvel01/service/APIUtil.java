package com.framgia.marvel01.service;

import com.framgia.marvel01.BuildConfig;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by levutantuan on 3/10/17.
 */
public class APIUtil {
    public static final String API_KEY = BuildConfig.API_KEY;
    public static final String PRIVATE_KEY = BuildConfig.PRIVATE_KEY;
    public static final String BASE_URL = "https://gateway.marvel.com:443";
    public static final String MD5 = "MD5";

    public static String getKey(long timeStamp) {
        String stringToHash = timeStamp + PRIVATE_KEY + API_KEY;
        return getMd5(stringToHash);
    }

    public static final String getMd5(final String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2) h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}