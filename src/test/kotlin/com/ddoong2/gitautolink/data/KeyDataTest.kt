package com.ddoong2.gitautolink.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class KeyDataTest {

    @Test
    fun `isFind`() {

        assertFindIsTrue(KeyData("[test]", "[", "]"))
        assertFindIsTrue(KeyData("(#test)", "(#", ")"))
        assertFindIsTrue(KeyData("(test#)", "(", "#)"))
        assertFindIsTrue(KeyData("#test ", "#", ""))
    }

    @Test
    fun `isFind - is empty`() {

        assertFindIsFalse(KeyData("test", "", "]"))
        assertFindIsFalse(KeyData("test", "[", ""))
    }

    @Test
    fun `getValue`() {
        assertEqualValue("test", KeyData("[test]", "[", "]"))
        assertEqualValue("test", KeyData("(#test) 추가 내용 입니다.", "(#", ")"))
        assertEqualValue("test", KeyData("(test#) 추가 내용 입니다.", "(", "#)"))
        assertEqualValue("test", KeyData("시작 메세지 (test#) 추가 내용 입니다.", "(", "#)"))
        assertEqualValue("TEST-1234", KeyData("시작 메세지 (feature/TEST-1234) 추가 내용 입니다.", "(", ")", "\\w+-\\d+"))
    }

    @Test
    fun `getValue - 구분자 없이 Key Pattern만 있으면 메시지 전체에서 찾는다`() {
        val keyData = KeyData("Fix login bug MRKT-1234 for mobile", "", "", "MRKT-\\d+")

        assertFindIsTrue(keyData)
        assertEqualValue("MRKT-1234", keyData)
        assertEqualValue("1234", KeyData("Fix login bug #1234", "", "", "\\d+"))
    }

    @Test
    fun `isFind - Key Pattern이 매칭되지 않으면 찾지 못한다`() {
        assertFindIsFalse(KeyData("Fix login bug for mobile", "", "", "MRKT-\\d+"))
        assertFindIsFalse(KeyData("[feature/login] Fix bug", "[", "]", "MRKT-\\d+"))
    }

    @Test
    fun `getValue - is empty`() {
        assertEmptyThrownNoSuchElementException(KeyData("test", "", "]"))
        assertEmptyThrownNoSuchElementException(KeyData("test", "[", ""))
    }

    private fun assertFindIsTrue(keyData: KeyData) {
        assertThat(keyData.isFind).isTrue()
    }

    private fun assertFindIsFalse(keyData: KeyData) {
        assertThat(keyData.isFind).isFalse()
    }

    private fun assertEqualValue(expected: String, keyData: KeyData) {
        assertEquals(expected, keyData.getValue())
    }

    private fun assertEmptyThrownNoSuchElementException(keyData: KeyData) {
        assertThrows(NoSuchElementException::class.java) {
            keyData.getValue()
        }
    }
}
