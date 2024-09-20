package org.elwart.ccvoice.Com.Common.Encryption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SHA256Encode {
    /**
     * SHA-256加密
     * @param str
     * @return Hashed base64 string
     */
    public static String encode(String str){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash=digest.digest(str.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        }catch(NoSuchAlgorithmException e){
            throw new RuntimeException("Error generated sha-256 hash: ",e);
        }
    }
}
