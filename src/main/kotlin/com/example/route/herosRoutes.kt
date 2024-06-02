package com.example.route

import com.example.models.ApiResponse
import com.example.repository.HeroRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import org.koin.ktor.ext.get
import org.koin.ktor.ext.inject

fun Route.heroroutes(){
    val heroRepository : HeroRepository by inject()
    get("/AllDoctors"){
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..5)

            val apiresponse = heroRepository.getallheroes(page = page)
            call.respond(message = apiresponse)
        }
        catch (e : NumberFormatException){
            call.respond(
                message = ApiResponse(success = false,message ="Give Page Number"),
                status = HttpStatusCode.BadRequest
            )
        }

        catch (e : IllegalArgumentException){
            call.respond(
                message = ApiResponse(success = false,message ="Pages from 1 to 5 only"),
                status = HttpStatusCode.BadRequest
            )
        }

    }
}