package com.ddoong2.gitautolink.vcs.log.ui.highlighters

import com.intellij.openapi.diagnostic.logger
import com.intellij.vcs.log.*
import com.intellij.vcs.log.VcsLogHighlighter.VcsCommitStyle
import com.intellij.vcs.log.data.VcsLogData

class GitLogHighlighter(
    private val logData: VcsLogData,
    private val logUi: VcsLogUi
) : VcsLogHighlighter {

    companion object {
        private val LOG = logger<GitLogHighlighter>()
    }

    override fun getStyle(
        commitId: Int,
        commitDetails: VcsShortCommitDetails,
        column: Int,
        isSelected: Boolean
    ): VcsCommitStyle {
        LOG.warn("id:(${commitId}), detail:(${commitDetails.subject}), column:(${column}), isSelected:(${isSelected})")

        return VcsCommitStyleFactory.createStyle(null, null, VcsLogHighlighter.TextStyle.ITALIC)
    }

    override fun update(dataPack: VcsLogDataPack, refreshHappened: Boolean) {
        LOG.warn("####Update")
    }
}