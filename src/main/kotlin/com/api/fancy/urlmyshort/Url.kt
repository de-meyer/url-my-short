package com.api.fancy.urlmyshort

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
@Document(collection = "url")
data class Url (
    @Id
    val id: String? = null,
    val originalUrl: String,
    val shortUrl: String? = null
)