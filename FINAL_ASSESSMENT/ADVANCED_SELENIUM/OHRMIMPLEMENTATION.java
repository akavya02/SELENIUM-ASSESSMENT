package FINALASSESSMENT;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OHRMIMPLEMENTATION extends BASECLASSOHRM {

    @Test(dataProvider = "buzzData")
    public void buzzTest(String postText)throws InterruptedException {

        OHRMHOMEPAGE home =new OHRMHOMEPAGE(driver);
        OHRMBUZZPAGE buzz =new OHRMBUZZPAGE(driver);
        home.getBuzz();
        buzz.getPostTextField(postText);
        buzz.getPostButton();
        Assert.assertTrue(buzz.verifyPost(postText),"Post is not displayed in Recent Posts");
        System.out.println("Post created and verified successfully");
    }
}
