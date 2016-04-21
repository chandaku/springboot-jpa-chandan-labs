package com.chandan.labs.dummy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.internal.WhiteboxImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MyClass.class)
public class MyClassTest {
    final String publicMsg = "This is my PUBLIC method";
    final String privateMsg = "This is my PRIVATE method";
 
    @Test
    public void testMy_public_method() throws Exception {
        MyClass myClass = new MyClass();
        String msg=myClass.my_public_method();
        Assert.assertEquals(publicMsg,msg);
    }
    
    @Test
    public void testMy_private_method() throws Exception {
        MyClass myClass = new MyClass();
        String msg= WhiteboxImpl.invokeMethod(myClass, "my_private_method");
        Assert.assertEquals(privateMsg,msg);
    }
}