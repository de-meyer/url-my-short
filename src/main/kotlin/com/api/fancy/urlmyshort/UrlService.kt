package com.api.fancy.urlmyshort

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UrlService(private val urlRepository: UrlRepository) {
    fun save(url: Url): Mono<Url> {
        val generateShortString = url.originalUrl.trim()
            .replace("https://","")
            .replace("http://","")
            .replace("www.","")
            .substring(0,3)
        return urlRepository.save(url.copy(
            id = url.id,
            originalUrl = url.originalUrl,
            shortUrl = "$generateShortString.short-url",
            accessCount = url.accessCount
        ))
    }
    fun findAll(): Flux<Url> = urlRepository.findAll()
    fun findById(id: String): Mono<Url> = urlRepository.findById(id)
    fun findByShortUrl(shortenedUrl: String): Mono<Url> = urlRepository.findByShortUrl(shortenedUrl)
}