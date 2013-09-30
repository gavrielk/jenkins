/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jenkinsci.plugins.test;

import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.ProminentProjectAction;
import hudson.model.TransientProjectActionFactory;
import java.util.Collection;
import jenkins.model.Jenkins;


/**
 *
 * @author gabi
 */
public class testProjectName implements ProminentProjectAction{

    AbstractProject<? extends AbstractProject, ? extends AbstractBuild> project;

    testProjectName(AbstractProject project) {
        this.project = project;
    }
    
    @Override
    public String getIconFileName() {
        return "/plugin/test/icons/news.png";
    }

    @Override
    public String getDisplayName() {
        System.out.println("Project name: " + project.getDisplayName());
        return project.getDisplayName();
    }

    @Override
    public String getUrlName() {
        return "test";
    }
    
}

