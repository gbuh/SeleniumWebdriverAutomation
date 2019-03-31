package com.dice;

import com.dice.base.BaseTest;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void testFirtMethod() {
        String path = "https://www.dice.com";
        driver.get(path);
        logger.info(String.format("Site %s was opened. Test passed", path));
    }
}
