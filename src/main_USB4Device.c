#include <stdio.h>
#include "main_TurtleTracker.h"
#include "conio.h"
#include "stdio.h"
#include "windows.h"
#include "USB4.h"
//Not sure if this is the best way to pass errors to the Java program, but it's what I have for now.  
//See java side for error handling.  
enum Errors {NONE=0, COUNTERMODE=1, FORWARD=2, PRESET=3, MULT=4, INIT=5, BOARD=6, COUNTERENABLED=7, RESET=8, SAMPLE=9, TIME=10, CLEAR=11, ENABLE=12, START=13, FIFO=14};

jint done(enum Errors error);

int main( int argc, char* args[] )
{
	return 0;
}

JNIEXPORT jint JNICALL Java_main_USB4Device_initialize() {
	short iBoardCnt = 0; // Used to get the number of USB4 devices found.
	int iResult = 0;
	enum Errors error = 0;

	// Initialize the USB4 driver.
	iResult = USB4_Initialize(&iBoardCnt);

	// Check result code...
	if (iResult != USB4_SUCCESS)
	{
		printf("Failed to initialize USB4 driver!  Result code = %d.\n", iResult);
		error = INIT;
		return done(error);
	}
	else
	{
		if (iBoardCnt < 1)
		{
			iResult = FATAL_ERROR;
			printf("No USB4 boards detected!\n");
			error = BOARD;
			return done(error);
		}
	}
	return iBoardCnt;
}

jint done(enum Errors error) {
		// Close all open connections to the USB4 devices.
		USB4_Shutdown();
		return error; 
}