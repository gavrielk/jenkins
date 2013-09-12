/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jenkinsci.plugins.test;

import hudson.Extension;
import hudson.Plugin;
import hudson.model.RootAction;

/**
 *
 * @author gabi
 */
public class testPage extends Plugin{
        @Extension
    public static class DiskUsageRootLink implements RootAction {

    	public String getIconFileName() {
            return "/plugin/disk-usage/icons/diskusage48.png";
        }

        public String getDisplayName() {
            return Messages.DisplayName();
        }

        public String getUrlName() {
            return "/plugin/disk-usage/";
        }
    }
}
