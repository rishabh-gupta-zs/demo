package com.zs.assignment1;
import java.io.File;
public class Main {
    public static void main(String[] args) {
        System.out.println("Name of current user - "+System.getProperty("user.name"));
        System.out.println("Home directory of current user - "+System.getProperty("user.home"));
        System.out.println("System memory - "+Runtime.getRuntime().maxMemory());
        System.out.println("System CPU - "+Runtime.getRuntime().availableProcessors());
        System.out.println("System disk size - "+(new File("/").getTotalSpace())/(1024*1024*1024)+" GB");
        System.out.println("OS build - "+System.getProperty("os.name"));
        System.out.println("OS version - "+System.getProperty("os.version"));
    }
}