#include <stdio.h>
#include "main_TurtleTracker.h"
#include "conio.h"
#include "stdio.h"
#include "windows.h"
#include "USB4.h"
//Not sure if this is the best way to pass errors to the Java program, but it's what I have for now.  
//See java side for error handling.  
enum Errors {NONE=0, COUNTERMODE=1, FORWARD=2, PRESET=3, MULT=4, INIT=5, BOARD=6, COUNTERENABLED=7, RESET=8, READ=400};

jint done(enum Errors error);

int main( int argc, char* args[] )
{
	return 0;
}

JNIEXPORT jint JNICALL Java_main_TurtleTracker_setUpTracker(JNIEnv *env, jobject obj, jint trackerNum) {
	short iDeviceNo = 0; // USB Device Number.  If you add functionality for multiple USB Devices on one computer, you will have to edit this.
	int iResult = 0;
	enum Errors error = 0;
	unsigned long ulCount = 0;

	iResult = USB4_SetPresetValue(iDeviceNo, trackerNum, 359);		// Set the max count/rollover value to 359. 
	if (iResult != USB4_SUCCESS) {
		printf("Failed to set USB4 Preset Value. Result code = %d.\n", iResult);
		error = PRESET;
		return done(error);
	}

	iResult = USB4_SetMultiplier(iDeviceNo, trackerNum, 1);		// Set quadrature mode to X1.
	if (iResult != USB4_SUCCESS) {
		printf("Failed to set USB4 Multiplier. Result code = %d.\n", iResult);
		error = MULT;
		return done(error);
	}

	iResult = USB4_SetCounterMode(iDeviceNo, trackerNum, 3);		// Set counter mode to modulo-N.
	if (iResult != USB4_SUCCESS) {
		printf("Failed to set USB4 Counter Mode. Result code = %d.\n", iResult);
		error = COUNTERMODE;
		return done(error);
	}

	iResult = USB4_SetForward(iDeviceNo, trackerNum, TRUE);		// Determines the direction of counting.
	if (iResult != USB4_SUCCESS) {
		printf("Failed to set USB4 Forward. Result code = %d.\n", iResult);
		error = FORWARD;
		return done(error);
	}

	iResult = USB4_SetCounterEnabled(iDeviceNo, trackerNum, TRUE);	// Enable the counter.**IMPORTANT**
	if (iResult != USB4_SUCCESS) {
		printf("Failed to enable USB4 Counter. Result code = %d.\n", iResult);
		error = COUNTERENABLED;
		return done(error);
	}

	iResult = USB4_ResetCount(iDeviceNo, trackerNum);	// Reset the counter to 0
	if (iResult != USB4_SUCCESS) {
		printf("Failed to Reset USB4 Counter to 0. Result code = %d.\n", iResult);
		error = RESET;
		return done(error);
	}

	return error;
}

JNIEXPORT jint JNICALL Java_main_TurtleTracker_read(JNIEnv *env, jobject obj, jint trackerNum) {
	enum Errors error = 0;
	unsigned long ulCount = 0;
	short iDeviceNo = 0; 
	int iResult = 0;
	//NOTE: if this is edited, you need to make sure that ulCount changse types correctly from unsigned long -> jint 
	//It is ok currently because all values will be between 0 and 360. You will run into issues with negatives.
	iResult = USB4_GetCount(iDeviceNo, trackerNum, &ulCount); //read count (angle) from encoder
	if(iResult != USB4_SUCCESS) {
		printf("Failed to read USB4 Counter. Result code = %d.\n", iResult);
		error = READ;
		return done(error);
	}
	return ulCount;
}

JNIEXPORT jint JNICALL Java_main_TurtleTracker_reset(JNIEnv *env, jobject obj, jint trackerNum) {
	short iDeviceNo = 0; 
	int iResult = 0;
	enum Errors error = 0;
	iResult = USB4_ResetCount(iDeviceNo, trackerNum);			// Reset the counter to 0
		if (iResult != USB4_SUCCESS) {
			printf("Failed to reset USB4 Counter to 0. Result code = %d.\n", iResult);
			error = RESET;
			return done(error);
		}
	return error;
}

jint done(enum Errors error) {
		return error; 
}