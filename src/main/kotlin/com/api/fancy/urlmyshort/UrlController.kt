package com.api.fancy.urlmyshort

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/url")
class UrlController(private val urlService: UrlService) {
    @GetMapping
    fun getAllUrls(): Flux<Url> = urlService.findAll()

    @PostMapping("/save")
    fun saveUrl(@RequestBody url: Url): Flux<Url> = urlService.save(url)

    @GetMapping("/find/{id}")
    fun getUrlById(@PathVariable id: String): Mono<Url> = urlService.findById(id)

    @GetMapping("/find/shortUrl/{shortenedUrl}")
    fun getUrlByShortenedUrl(@PathVariable shortenedUrl: String): Mono<Url> = urlService.findByShortUrl(shortenedUrl)
}