package com.ddoong2.gitautolink.data

class KeyData(
        private val message: String,
        leftDelimiter: String,
        rightDelimiter: String,
) {
    private val leftIndex: Int = if ( leftDelimiter.isEmpty() ) -1 else message.indexOf(leftDelimiter)
    private val rightIndex: Int = if ( rightDelimiter.isEmpty()) -1 else message.indexOf(rightDelimiter, leftIndex + 1)

    companion object {
        const val KEY = "{key}"
    }

    val isFind: Boolean
        get() = (leftIndex < rightIndex) && (leftIndex != -1) && (rightIndex != -1)

    fun getValue(): String {
        if (isFind.not()) {
            throw NoSuchElementException("Can't find key in message")
        }
        return message.substring(leftIndex + 1, rightIndex)
    }
}
