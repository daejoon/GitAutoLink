package com.ddoong2.gitautolink.settings

import com.ddoong2.gitautolink.util.idGenerator
import com.intellij.ide.util.PropertiesComponent

object Setting {
    private val URL_TEMPLATE_ID = idGenerator<Setting>("urlTemplate")

    var urlTemplate: String
        get() = PropertiesComponent.getInstance().getValue(URL_TEMPLATE_ID, "")
        set(value) {
            PropertiesComponent.getInstance().setValue(URL_TEMPLATE_ID, value)
        }
}