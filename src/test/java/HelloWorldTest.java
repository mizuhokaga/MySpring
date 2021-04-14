import com.yc.App;
import com.yc.HelloWorld;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {App.class})//加载配置文件
public class HelloWorldTest extends TestCase {
    //继承TestCase后成为测试类无需写@Test
    @Autowired
    private ApplicationContext app;



    @Test
    public void testHello(){
        HelloWorld h=(HelloWorld) app.getBean("helloWorld");
        h.execute();
    }
}
