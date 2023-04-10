package com.ddoong2.gitautolink.settings

import com.intellij.openapi.options.BoundConfigurable
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.dsl.builder.*


class SettingConfigurable : BoundConfigurable("GitAutoLink") {

    private lateinit var panel: DialogPanel
    private val displayName = "GitAutoLink"
    private var model = Model()

    override fun createPanel(): DialogPanel {
        panel = panel {
            row("URL Template:") {
                textField()
                        .columns(COLUMNS_LARGE + 10)
                        .comment(
                                "Perform a search on a website and copy the resulting URL.\n" +
                                        "Replace your search term with {key} in curly brackets\n" +
                                        "e.g. https://en.dict.naver.com/#/search?query={key}"
                        )
                        .bindText(model::urlTemplate)
            }
            row("Left Key Delimeter:") {
                textField()
                        .columns(COLUMNS_TINY)
                        .bindText(model::leftDelimiter)
            }
            row("Right Key Delimeter:") {
                textField()
                        .columns(COLUMNS_TINY)
                        .bindText(model::rightDelimiter)
            }
        }

        return panel;
    }

    override fun isModified(): Boolean {
        return panel.isModified()
    }

    override fun apply() {
        if (isModified) {
            validate()
            panel.apply()
            SettingStatus.apply {
                urlTemplate = model.urlTemplate
                leftDelimiter = model.leftDelimiter
                rightDelimiter = model.rightDelimiter
                save()
            }
        }
    }

    override fun reset() {
        model.apply {
            SettingStatus.load()
            urlTemplate = SettingStatus.urlTemplate
            leftDelimiter = SettingStatus.leftDelimiter
            rightDelimiter = SettingStatus.rightDelimiter
        }
        panel.reset()
    }

    override fun getDisplayName(): String {
        return displayName
    }

    private fun validate() {
    }

    internal data class Model(
            var urlTemplate: String = "",
            var leftDelimiter: String = "",
            var rightDelimiter: String = "",
    )

}