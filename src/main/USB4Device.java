package main;

import java.io.IOException;

public class USB4Device implements USB4DeviceInterface {
	// Native functions make calls to .c files using JNI -> data from USB4
	// device

	public native int initialize();

	static {
	    try {
	        System.loadLibrary("USB4Device"); // used for tests. This library in classpath only
	    } catch (UnsatisfiedLinkError e) {
	        try {
	            NativeUtils.loadLibraryFromJar("/USB4Device.dll"); // during runtime. .DLL within .JAR
	        } catch (IOException e1) {
	            throw new RuntimeException(e1);
	        }
	    }
	}

}
