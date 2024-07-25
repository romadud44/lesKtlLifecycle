package com.example.lesktllifecycle

class BodyMassIndex {


    fun checkMass(weight: Double, height: Double): Double {
        return (weight / ((height / 100.0) * (height / 100.0)))
    }
}