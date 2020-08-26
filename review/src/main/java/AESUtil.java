import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

//import org.apache.commons.codec.binary.Base64;

/**
 * 20150727
 * AES对称加密
 * Aes encryption
 * 参考网址如下：
 * 	1.http://aesencryption.net/#Java-aes-encryption-example
 * 	2.http://stackoverflow.com/questions/3954611/encrypt-and-decrypt-with-aes-and-base64-encoding
 */
public class AESUtil{
    private static final String KEY = "buaa4pgc?eval@2015";
    private static SecretKeySpec secretKey ;
    private static byte[] key ;

    public static void setKey(){
        String myKey = KEY;
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            System.out.println(key.length);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // use only first 128 bit
            System.out.println(key.length);
            System.out.println(new String(key,"UTF-8"));
            secretKey = new SecretKeySpec(key, "AES");

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * AES加密，并返回String字符串
     * @param strToEncrypt
     * @return
     */
    public static String encrypt(String strToEncrypt){
        try{
            AESUtil.setKey();
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            //return (new String(Base64.encodeBase64(cipher.doFinal(strToEncrypt.getBytes("UTF-8")))));
            return (new String(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))));
        }
        catch (Exception e){
            System.out.println("Error while encrypting: "+e.toString());
        }
        return null;
    }

    /**
     * AES解密，并返回String字符串
     * @param strToDecrypt
     * @return
     */
    public static String decrypt(String strToDecrypt){
        try{
            AESUtil.setKey();
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            //return new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt.getBytes("UTF-8"))));
            return new String(cipher.doFinal(strToDecrypt.getBytes("UTF-8")));
        }catch (Exception e){
            System.out.println("Error while decrypting: "+e.toString());
        }
        return null;
    }

    public static void main(String args[]){
        final String strToEncrypt = "My text to encrypt";
        final String strPssword = "encryptor key";
        AESUtil.setKey();

        String encyptedStr = AESUtil.encrypt(strToEncrypt.trim());

        /*System.out.println("String to Encrypt: " + strToEncrypt);
        System.out.println("Encrypted: " + encyptedStr);

        System.out.println("String To Decrypt : " + encyptedStr);
        System.out.println("Decrypted : " + AESUtil.decrypt(encyptedStr.trim()));*/

        System.out.println(AESUtil.decrypt("jsifqux7dnK4iKxXEi+UaQ=="));

    }

}
