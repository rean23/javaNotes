import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

//哈希算法
public class demo24 {
    public static void main(String[] args) {
        try {
            //url编码
            String encoded = URLEncoder.encode("中国", "UTF-8");
            System.out.println(encoded);
            //url解码
            String decoded = URLDecoder.decode(encoded, "UTF-8");
            System.out.println(decoded);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        String txt = "Nice to meet you！";

        //base64编码 这里需要传入byte数组
        String encode = Base64.getEncoder().encodeToString(txt.getBytes());
        System.out.println(encode);

        //base64解码 这里返回的是byte数组,所以需要String对象转换
        String decode = new String(Base64.getDecoder().decode(encode), StandardCharsets.UTF_8);
        System.out.println(decode);


        //md5加密
        String data = "HelloWorld";
        System.out.println("加密前：" + data);
        System.out.println("加密后：" + md5(data));


        //对称加密

        //aes加密
        try {
            String message = "Hello,Rean";
            System.out.println("待加密内容：" + data);
            byte[] key = "abcdef1234567890".getBytes("UTF-8");

            byte[] encrypted = encrypt(key, message.getBytes("UTF-8"));
            System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));

            byte[] decrypted = decrypt(key, encrypted);
            System.out.println("Decrypted: " + new String(decrypted, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    public static byte[] encrypt(byte[] key, byte[] input) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKey secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(input);
        } catch (Exception e) {
            e.printStackTrace();
            return input;
        }
    }

    public static byte[] decrypt(byte[] key, byte[] input) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKey secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(input);
        } catch (Exception e) {
            e.printStackTrace();
            return input;
        }
    }

    public static String md5(String data) {
        try {
            //生成一个MD5的加密摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            //计算md5函数
            md.update(data.getBytes("UTF-8"));

            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            byte[] result = md.digest();

            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, result).toString(16);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return data;
        }
    }
}
