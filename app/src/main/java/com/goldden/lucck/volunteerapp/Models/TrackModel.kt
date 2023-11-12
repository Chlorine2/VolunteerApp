package com.goldden.lucck.volunteerapp.Models

data class TrackModel(
    val name: String,
    val photo: Int,
    val description: String,
    val id: Int,
    val city: String,
    val city_1: String,
    val owned: Boolean,
    val submitted : Boolean
    )
