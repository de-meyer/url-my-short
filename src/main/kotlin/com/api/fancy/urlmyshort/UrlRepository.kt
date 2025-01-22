package com.api.fancy.urlmyshort

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface UrlRepository: ReactiveMongoRepository<Url, Long > {
    fun save(url: Url): Mono<Url>
    fun findById(id: String): Mono<Url>
    fun findByShortUrl(shortUrl: String): Mono<Url>
}