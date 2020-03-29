import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.kxg.middleground.provider.DubboProviderBootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: szp
 * @Date: 2020/3/22 02:03
 * @Description: 沈泽鹏写点注释吧
 */
@SpringBootTest(classes = {DubboProviderBootstrap.class})
@RunWith(SpringRunner.class)
public class Test1 {
    @NacosValue("${spring.datasource.url}")
    String test;
    @Test
    public void test(){
        System.out.println(test);
    }
}
