package com.example.marvel.manager

import java.io.File

object ResourcesManager {
    private const val RESOURCES_URI = "src/test/java/com/example/marvel/resources"

    fun loadResource(filename: String): String {
        return File(
            RESOURCES_URI,
            filename
        ).readText()
    }
}