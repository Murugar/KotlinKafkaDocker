package com.iqmsoft.kotlin.kafka

import java.io.IOException
import java.util.*



class ApplicationConfig {

    private val configFileName: String = "application.properties"

    fun getProperties(): Properties {
        val properties: Properties = Properties()
        try {
            properties.load(this.javaClass.classLoader.getResourceAsStream(configFileName))
            return properties
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return properties
    }
}
