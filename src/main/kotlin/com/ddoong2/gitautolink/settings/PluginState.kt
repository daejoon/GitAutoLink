package com.ddoong2.gitautolink.settings

class PluginState(
    var urlTemplate: String = "",
    var leftDelimiter: String = "",
    var rightDelimiter: String = "",
    var keyPattern: String = "",
) {
    companion object {
        val EMPTY = PluginState()
    }

}
