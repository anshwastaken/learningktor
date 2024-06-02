package com.example.route

import com.example.repository.HeroRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.application.call
import io.ktor.server.response.respond
import org.koin.ktor.ext.inject

fun Route.Searchhero(){
    val heroRepository : HeroRepository by inject()
    get("/hero/search"){
        val name = call.request.queryParameters["name"]

        val apiresponse = heroRepository.Searchheroes(name = name)
        call.respond(
            message = apiresponse,
            status = HttpStatusCode.OK
        )

    }
}