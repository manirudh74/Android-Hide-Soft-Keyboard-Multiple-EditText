# Android-Hide-Soft-Keyboard-Multiple-EditText
Hide the Android Soft Keyboard unless switching to another EditText. 

## Java: 

Create a List of EditTexts, add focus change listener to each that makes sure no other EditText is gaining focus before hiding the keyboard.

https://github.com/msaffold/Android-Hide-Soft-Keyboard-Multiple-EditText/blob/master/app/src/main/java/com/example/mike/softkeyboardedittext1/Home.java

## XML: 

Make parent layout clickable="true" and focusableInTouchMode="true"

https://github.com/msaffold/Android-Hide-Soft-Keyboard-Multiple-EditText/blob/master/app/src/main/res/layout/activity_home.xml
