# OkCupid Take Home

This project is meant to display my proficiency in Android development. I was tasked with creating an app based on a mock up provided to me by okc. The current master branch is a fully functional design that meets all specs outlined in the assignment.

## Overview

### Design pattern

For this project I used the MVP design pattern. I separate each activity (only one activity in this case) into its own package based on its purpose. The package for the activity in this project is named "search" based on the title of the activity in the mock. this package contains all files directly related to that activity, including the presenter class, contract, and package files for the fragments it contains.

I believe that MVP is a solid approach when designing the architecture of your code base. It creates a healthy separation of business logic and view logic allowing developers to more easily test and read their code. However, I do believe that MVP also suffers from having a ton boiler plate code to set it up properly. As a project grows I can see how the number of files that have to be created for each view might start to become messy. It is important to keep your views separated into clean package structures to help alleviate this.

### Libraries

RXJava
```
*Network calls
*Event Bus
*Saving and retrieving data from local DB
```
Retrofit
```
*Pulling the user model from the example json file
```
Room
```
*Database for persisting liked users to the device
```

## Issues

### Design pattern for tab fragments
Both tabs are very similar in spec so I initially tried to set up the two tabs be reusing the same fragment class and presenter. It can definitely work however I decided to separate it out because creating new tabs in a similar structure would only cause confusing amounts of conditional logic in the presenter and recycler adapter. You can see my initial implementation in the combined-tab-presenter branch. Please keep in mind this was very early on in development, much has changed since creating that branch.

I do believe that there is more that can be done to cleanly accomplish something similar what is described above. For example, I could create an abstract TabPresenter class that handles the similarities between the tabs and then each tab can have a more concrete presenter implementation of its own.

### Image crop
I noticed that there were image cropping dimensions in the json file for each user, creating a 1:1 aspect ratio of the user's image. I attempted to create a transformation to implement that crop but it was causing bugs in the landscape view. I took out the transformation and stuck with a center crop, which has its own issues.

In my research I was not able to find many solutions for cropping images when you have the pixel dimensions for the crop. I believe I did crop it properly with the given dimensions using a custom BitmapTransformation. However, I believe the cropped image was getting loaded into memory and then android would reuse the cropped image when switching to landscape view, which caused a bug when trying to fit the image into a larger ImageView. I think that one solution would be to cache the original image and then crop that image from cache when needed. However, That has its own problems, for example, caching large amounts of bitmaps in memory would most certainly cause the app to crash. You could also cache the photos to disk but with disk speed being much slower than memory that could cause some rendering issues. It is an interesting problem and I would definitely like to revisit it.
