package com.vanpanda.crmsystem.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "EncryptionServiceImpl")
public class EncryptionServiceImpl implements EncryptionService {
    private final String SHA_ALGORITHM = "SHA-256";
    private final String SECURE_RANDOM_ALGORITHM = "SHA1PRNG";
    private final int SHA_LENGTH = 32;
    private final int SALT_LENGTH = 6;
    
    public String encrypt(String data, String salt) {

        MessageDigest messageDigest = null;

        try {

            messageDigest = MessageDigest.getInstance(SHA_ALGORITHM);

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }
        
        String saltedData = data + salt;
        byte[] saltedDataBytes = saltedData.getBytes();

        BigInteger sha = new BigInteger(messageDigest.digest(saltedDataBytes));
        String encryptedData = sha.toString(SHA_LENGTH);

        return encryptedData;
    }

    public String generateSalt() {

        byte[] randomBytes = new byte[SALT_LENGTH];

        try {

            SecureRandom secureRandom = SecureRandom.getInstance(SECURE_RANDOM_ALGORITHM);
            secureRandom.nextBytes(randomBytes);

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }

        String salt = randomBytes.toString();
        
        return salt;
    }
}
