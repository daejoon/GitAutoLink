package com.ddoong2.gitautolink.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
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
