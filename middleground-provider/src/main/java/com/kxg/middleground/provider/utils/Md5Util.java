package com.kxg.middleground.provider.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author szp
 * @date 2020/1/4 11:28
 */
@Slf4j
@Component
public class Md5Util {
    private static final Integer MD5_STRING_SIZE = 8;
    protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
            'F' };

    /**
     * 获取accesskey和appKey
     * @return
     */
    public static String getKey(){
        return getMd5String(UUID.randomUUID().toString().replace("-",""));
    }
    /**
     * 获得appkey，Appsecret和组件的标识
     * （时间戳+str）md5算法-》取前8位  转成  16进制字符串
     * */
    public static String getMd5String(String str){
        try {
            String timeStamp = String.valueOf(System.currentTimeMillis());
            str = timeStamp + str;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] results = messageDigest.digest(str.getBytes("UTF-8"));
            String result = bufferToHex(results, 0, MD5_STRING_SIZE);
            log.info("origin string is:{},timestamp is:{},across md5 string is:{} ",str, timeStamp, result);
            return result;
        } catch (NoSuchAlgorithmException e) {
            log.error("come into being MD5,occur exception:{}",e.getMessage());
        } catch (UnsupportedEncodingException e) {
            log.error("come into being MD5,transform encoding occur exception:{}",e.getMessage());
        }
        return "";
    }
    public static String getMd5String(String str, int len){
        String timeStamp = String.valueOf(System.currentTimeMillis());
        str = timeStamp + str;
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            byte[] results = messageDigest.digest(str.getBytes("UTF-8"));
            String result = bufferToHex(results, 0, len);
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        // 取字节中高 4 位的数字转换
        char c0 = hexDigits[(bt & 0xf0) >> 4];
        // 为逻辑右移，将符号位一起右移,此处未发现两种符号有何不同
        char c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }
}
