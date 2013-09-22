// CHECKSTYLE:OFF

package org.jenkinsci.plugins.test;

public class Messages {
    
    private static String DisplayText = "Test Page";
    private static String Url = "plugin/test";
    private static String Description = "This is my test plugin";

    public static String DisplayName() {
        return DisplayText;
    }

    public static String Url() {
        return Url;
    }

    public static String Description() {
        return Description;
    }
}
