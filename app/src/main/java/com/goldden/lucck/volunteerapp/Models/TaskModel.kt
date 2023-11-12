package com.goldden.lucck.volunteerapp.Models

data class TaskModel(
    val name: String,
    val photo: Int,
    val description: String,
    val id: Int,
    val city: String,
    val owned: Boolean,
    val submitted : Boolean
)
