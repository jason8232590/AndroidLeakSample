package com.dx.androidleaksample;

public class TestUtils {
    private static final TestUtils instance = new TestUtils();

    public static TestUtils getInstance() {
        return instance;
    }

    private TestRegisterItf testRegisterItf;

    public TestRegisterItf getTestRegisterItf() {
        return testRegisterItf;
    }

    public void setTestRegisterItf(TestRegisterItf testRegisterItf) {
        this.testRegisterItf = testRegisterItf;
    }
}
