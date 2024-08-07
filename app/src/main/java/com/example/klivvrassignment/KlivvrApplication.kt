package com.example.klivvrassignment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
/**
 * The main application class for the Klivvr application.
 * Annotated with `@HiltAndroidApp` to trigger Hilt's dependency injection setup.
 */
@HiltAndroidApp
class KlivvrApplication : Application()