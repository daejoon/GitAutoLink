package com.ddoong2.gitautolink.settings

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.project.Project

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
        fun getInstance(project: Project): PersistentStateComponent<PluginState> {
            return project.getService(PluginSettingService::class.java)
        }
    }
}
