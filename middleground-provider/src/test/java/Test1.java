import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.kxg.middleground.provider.DubboProviderBootstrap;
import com.kxg.middleground.provider.service.ZuesUserService;
import com.kxg.middleground.request.FindUserInfoRequest;
import com.kxg.middleground.response.FindUserInfoResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ZuesUserService zuesUserService;
    @Test
    public void test(){
        System.out.println(test);
    }

    @Test
    public void test2(){
        FindUserInfoRequest request=new FindUserInfoRequest();
        request.setOpenId("ox2655WxAiYBDZElN511cMygCjLk");
        FindUserInfoResponse userInfo = zuesUserService.findUserInfo(request);
        System.out.println(userInfo);
    }
}
