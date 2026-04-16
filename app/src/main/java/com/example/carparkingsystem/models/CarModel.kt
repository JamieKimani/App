package com.example.carparkingsystem.models

import androidx.compose.ui.graphics.Color

data class CarModel(
    var id: String?=null,
    var plateNumber: String?=null,
    var vehicleType: String?=null,
    var driverName: String?=null,
    var phoneNumber: String?=null,
    var color: String?=null,
    var entryTime: String?=null,
    var imageUrl: String?=null
)