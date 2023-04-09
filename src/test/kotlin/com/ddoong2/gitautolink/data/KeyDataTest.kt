package com.ddoong2.gitautolink.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class KeyDataTest {

    @Test
    fun `isFind`() {
        val keyData = KeyData("[test]", "[", "]")

        assertThat(keyData.isFind).isTrue()
    }

    @Test
    fun `isFind - left is empty`() {
        val keyData = KeyData("test", "", "]")
        assertThat(keyData.isFind).isFalse()
    }

    @Test
    fun `isFind - right is empty`() {
        val keyData = KeyData("test", "[", "")
        assertThat(keyData.isFind).isFalse()
    }

    @Test
    fun `getValue`() {
        val keyData = KeyData("[test]", "[", "]")
        assertEquals("test", keyData.getValue())
    }

    @Test
    fun `getValue - left is empty`() {
        val keyData = KeyData("test", "", "]")
        assertThrows(NoSuchElementException::class.java) {
            keyData.getValue()
        }
    }

    @Test
    fun `getValue - right is empty`() {
        val keyData = KeyData("test", "[", "")
        assertThrows(NoSuchElementException::class.java) {
            keyData.getValue()
        }
    }
}