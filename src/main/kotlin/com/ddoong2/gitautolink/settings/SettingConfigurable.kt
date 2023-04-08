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
        return (Setting.urlTemplate == settingForm.urlTemplate.text).not()
                || (Setting.leftDelimeter == settingForm.leftDelimeter.text).not()
                || (Setting.rightDelimeter == settingForm.rightDelimeter.text).not()
    }

    override fun apply() {
        if (isModified) {
            validate()
            Setting.apply {
                urlTemplate = settingForm.urlTemplate.text
                leftDelimeter = settingForm.leftDelimeter.text
                rightDelimeter = settingForm.rightDelimeter.text
            }
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