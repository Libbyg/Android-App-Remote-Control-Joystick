# Android-App-Remote-Control-Joystick

## Introduction
An android app to remotely control the FlightGear simulator.

## Video Link
https://www.youtube.com/watch?v=g2ul0twrpsU

## Explanation Of Folders And Main Files Structure
#### MVVM Architecture
__*Model*__

* Communicates with the FlightGear server using telnet protocol.
* Recieves commands from ViewModel and executes them.
* The Model sends the commands to FlightGear simulator, and we see the airplane responds to these commands.
* Commands sending is made by single threadpool.
* Single threadpool creates an executor that uses single thread worker operating off an unbounded queue
(if this single thread terminates due to a failure during execution prior to shutdown, a new one will take its place if needed to execute subsequent tasks.)
Tasks are guaranteed to execute sequentially, and no more than one task will be active at any given time.

![](/app/Images/Model.jpg)

__*View*__

The MainActivity is our main view which uses the JoystickView of joystick object.
The MainActivity contains: 
* input text fields for IP address and connection port.
* Connect Button.
* Two seekBars for rudder and throttle.
* JoystickView.
To enable data binding we configured this option in the build.gradle(app).

__*Special features:*__
1. Each time the __joystick__ is freed after finger touch, it __turns back to its initial location__ - to the center of the screen.
2. In the JoystickApp we're using a logger named __Timber__. If the user enters a wrong input in the ip address field or in the port field we'll know the exact error, where it occured and when.
 
![](/app/Images/VIEW.jpg)

__*View Model*__

View Model takes the data entered by user - IP address and connection port - via event listeners and by using data binding.
The data binding to view model is made by different event listeners, that are listenning to all user's actions.
Event listeners proccess the data and send appropriate commands to the Model.


![](/app/Images/ViewModel.jpg)

__*Resources*__

* Joystick's basis is the joystick layout which uses the drawable circle. 
* The image view converts the drawable circle to image element and we place it in the layout.
* The default property of the joystick in the layout is defined that way: the "layout_gravity" set to "center".
* This enables our first __special feature__ to happen.

![](/app/Images/Resources.jpg)

## UML Diagram - According To MVVM Architecture
![](/app/Images/UML.png)

## Preinstallation For Developer
* FlightGear applicaion. Can be downloaded from here: *https://www.flightgear.org/download/*
* IDE for android app development. We used Android Studio. Can be downloaded from here: *https://developer.android.com/studio*

## Quickstart: Installations Instructions And First APP Running
1. Open FlightGear app after dowloading it (link attached above).
2. Go to `Settings` > `Additional Settings` > enter these in the text box: `--telnet=socket,in,10,127.0.0.1,6400,tcp`
3. Click on `Fly!`.
4. Clone the project from GitHub to your computer.
5. Open the project in the IDE (Android Studio) and click on 'run'.
6. Run the emulator or use your phone
 for running the app from your phone: we'll need to configure the phone to use developers options.
    * Go to Android 9 (API level 28) and higher: `Settings` > `About Phone` > `Build Number`
    * Tap 7 times 
    * Go to `Settings` > `System` > `Advanced` > `Developer Options` > `USB debugging`
    * Connect the phone with usb cable to your computer.
    * Run the program in the IDE.
7. Open `Joystick` app.
8. In the android app: 
  * Enter your local IP address and connection port - `6400`.
  * Click `connect` button.
9. In the FlightGear simulator click on `Cessna C172P` and then click on `autostart`.
10. Click `Shift`+`v` till you locate the screen in a convenient position so you can see the airplane properly to control it.
11. Start to pull the `throttle` SeekBar button till maximum rate.
12. When airplane starts to move regulate the `rudder` Seekbar and use the `joystick` to navigate.
13. Enjoy your flight!

Running the android app on the phone will look like this:

![](/app/Images/Phone1.jpg)
