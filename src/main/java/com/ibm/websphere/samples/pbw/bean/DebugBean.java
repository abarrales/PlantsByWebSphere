package com.ibm.websphere.samples.pbw.bean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
@Named
@RequestScoped
public class DebugBean {
    public String getJavaVersion() {
        String version = System.getProperty("java.version");
        return version != null ? version : "Version not found";
    }
}
