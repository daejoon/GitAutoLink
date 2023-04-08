package com.ddoong2.gitautolink.settings

import com.ddoong2.gitautolink.util.idGenerator
import com.intellij.ide.util.PropertiesComponent

object Setting {
    private val URL_TEMPLATE_ID = idGenerator<Setting>("urlTemplate")
    private val LEFT_DELIMETER_ID = idGenerator<Setting>("leftDelimeter")
    private val RIGHT_DELIMETER_ID = idGenerator<Setting>("rightDelimeter")

    var urlTemplate: String
        get() = PropertiesComponent.getInstance().getValue(URL_TEMPLATE_ID, "")
        set(value) {
            PropertiesComponent.getInstance().setValue(URL_TEMPLATE_ID, value)
        }

    var leftDelimeter: String
        get() = PropertiesComponent.getInstance().getValue(LEFT_DELIMETER_ID, "")
        set(value) {
            PropertiesComponent.getInstance().setValue(LEFT_DELIMETER_ID, value)
        }

    var rightDelimeter: String
        get() = PropertiesComponent.getInstance().getValue(RIGHT_DELIMETER_ID, "")
        set(value) {
            PropertiesComponent.getInstance().setValue(RIGHT_DELIMETER_ID, value)
        }
}