package Utils;

import java.nio.charset.Charset;
import java.util.Random;

public class StringUtils {
    public static String getRandomString()
    {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }
}
