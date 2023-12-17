package com.loop.test.day_7_windows;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import org.testng.annotations.Test;

public class T_0_0_login_docuport extends TestBase {

    @Test
    public void test_login_docuport() throws InterruptedException {
        DocuportUtils.login(driver, DocuportConstants.CLIENT);
        DocuportUtils.logOut(driver);

        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        DocuportUtils.logOut(driver);

        DocuportUtils.login(driver, DocuportConstants.EMPLOYEE);
        DocuportUtils.logOut(driver);

        DocuportUtils.login(driver, DocuportConstants.SUPERVISOR);
        DocuportUtils.logOut(driver);
    }
}
