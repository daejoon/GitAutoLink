package com.ddoong2.gitautolink.settings

import com.ddoong2.gitautolink.util.idGenerator
import com.intellij.ide.util.PropertiesComponent

object SettingStatus {
    private val URL_TEMPLATE_ID = idGenerator<SettingStatus>("urlTemplate")
    private val LEFT_DELIMITER_ID = idGenerator<SettingStatus>("leftDelimiter")
    private val RIGHT_DELIMITER_ID = idGenerator<SettingStatus>("rightDelimiter")

    var urlTemplate: String = ""
    var leftDelimiter: String = ""
    var rightDelimiter: String = ""

    fun save() {
        PropertiesComponent.getInstance().setValue(URL_TEMPLATE_ID, urlTemplate)
        PropertiesComponent.getInstance().setValue(LEFT_DELIMITER_ID, leftDelimiter)
        PropertiesComponent.getInstance().setValue(RIGHT_DELIMITER_ID, rightDelimiter)
    }

    fun load() {
        urlTemplate = PropertiesComponent.getInstance().getValue(URL_TEMPLATE_ID, "")
        leftDelimiter = PropertiesComponent.getInstance().getValue(LEFT_DELIMITER_ID, "")
        rightDelimiter = PropertiesComponent.getInstance().getValue(RIGHT_DELIMITER_ID, "")
    }
}