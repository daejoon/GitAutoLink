package com.ddoong2.gitautolink.data

class KeyData(
    private val message: String,
    private val left: String,
    private val right: String,
) {
    private val leftIndex: Int = message.indexOfFirst { it == left[0] }
    private val rightIndex: Int = message.indexOfFirst { it == right[0] }

    companion object {
        const val KEY = "{key}"
    }

    val isFind: Boolean
        get() = leftIndex < rightIndex && leftIndex != -1 && rightIndex != -1

    fun getValue(): String {
        if (isFind.not()) {
            throw NoSuchElementException("Can't find key in message")
        }
        return message.substring(leftIndex + 1, rightIndex)
    }
}
