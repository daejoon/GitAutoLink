package com.ddoong2.gitautolink.ui.actions

import com.ddoong2.gitautolink.data.KeyData
import com.ddoong2.gitautolink.settings.PluginSettingService
import com.ddoong2.gitautolink.settings.PluginState
import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareAction
import com.intellij.openapi.project.Project
import com.intellij.vcs.log.VcsLogCommitSelection
import com.intellij.vcs.log.VcsLogDataKeys

class BrowserAction : DumbAwareAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val pluginState = getPluginState(project) ?: return
        val vcsLog = getVcsLogCommitSelection(e) ?: return
        val keyData = KeyData(
                message = vcsLog.cachedFullDetails[0].fullMessage,
                leftDelimiter = pluginState.leftDelimiter,
                rightDelimiter = pluginState.rightDelimiter,
        )

        if (keyData.isFind) {
            openBrowse(pluginState.urlTemplate, keyData)
        }
    }

    override fun update(e: AnActionEvent) {
        val project = e.project ?: return
        val pluginState = getPluginState(project) ?: return
        val vcsLog = getVcsLogCommitSelection(e) ?: return
        val keyData = KeyData(
                message = vcsLog.cachedFullDetails[0].fullMessage,
                leftDelimiter = pluginState.leftDelimiter,
                rightDelimiter = pluginState.rightDelimiter,
        )

        e.presentation.isEnabled = keyData.isFind
    }

    private fun openBrowse(urlTemplate: String, keyData: KeyData) {
        BrowserUtil.browse(urlTemplate.replace(KeyData.KEY, keyData.getValue()))
    }

    private fun getPluginState(project: Project): PluginState? =
            PluginSettingService.getInstance(project).state

    private fun getVcsLogCommitSelection(e: AnActionEvent): VcsLogCommitSelection? =
            e.getData(VcsLogDataKeys.VCS_LOG_COMMIT_SELECTION)
}