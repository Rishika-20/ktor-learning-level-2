package com.learningktor

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.http.content.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import java.lang.Exception

fun main(args: Array<String>) {
    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            json()
        }
        module()
        module2()
    }.start(true)
}

/*fun Application.module(){
    install(Routing) {
        get("/greet") {
            call.respondText("Hello, Welcome to Ktor Tutorials using embedded server!!")
        }
    }
}*/


fun Application.module(){
    install(Routing) {

        static {
            resource("amazon.html")
            resource("linkedin.html")
        }
        get("/greet") {
            call.respondText("Hello, Welcome to Ktor Tutorials using embedded server!!")
        }
        /**
         *  Other way to call a get or any http method.
         *
         **/
        /*route("/route", method = HttpMethod.Get){
            handle {
                call.respondText("Get method using route and handle!!")
            }
        }*/

        get("/users/{name}") {
            val name  = call.parameters["name"]
            // Request header connection
            val header = call.request.headers["Connection"]
            // Set Custom header
            if (name == "Admin") {
                call.response.header("CustomHeader","Admin")
                call.respondText("Hello Admin", status = HttpStatusCode.OK)
            }


            call.respondText("Hello CraftMan/CraftWoman $name  with  header : $header !!!")
        }

       //Get function for query parameters.
        get("/details"){
             val name = call.request.queryParameters["name"]
             val studio = call.request.queryParameters["studio"]
            call.respondText("Hi, I am $name from $studio Studio!!")
        }

        // Get call for fetching employee details and initially it will wait for the response to get that's why we are using try-catch to handle exception.
        get("/employee"){
            try {
                   val employee = Employee("Rishika",1852)
                     call.respond(message = employee, status = HttpStatusCode.OK)
            } catch (e:Exception ){
                call.respond(message = "${e.message}",status = HttpStatusCode.BadRequest)

            }
        }

        // To redirect user from one page to other.
        get("/redirect-push"){
            call.respondRedirect(url = "/redirect-pop",permanent = false)
        }
        get("/redirect-pop"){
            call.respondText("Hey, You have successfully redirected!! [From - redirect-push To- redirect-pop] ***")
        }
    }
}
fun Application.module2(){
    //install(Routing){
    routing {
        get("/new-greet") {
            call.respondText("Welcome Backkk!!")
        }
    }
}
@Serializable
data class Employee(
    val name: String,
    val id:Int
)


