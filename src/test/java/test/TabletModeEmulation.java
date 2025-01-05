package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.emulation.Emulation;
import org.openqa.selenium.devtools.v131.emulation.model.DevicePosture;
import org.openqa.selenium.devtools.v131.emulation.model.DisplayFeature;
import org.openqa.selenium.devtools.v131.emulation.model.ScreenOrientation;
import org.openqa.selenium.devtools.v131.page.model.Viewport;

import java.util.Optional;

import static org.openqa.selenium.devtools.v131.emulation.model.ScreenOrientation.Type.PORTRAITPRIMARY;

public class TabletModeEmulation {
    public static void main(String[] args) {
        // Set up ChromeDriver
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        try {
            // Start DevTools session
            DevTools devTools = ((ChromeDriver) driver).getDevTools();
            devTools.createSession();

            // Define device metrics
            int width = 768; // Device width in pixels
            int height = 1024; // Device height in pixels
            double deviceScaleFactor = 2.0; // Device pixel ratio
            boolean isMobile = true; // Emulate a mobile device

            // Optional parameters
            Optional<Number> scale = Optional.empty(); // Scale not set
            Optional<Integer> screenWidth = Optional.of(width); // Screen width
            Optional<Integer> screenHeight = Optional.of(height); // Screen height
            Optional<Integer> positionX = Optional.of(0); // Screen position X
            Optional<Integer> positionY = Optional.of(0); // Screen position Y
            Optional<Boolean> hasTouch = Optional.of(true); // Device supports touch
            Optional<ScreenOrientation> screenOrientation = Optional.of(
                    new ScreenOrientation(PORTRAITPRIMARY, 0)
            );
            Optional<Viewport> viewport = Optional.empty(); // Viewport not set
            Optional<DisplayFeature> displayFeature = Optional.empty(); // No display feature
            Optional<DevicePosture> devicePosture = Optional.empty(); // No device posture

            // Send the command to emulate tablet mode
            devTools.send(Emulation.setDeviceMetricsOverride(
                    width,
                    height,
                    deviceScaleFactor,
                    isMobile,
                    scale,
                    screenWidth,
                    screenHeight,
                    positionX,
                    positionY,
                    hasTouch,
                    screenOrientation,
                    viewport,
                    displayFeature,
                    devicePosture
            ));

            // Navigate to a website to verify tablet mode
            driver.get("https://old-dealeradmin.eshopdemo.net/widget/redesign");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
