package com.ddoong2.gitautolink.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GeneratorKtTest {

    @Test
    fun `키를 생성한다`() {

        // Given - 사전 조건 설정
        // When - 검증하려는 로직 실행
        val idGenerator = idGenerator<GeneratorKtTest>()
        val idGeneratorName = idGenerator<GeneratorKtTest>("testName")

        // Then - 출력 확인
        assertThat(idGenerator).isEqualTo("com.ddoong2.gitautolink.util.GeneratorKtTest")
        assertThat(idGeneratorName).isEqualTo("com.ddoong2.gitautolink.util.GeneratorKtTest.testName")
    }
}