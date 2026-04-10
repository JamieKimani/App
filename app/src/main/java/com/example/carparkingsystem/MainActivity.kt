package com.example.carparkingsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.carparkingsystem.navigation.AppNavHost
import com.example.carparkingsystem.ui.theme.CarParkingSystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarParkingSystemTheme() {
                AppNavHost()
            }

        }
    }
}
