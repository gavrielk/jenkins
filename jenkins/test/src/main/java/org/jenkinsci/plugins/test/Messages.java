// CHECKSTYLE:OFF

package org.jenkinsci.plugins.test;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Disk usage
     * 
     */
    public static String DisplayName() {
        return holder.format("DisplayName");
    }

    /**
     * Disk usage
     * 
     */
    public static Localizable _DisplayName() {
        return new Localizable(holder, "DisplayName");
    }

    /**
     * diskUsage
     * 
     */
    public static String UrlName() {
        return holder.format("UrlName");
    }

    /**
     * diskUsage
     * 
     */
    public static Localizable _UrlName() {
        return new Localizable(holder, "UrlName");
    }

    /**
     * disk usage
     * 
     */
    public static String ProjectDiskUsage() {
        return holder.format("ProjectDiskUsage");
    }

    /**
     * disk usage
     * 
     */
    public static Localizable _ProjectDiskUsage() {
        return new Localizable(holder, "ProjectDiskUsage");
    }

    /**
     * Displays per-project disk usage
     * 
     */
    public static String Description() {
        return holder.format("Description");
    }

    /**
     * Displays per-project disk usage
     * 
     */
    public static Localizable _Description() {
        return new Localizable(holder, "Description");
    }

}
