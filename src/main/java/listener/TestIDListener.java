package listener;

import annotation.TestID;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestIDListener extends TestListenerAdapter {

    String currentTestCaseID = "";

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        currentTestCaseID = getTestCaseID();
        System.out.println("onTestSuccess" + tr.getStatus());
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        System.out.println("onTestFailure" + tr.getStatus());
    }

    public String getTestCaseID() {
//        String id = this.getClass().getMethod("")
//        System.out.println(id);
//        currentTestCaseID = id;
        return currentTestCaseID;
    }
}
