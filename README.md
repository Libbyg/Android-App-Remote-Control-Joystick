# Android-App-Remote-Control-Joystick

## Introduction
An android app to remotely control the FlightGear simulator.

## Video Link
https://www.youtube.com/watch?v=g2ul0twrpsU

## Explanation of folders and main files structure
__*Model*__

* Communicates with the FlightGear server using telnet protocol.
* Recieves commands from ViewModel and executes them.

![](/app/Images/Model.jpg)

__*View*__

The MainActivity is our main view which uses the JoystickView of joystick object.
The MainActivity contains: 
* input text fields for IP address and connection port.
* Connect Button.
* Two seekBars for rudder and throttle.
* JoystickView.
To enable data binding we configured this option in the build.gradle(app).

__*Special feature:*__
1. Each time the joystick is freed after finger touch it turns back to its initial location - to the center of the screen.
2. In the JoystickApp we're using a logger named Timber. If the user enters a wrong input in the ip address field or in the port field we'll know the exact error, where it occured and when.
 
![](/app/Images/VIEW.jpg)

__*View Model*__

View Model takes the data entered by user - IP address and connection port - via event listeners and by using data binding.

![](/app/Images/ViewModel.jpg)

__*Resources*__

![](/app/Images/Resources.jpg)

## Explanation of each folder

## UML - according to MVVM architecture
![](/app/Images/UML.png)

## Preinstallation for Developer

## Quickstart: Installations Instructions And Running

