package net.beetechgroup.service;

import java.security.SecureRandom;

public class GenerateCode {

    private static final int MAX_SIZE = 5;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public String generateCode() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(MAX_SIZE);
        for (int i = 0; i < MAX_SIZE; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }
}
