/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jenkinsci.plugins.test;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.TransientProjectActionFactory;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author gabi
 */
@Extension
public class testProjectNameFactory  extends TransientProjectActionFactory{
    
    @Override
    public Collection<? extends Action> createFor(AbstractProject project) {
        return Collections.singleton(new testProjectName(project));
    }
}
