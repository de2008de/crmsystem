package com.vanpanda.crmsystem.services;

public interface EncryptionService {
    public String encrypt(String data, String salt);
    public String generateSalt();
}
