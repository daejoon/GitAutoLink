package com.ddoong2.gitautolink.ui.actions

import com.ddoong2.gitautolink.data.KeyData
import com.ddoong2.gitautolink.settings.SettingStatus
import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareAction
import com.intellij.vcs.log.VcsLogDataKeys

class BrowserAction : DumbAwareAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val vcsLog = e.getData(VcsLogDataKeys.VCS_LOG) ?: return

        val keyData = KeyData(
            message = vcsLog.selectedDetails[0].fullMessage,
            leftDelimiter = SettingStatus.leftDelimiter,
            rightDelimiter = SettingStatus.rightDelimiter,
        )

        if (keyData.isFind) {
            openBrowse(SettingStatus.urlTemplate, keyData)
        }
    }

    override fun update(e: AnActionEvent) {
        super.update(e)

        val vcsLog = e.getData(VcsLogDataKeys.VCS_LOG) ?: return
        val keyData = KeyData(
                message = vcsLog.selectedDetails[0].fullMessage,
                leftDelimiter = SettingStatus.leftDelimiter,
                rightDelimiter = SettingStatus.rightDelimiter,
        )

        e.presentation.isEnabled = keyData.isFind
    }

    private fun openBrowse(urlTemplate: String, keyData: KeyData) {
        BrowserUtil.browse(urlTemplate.replace(KeyData.KEY, keyData.getValue()))
    }
}