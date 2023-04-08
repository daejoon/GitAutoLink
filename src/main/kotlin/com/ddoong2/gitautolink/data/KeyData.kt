package com.ddoong2.gitautolink.data

class KeyData(
    private val message: String,
) {
    private val REGEX = Regex("\\[([^\\]]+)\\]")
    companion object {
        const val KEY = "{key}"
    }

    val isFind: Boolean
        get() = REGEX.containsMatchIn(message)

    fun getValue(): String {
        return REGEX.find(message.trim())?.groupValues?.get(1) ?: ""
    }
}
