package com.helper;

import java.net.URI;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Utility class to open a browser window at a specified URL.
 * Used by the Maven open-browser profile.
 */
public class BrowserOpener {
    
    /**
     * Main method that opens a browser window at the URL specified as the first argument.
     * 
     * @param args The URL to open in the browser
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java BrowserOpener <url>");
            System.exit(1);
        }
        
        String url = args[0];
        System.out.println("Opening browser at: " + url);
        
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                System.out.println("Desktop browsing is not supported on this platform");
            }
        } catch (IOException | URISyntaxException e) {
            System.err.println("Error opening browser: " + e.getMessage());
            e.printStackTrace();
        }
    }
}