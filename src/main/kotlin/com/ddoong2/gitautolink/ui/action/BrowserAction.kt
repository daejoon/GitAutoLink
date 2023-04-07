package com.ddoong2.gitautolink.ui.action

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareAction

class BrowserAction : DumbAwareAction() {
    override fun actionPerformed(e: AnActionEvent) {
        BrowserUtil.browse("https://google.co.kr")
    }
}