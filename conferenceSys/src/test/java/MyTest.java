import com.zym.dao.UserMapper;
import com.zym.pojo.Participate;
import com.zym.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

public class MyTest {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userService = applicationContext.getBean("UserServiceImpl", UserService.class);
//        userService.addUser(444,"222");
//        System.out.println("wc");
        Participate participate = new Participate();
        participate.setConId(1);
        participate.setUserId("4012");
        System.out.println(participate);
    }
}
