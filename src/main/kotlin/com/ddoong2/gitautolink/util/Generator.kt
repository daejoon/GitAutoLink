package com.ddoong2.gitautolink.util

inline fun <reified T> idGenerator(key: String?): String {
    return if (key?.isEmpty() == true) {
        "${T::class.java.packageName}.${T::class.java.simpleName}"
    } else {
        "${T::class.java.packageName}.${T::class.java.simpleName}.$key"
    }
}

inline fun <reified T> idGenerator(): String {
    return idGenerator<T>("")
}
