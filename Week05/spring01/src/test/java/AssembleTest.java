import com.templar.javatraining.assemble.BeanA;
import com.templar.javatraining.assemble.BeanB;
import com.templar.javatraining.assemble.BeanC;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:myApplicationContext.xml"})
public class AssembleTest {

    @Autowired
    private BeanA beanA;

    @Autowired
    private BeanB beanB;

    @Autowired
    private BeanC beanC;

    @Test
    public void testAssemble() {
        Assert.assertEquals(1, beanA.getId());
        Assert.assertEquals("beanA123", beanA.getName());

        Assert.assertEquals(2, beanB.getId());
        Assert.assertEquals("beanB123", beanB.getName());

        Assert.assertEquals(3, beanC.getId());
        Assert.assertEquals("beanC123", beanC.getName());
    }

}
