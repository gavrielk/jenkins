/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jenkinsci.plugins.test;

import hudson.Extension;
import hudson.model.Describable;
import hudson.model.Descriptor;
import java.sql.SQLException;
import javax.sql.DataSource;
import jenkins.model.GlobalConfiguration;
import org.jenkinsci.plugins.database.Database;
import org.jenkinsci.plugins.database.GlobalDatabaseConfiguration;

/**
 *
 * @author gabi
 */
@Extension
public class testDatabase extends Descriptor<testDatabase> implements Describable<testDatabase>{

    public testDatabase(){
        load();
    }

    @Override
    public String getDisplayName() {
            return "testDatabase";
    }

    public Descriptor<testDatabase> getDescriptor() {
        return this;
    }
    
    
    
    
}
