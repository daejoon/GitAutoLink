package com.ddoong2.gitautolink.settings

import com.ddoong2.gitautolink.util.idGenerator
import com.intellij.openapi.options.SearchableConfigurable
import javax.swing.JComponent



class SettingConfigurable : SearchableConfigurable {

    private val id = idGenerator<SettingConfigurable>()
    private val displayName = "GitAutoLink"
    private val settingForm = SettingForm()
    override fun createComponent(): JComponent? {
        return settingForm.panel
    }

    override fun isModified(): Boolean {
        val oldUrlTemplate = Setting.urlTemplate
        val newUrlTemplate = settingForm.urlTemplate.text
        return oldUrlTemplate.equals(newUrlTemplate, ignoreCase = true).not()
    }

    override fun apply() {
        if (isModified) {
            validate()
            Setting.urlTemplate = settingForm.urlTemplate.text
        }
    }

    override fun reset() {
        settingForm.resetFrom(Setting)
    }

    override fun getDisplayName(): String {
        return displayName
    }

    override fun getId(): String {
        return id
    }

    override fun enableSearch(option: String?): Runnable? {
        return null
    }

    private fun validate() {
    }
}