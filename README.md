# Tracker
A small app made using Kotlin on MVVM pattern that tracks user device's screen On, screen Off, and screen Locked events and lists them in reverse chronological order.

## Architeture and Libraries 
1. MVVM 
2. Kotlin
3. Databinding
4. RxJava2, RxAndroid
5. Android Architecture Components (Livedata, Viewmodel, Room)
6. Dagger2
7. Sticky Service

## Other Design Pattern involved
1. Repository pattern to add single responsibility classes to my DAO and Sharedpreference helper.
2. Following SOLID, the Repository pattern further follows Liskov Substitution

## Assumptions & Scenarios of failures
1. The "locked" detection feature assumes that device is locked, and won't work otherwise.
2. The application is pivotal to the <a href="https://github.com/abhi472/Tracker/blob/master/app/src/main/java/com/abhishek/tracker/service/TrackerService.kt">TrackerService</a> which is a sticky service and sometimes this sticky service is not restarted when app is closed in devices like Vivo and Mi. So another criteria for this to work is to use it on phones with stock android OS.
