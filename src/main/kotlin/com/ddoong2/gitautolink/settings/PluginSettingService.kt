package com.ddoong2.gitautolink.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State

@State(
        name = "com.ddoong2.gitautolink.settings.PluginState",
        storages = [com.intellij.openapi.components.Storage("GitAutoLink.xml")]
)
class PluginSettingService : PersistentStateComponent<PluginState> {

    private var pluginState = PluginState.EMPTY

    override fun getState(): PluginState? {
        return pluginState
    }

    override fun loadState(state: PluginState) {
        pluginState = state
    }

    companion object {
        @JvmStatic
        fun getInstance(): PersistentStateComponent<PluginState> {
            return ApplicationManager.getApplication().getService(PluginSettingService::class.java)
        }
    }
}