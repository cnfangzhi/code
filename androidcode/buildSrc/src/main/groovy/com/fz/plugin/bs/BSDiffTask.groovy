package com.fz.plugin.bs

import com.fz.plugin.utils.BSDiff
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class BSDiffTask extends DefaultTask {

    BSDiffTask() {
        group "bs"
    }

    @TaskAction
    void patch() {
        // 获取输入文件
        // 处理输出文件
        File oldFile = inputs.files.files[0] // inputs.getFiles().getFiles().getAt(0)
        File newFile = inputs.files.files[1]
        File diffFile = outputs.files.first()
        println diffFile.getAbsolutePath()
        BSDiff.bsdiff(oldFile, newFile, diffFile)
        println "差分打包完成了！！"
    }

}