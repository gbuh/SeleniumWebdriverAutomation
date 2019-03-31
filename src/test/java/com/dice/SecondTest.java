package com.dice;

import com.dice.base.BaseTest;
import org.testng.annotations.Test;

public class SecondTest extends BaseTest {

    @Test
    public void testSecondMethod() {
        String path = "https://www.linkedin.com";
        driver.get(path);
        logger.info(String.format("Site %s was opened. Test passed", path));
    }
}
