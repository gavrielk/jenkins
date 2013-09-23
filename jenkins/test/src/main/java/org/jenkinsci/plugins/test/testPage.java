/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jenkinsci.plugins.test;

import hudson.Extension;
import hudson.Plugin;
import hudson.model.ManagementLink;
import hudson.model.RootAction;
import hudson.security.AccessControlled;
import hudson.security.Permission;
import jenkins.model.Jenkins;
import org.acegisecurity.AccessDeniedException;
import org.apache.log4j.Logger;

/**
 *
 * @author gabi
 */
public class testPage extends Plugin{
    
    public String getMyString() {
        String output = "";
        for ( Permission permission : Permission.getAll())
        {
            boolean isAuthorized = Jenkins.getInstance().hasPermission(permission);
            if (isAuthorized == true)
            {
                output = output.concat(permission.name + "(" + 
                        permission.group.title.toString() + ")" + "=true<br>");
            }
            else
            {
                output = output.concat(permission.name + "(" + 
                        permission.group.title.toString() + ")" + "=false<br>");
            }
        }
            
        return output;
}
    
    
        @Extension
    public static class TestRootLink implements RootAction {

    	public String getIconFileName() {
            return "/plugin/test/icons/diskusage48.png";
        }

        public String getDisplayName() {
            boolean found = false;
            for ( Permission permission : Permission.getAll())
            {
                boolean isAuthorized = Jenkins.getInstance().hasPermission(permission);
                boolean isInOverallGroup = permission.group.title.toString().matches("Overall");
                if (isAuthorized == true && isInOverallGroup == true)
                {
                    found = true;
                    break;
                }
            }
            if (found == true)
                return Messages.DisplayName();
            else
                return "Access denied";
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
