package com.example.noteapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//This class create dependency container at the
// top app level which gives hilt access to the entire application
// hilt can supply dependency to any class within this application "App"
@HiltAndroidApp
class BaseApplication:Application(){}