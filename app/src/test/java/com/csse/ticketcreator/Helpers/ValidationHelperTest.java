package com.csse.ticketcreator.Helpers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Nishan
 * @version 1.2
 */
public class ValidationHelperTest {

    @Test
    public void validateContactNumber() throws Exception {
        boolean actualResult = ValidationHelper.validateContactNumber("0745685452d4");
        assertNotNull(actualResult);
        assertNotEquals(true, actualResult);
    }

    @Test
    public void validateNicNumber() throws Exception {
        boolean actualResult = ValidationHelper.validateNicNumber("456518168168e");
        assertNotNull(actualResult);
        assertNotEquals(true, actualResult);
    }

    @Test
    public void validateCredCardExpireDate() throws Exception {
        boolean actualResult = ValidationHelper.validateCredCardExpireDate("12/3000");
        assertNotNull(actualResult);
        assertEquals(false, actualResult);
    }

    @Test
    public void validateCcv() throws Exception {
        boolean actualResult = ValidationHelper.validateCcv("584");
        assertNotNull(actualResult);
        assertNotEquals(false, actualResult);
    }

    @Test
    public void isNumeric() throws Exception {
        boolean actualResult = ValidationHelper.isNumeric("84945v");
        assertNotNull(actualResult);
        assertEquals(false, actualResult);
    }

}