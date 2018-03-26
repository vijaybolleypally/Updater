package listener;

import annotation.TestProperties;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestIDListener extends TestListenerAdapter {


    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);

        System.out.println("onTestSuccess" + tr.getStatus());
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);

        System.out.println("onTestFailure" + tr.getStatus());
    }

    public String getTestCaseID(ITestResult result) throws NoSuchMethodException {
        String tetCaseID = this.getClass().getDeclaredMethod(result.getName()).getAnnotation(TestProperties.class).testID();
        System.out.println(tetCaseID);
        return tetCaseID;
    }
}
