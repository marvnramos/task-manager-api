package com.example

import com.example.dao.DatabaseSingleton
import com.example.plugins.*
import com.example.routes.configureRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    DatabaseSingleton.init()
    configureHTTP()
    configureRouting()
}
