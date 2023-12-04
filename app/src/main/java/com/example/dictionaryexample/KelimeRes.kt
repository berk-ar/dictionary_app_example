package com.example.dictionaryexample

data class KelimeRes(
    val word: String,
    val phonetic: String,
    val meanings: List<Meaning>,
)

data class Meaning(
    val partOfSpeech: String,
    val definitions: List<Definition>,
    val synonyms: List<Any?>,
    val antonyms: List<Any?>,
)

data class Definition(
    val definition: String,
)