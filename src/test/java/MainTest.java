import koschei.KoscheiTheDeathless;
import koschei.config.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class MainTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void mainTest() {
        String expectedText = "На свете есть океан, в океане остров, на острове дерево, на дереве заяц, в зайце утка, в утке яйцо, в яйце иголка, смерть Кощея на игле -> :( смерть ☠️.";

        KoscheiTheDeathless koscheiTheDeathless =
                applicationContext.getBean(KoscheiTheDeathless.class);
        String actualText = koscheiTheDeathless.getRulesByDeth();

        System.out.print(actualText);

        if (!expectedText.equals(actualText)) {
            Assert.fail("Тест провален, не корректная связь бинов. Итоговая фраза не верна.");
        }
    }
}