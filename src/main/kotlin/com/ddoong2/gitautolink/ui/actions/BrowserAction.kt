package com.ddoong2.gitautolink.ui.actions

import com.ddoong2.gitautolink.data.KeyData
import com.ddoong2.gitautolink.settings.Setting
import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareAction
import com.intellij.vcs.log.VcsLogDataKeys

class BrowserAction : DumbAwareAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val vcsLog = e.getData(VcsLogDataKeys.VCS_LOG) ?: return
        val keyData = KeyData(message = vcsLog.selectedDetails[0].fullMessage)
        if (keyData.isFind) {
            openBrowse(Setting.urlTemplate, keyData)
        }
    }

    private fun openBrowse(urlTemplate: String, keyData: KeyData) {
        BrowserUtil.browse(urlTemplate.replace(KeyData.KEY, keyData.getValue()))
    }
}