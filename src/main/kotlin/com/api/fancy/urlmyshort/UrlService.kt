package com.api.fancy.urlmyshort

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UrlService(private val urlRepository: UrlRepository) {
    fun save(url: Url): Flux<Url> = urlRepository.save(url)
    fun findAll(): Flux<Url> = urlRepository.findAll()
    fun findById(id: String): Mono<Url> = urlRepository.findById(id)
    fun findByShortUrl(shortenedUrl: String): Mono<Url> = urlRepository.findByShortUrl(shortenedUrl)
}