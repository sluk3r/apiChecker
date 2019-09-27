package unitTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//https://java2blog.com/mockito-mock-static-method/
@RunWith(PowerMockRunner.class)
@PrepareForTest(StringUtil.class)
public class PowerMockStaticMethodTest
{
    @Test
    public void test_StringUtil_staticMethod() {

        boolean expectation=true; // 1

        PowerMockito.mockStatic(StringUtil.class); //2
        PowerMockito.when(StringUtil.checkSubString("Java2Blog","blog")).thenReturn(true); //3

        boolean actual = StringUtil.checkSubString("Java2Blog","blog"); //4
        Assert.assertEquals(expectation, actual); //5
    }
}