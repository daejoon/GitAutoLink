package com.ddoong2.gitautolink.settings

import com.ddoong2.gitautolink.util.idGenerator
import com.intellij.ide.util.PropertiesComponent

object SettingStatus {
    private val URL_TEMPLATE_ID = idGenerator<SettingStatus>("urlTemplate")
    private val LEFT_DELIMITER_ID = idGenerator<SettingStatus>("leftDelimiter")
    private val RIGHT_DELIMITER_ID = idGenerator<SettingStatus>("rightDelimiter")

    var urlTemplate: String
        get() = PropertiesComponent.getInstance().getValue(URL_TEMPLATE_ID, "")
        set(value) {
            PropertiesComponent.getInstance().setValue(URL_TEMPLATE_ID, value)
        }

    var leftDelimiter: String
        get() = PropertiesComponent.getInstance().getValue(LEFT_DELIMITER_ID, "")
        set(value) {
            PropertiesComponent.getInstance().setValue(LEFT_DELIMITER_ID, value)
        }

    var rightDelimiter: String
        get() = PropertiesComponent.getInstance().getValue(RIGHT_DELIMITER_ID, "")
        set(value) {
            PropertiesComponent.getInstance().setValue(RIGHT_DELIMITER_ID, value)
        }
}