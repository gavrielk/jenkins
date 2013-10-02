/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jenkinsci.plugins.test;

import hudson.Extension;
import hudson.Plugin;
import hudson.model.*;
import hudson.security.AccessControlled;
import hudson.security.Permission;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;
import hudson.util.FormValidation;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import jenkins.model.Jenkins;
import net.sf.json.JSONObject;
import org.acegisecurity.AccessDeniedException;
import org.apache.log4j.Logger;
import org.jenkinsci.plugins.database.Database;
import org.jenkinsci.plugins.database.GenericDatabase;
import org.jenkinsci.plugins.database.GlobalDatabaseConfiguration;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

/**
 *
 * @author gabi
 */
@Extension
public class testPage extends Plugin implements Describable<testPage>{
    
    @Extension
    public static final DescriptorImpl DESCRIPTOR = new DescriptorImpl();
    
    
    
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
    @Override
    public Descriptor<testPage> getDescriptor() {
        return DESCRIPTOR;
    }
    
    @Extension
    public static class DescriptorImpl extends Descriptor<testPage>{

        @Override
        public String getDisplayName() {
            return Messages.DisplayName();
        }
        
        
        /**
         *
         * @param value
         * @throws ServletException
         */
        public FormValidation doSaveName(@QueryParameter("nameTextBox") final String nameTextBox) throws IOException, ServletException{
            
            Database db = GlobalDatabaseConfiguration.get().getDatabase();
            if (db != null){
                System.out.println(db.toString());
                System.out.println(db.getDescriptor().toString());
            }
            else{
                System.out.println("db is null");
            }
//            System.out.println("Inside doSaveName()");
//            List<Action> actionList = Jenkins.getInstance().getActions();
//            System.out.println("Printing all actions names:");
//            for (Action action : actionList){
//                System.out.println(action.getDisplayName());
//                if (action instanceof TestRootLink){
//                    TestRootLink testAction = (TestRootLink)action;
//                    System.out.println("Before addition:");
//                    testAction.getDevices();
//                    testAction.addDevice("michael");
//                    System.out.println("After addition:");
//                    testAction.getDevices();
//                }
//            }
//            System.out.println("Done");
            return FormValidation.ok("success");
        }
    }    
    
    
        @Extension
    public static class TestRootLink implements RootAction {
            
        private static ArrayList<Device> deviceList = new ArrayList<Device>() {{
            new Device("moshe");
            new Device("avi");
            new Device("itzhak");
                }};

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
        
        public ArrayList<Device> getDevices(){
            for ( Device device : deviceList){
                System.out.println(device.getName());
            }
            return deviceList;
        }
        
        public void addDevice(String deviceName){
            Device device = new Device(deviceName);
            deviceList.add(device);
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
