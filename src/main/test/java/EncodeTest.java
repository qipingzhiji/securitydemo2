import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

/**
 * Created by zhang_htao on 2019/9/9.
 */
public class EncodeTest {
    @Test
    public void encodePassword() throws Exception{
        SecureRandom abc = SecureRandom.getInstanceStrong();
        System.out.println(abc);
        String encode = new BCryptPasswordEncoder(8, abc).encode("123456");
        System.out.println(encode);
    }
}
