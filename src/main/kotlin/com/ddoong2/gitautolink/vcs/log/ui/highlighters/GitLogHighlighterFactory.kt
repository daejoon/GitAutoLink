package com.ddoong2.gitautolink.vcs.log.ui.highlighters

import com.intellij.vcs.log.VcsLogHighlighter
import com.intellij.vcs.log.VcsLogUi
import com.intellij.vcs.log.data.VcsLogData
import com.intellij.vcs.log.ui.highlighters.VcsLogHighlighterFactory

class GitLogHighlighterFactory : VcsLogHighlighterFactory {
    companion object {
        private const val GAL_LOG_HIGHLIGHTER_FACTORY_ID = "GitLogHighlighterFactoryId"
        private const val GAL_LOG_HIGHLIGHTER_FACTORY_TITLE = "GitLogHighlighterFactoryTitle"
    }

    override fun createHighlighter(logData: VcsLogData, logUi: VcsLogUi): VcsLogHighlighter {
        return GitLogHighlighter(logData, logUi)
    }

    override fun getId(): String {
        return GAL_LOG_HIGHLIGHTER_FACTORY_ID
    }

    override fun getTitle(): String {
        return GAL_LOG_HIGHLIGHTER_FACTORY_TITLE
    }

    override fun showMenuItem(): Boolean {
        return true
    }
}