package com.ddoong2.gitautolink.data

class KeyData(
    private val message: String,
    private val leftDelimiter: String,
    private val rightDelimiter: String = "",
    private val keyPattern: String = "",
) {
    private val leftIndex: Int = if (leftDelimiter.isEmpty()) -1 else message.indexOf(leftDelimiter)
    private val rightIndex: Int = if (rightDelimiter.isEmpty()) {
        message.indexOf(" ", leftIndex + 1)
    } else {
        message.indexOf(rightDelimiter, leftIndex + 1)
    }

    companion object {
        const val KEY = "{key}"
    }

    private val isDelimiterFind: Boolean
        get() = (leftIndex < rightIndex) && (leftIndex != -1) && (rightIndex != -1)

    // 구분자 없이 Key Pattern만 설정한 경우 커밋 메시지 전체를 검색 대상으로 삼는다.
    private val searchTarget: String? = when {
        isDelimiterFind -> message.substring(leftIndex + leftDelimiter.length, rightIndex)
        leftDelimiter.isEmpty() && keyPattern.isNotEmpty() -> message
        else -> null
    }

    private val value: String? = searchTarget?.let { target ->
        if (keyPattern.isEmpty()) target else getKeyValueByPattern(target)
    }

    val isFind: Boolean
        get() = value != null

    fun getValue(): String {
        return value ?: throw NoSuchElementException("Can't find key in message")
    }

    private fun getKeyValueByPattern(keyValue: String): String {
        val find = this.keyPattern.toRegex().find(keyValue)
        val groupValues = find?.groupValues ?: listOf()
        if (groupValues.isEmpty()) {
            return ""
        }
        return groupValues[0]
    }
}
