package ru.yarsu

import org.http4k.routing.ResourceLoader
import org.http4k.routing.routes
import org.http4k.routing.static
import org.http4k.server.Netty
import org.http4k.server.asServer
import org.http4k.template.PebbleTemplates
import ru.yarsu.web.router

class Triangle(
    val id: String,
    val sideA: Double,
    val sideB: Double,
    val sideC: Double
)
class Triangles(
    val triangles: List<Triangle> = arrayListOf()
)
fun main() {

    val renderer = PebbleTemplates().CachingClasspath()
    val appWithStaticResources = routes(
        router(renderer),
        static(ResourceLoader.Classpath("/ru/yarsu/public")),
    )

    val server = appWithStaticResources.asServer(Netty(9000)).start()

    println("Server started on http://localhost:" + server.port())
    println("Press enter to exit application.")
    readln()
    server.stop()
}
