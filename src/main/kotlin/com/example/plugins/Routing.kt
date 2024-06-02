package com.example.plugins

import com.example.route.Searchhero
import com.example.route.heroroutes
import com.example.route.root
import io.ktor.server.application.*
import io.ktor.server.http.content.resource
import io.ktor.server.http.content.static
import io.ktor.server.http.content.staticFiles
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        root()
        heroroutes()
        Searchhero()
//        static("/images") {
//            resource("images")
//        }
    }
}
