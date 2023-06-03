package com.ddoong2.gitautolink.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RegexTest {

    @Test
    fun `정규표현식으로 검색한다`() {

        // Given - 사전 조건 설정
        val regex = """(?<=#)[^\s]+""".toRegex()
        val message = "1234#MGTT-1234 "

        // When - 검증하려는 로직 실행
        val findResult = regex.find(message)?.value ?: ""

        // Then - 출력 확인
        assertThat(findResult).isNotEmpty
        assertThat(findResult).isEqualTo("MGTT-1234")
    }

}
