/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 *
 * @author Bryan
 */
public class PasswordService {
    /**
     * Compares a plaintext String password to a String base64 hashed password using the String base64 salt provided
     * @param password plaintext password
     * @param salt base64 salt
     * @param hashedPassword base64 hashed password
     * @return true if plaintext password matches hashed password
     * @throws NoSuchAlgorithmException 
     */
    public boolean comparePasswords(String password, String salt, String hashedPassword) throws NoSuchAlgorithmException {
        return (this.encrypt(password, salt).equals(hashedPassword));
    }
    
    /**
     * Encrypts a password using SHA-512 and a provided base64 salt
     * @param password plaintext String password to encrypt
     * @param saltString base64 salt used to encrypt the password
     * @return base64 hashed password
     * @throws NoSuchAlgorithmException 
     */
    public String encrypt(String password, String saltString) throws NoSuchAlgorithmException {
        byte[] salt = Base64.getDecoder().decode(saltString);
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hashedPassword);
    }
    
    /**
     * Generates a random 16-byte salt converted to base64
     * @return base64 salt
     */
    public String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String saltString = Base64.getEncoder().encodeToString(salt);
        return saltString;
    }
}
