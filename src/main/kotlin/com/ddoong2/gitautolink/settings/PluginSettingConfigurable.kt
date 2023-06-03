package com.ddoong2.gitautolink.settings

import com.intellij.openapi.options.BoundConfigurable
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.dsl.builder.*


class PluginSettingConfigurable(
        private val project : Project
) : BoundConfigurable("GitAutoLink") {

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
            row("Left Key Delimiter:") {
                textField()
                        .columns(COLUMNS_TINY)
                        .bindText(model::leftDelimiter)
            }
            row("Right Key Delimiter:") {
                textField()
                        .columns(COLUMNS_TINY)
                        .bindText(model::rightDelimiter)
                comment("""If value is empty, search for ' '""")
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
            PluginSettingService
                    .getInstance(project)
                    .loadState(model.toPluginState())
        }
    }

    override fun reset() {
        val state = PluginSettingService.getInstance(project).state ?: PluginState.EMPTY
        model.updateFromPluginState(state)
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
    ) {
        fun toPluginState(): PluginState {
            return PluginState(
                    urlTemplate = urlTemplate,
                    leftDelimiter = leftDelimiter,
                    rightDelimiter = rightDelimiter,
            )
        }

        fun updateFromPluginState(state: PluginState) {
            urlTemplate = state.urlTemplate
            leftDelimiter = state.leftDelimiter
            rightDelimiter = state.rightDelimiter
        }
    }
}