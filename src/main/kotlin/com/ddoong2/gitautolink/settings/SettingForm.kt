package com.ddoong2.gitautolink.settings

import javax.swing.JPanel
import javax.swing.JTextField

class SettingForm {

    lateinit var panel: JPanel
    lateinit var urlTemplate: JTextField
    lateinit var leftDelimeter: JTextField
    lateinit var rightDelimeter: JTextField

    fun resetFrom(setting: Setting) {
        urlTemplate.text = setting.urlTemplate
        leftDelimeter.text = setting.leftDelimeter
        rightDelimeter.text = setting.rightDelimeter
    }
}