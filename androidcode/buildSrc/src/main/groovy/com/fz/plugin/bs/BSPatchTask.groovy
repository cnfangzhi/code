package com.fz.plugin.bs


import com.fz.plugin.utils.BSPatch
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class BSPatchTask extends DefaultTask {

    BSPatchTask() {
        group "bs"
    }

    @TaskAction
    void patch() {
        // 获取输入文件
        // 处理输出文件
        File oldFile = inputs.files.files[0] // inputs.getFiles().getFiles().getAt(0)
        File diffFile = inputs.files.files[1]
        File newFile = outputs.files.first()
        BSPatch.patchFast(oldFile, newFile, diffFile, 0)
        println "合并成功！！！"
    }

}