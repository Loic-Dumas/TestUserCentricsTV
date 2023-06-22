
In this repo, you will find a basic Android TV app displaying User Centrics banner.
This app has been created by following this documentation [https://docs.usercentrics.com/cmp_in_app_sdk/latest/tv/install/]()

# Environment
- UserCentrics SDK version : 2.8.1

- devices
  - Emulator Android TV - API 29
  - Real device - Mi box 4 - API 28

# Step to reproduce:
- Open project in Android studio
- Build and install the on Android tv device 
- Open the app.

## Issue 1
- Try to navigate in banner, button are not focus.

## Issue 2 
- Open second banner (can be done by clicking on button "Display second banner")
- Try to enable or disable a (non essential) category is impossible. Clicking on it, will only expand or close the category. User can't accept a category and refuse another. The only solution is to accept or refuse all.
- On the same idea, once opened, every services cannot be focused, so user can't accept a service and refuse another.

