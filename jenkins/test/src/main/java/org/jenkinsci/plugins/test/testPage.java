/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jenkinsci.plugins.test;

import hudson.Extension;
import hudson.Plugin;
import hudson.model.ManagementLink;
import hudson.model.RootAction;

/**
 *
 * @author gabi
 */
public class testPage extends Plugin{
    
    public String getMyString() {
    return "Hello Jenkins!";
}
    
    
        @Extension
    public static class TestRootLink implements RootAction {

    	public String getIconFileName() {
            return "/plugin/test/icons/diskusage48.png";
        }

        public String getDisplayName() {
            return Messages.DisplayName();
        }

        public String getUrlName() {
            return Messages.Url();
        }
    }
        
        
    @Extension
    public static class DiskUsageManagementLink extends ManagementLink {

        public final String[] COLUMNS = new String[]{"Project name", "Builds", "Workspace"};

        public String getIconFileName() {
            return "/plugin/test/icons/diskusage48.png";
        }

        public String getDisplayName() {
            return Messages.DisplayName() + "_Management";
        }

        public String getUrlName() {
            return Messages.Url();
        }

        @Override public String getDescription() {
            return Messages.Description();
        }
    }
}
