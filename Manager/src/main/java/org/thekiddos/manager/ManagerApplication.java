package org.thekiddos.manager;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.thekiddos.manager.gui.GUIApplication;

/**
 * Main SpringBoot start point
 * since javaFX is used Application Context is setup in the javaFX {@link GUIApplication#init()} method.
 */
@SpringBootApplication
@EnableScheduling
public class ManagerApplication {
    public static void main( String[] args ) {
        Application.launch( GUIApplication.class, args );
    }
}
