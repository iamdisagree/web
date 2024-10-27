package ru.yarsu.web.handlers

import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.template.TemplateRenderer
import ru.yarsu.web.models.HomeVM

class HomeHandler(private val renderer:TemplateRenderer):HttpHandler {
    override fun invoke(request: Request): Response{
        val viewModel = HomeVM()
        val htmlDocument = renderer(viewModel)
        return Response(Status.OK).body(htmlDocument)
    }
}