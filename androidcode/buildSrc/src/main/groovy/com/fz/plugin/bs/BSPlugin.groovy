package com.fz.plugin.bs

import org.gradle.api.Plugin
import org.gradle.api.Project

class BSPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.afterEvaluate {
            project.task(type: BSDiffTask, "diff") {
                // 实现diff任务
//                inputs.files "${project.buildDir}/test/hello.txt", "${project.buildDir}/test/hello_v2.txt"
//                outputs.files "${project.buildDir}/test/path"

                inputs.files project.getProperties().get("oldFile"), project.getProperties().get("newFile")
                outputs.files project.getProperties().get("diffFile")

                /*inputs.files project.getExtensions().findByName("oldFile"), project.getExtensions().findByName("newFile")
                outputs.files project.getExtensions().findByName("diffFile")*/
            }
        }

        project.afterEvaluate {
            project.task(type: BSPatchTask, "patch") {
                inputs.files project.getProperties().get("oldFile"), project.getProperties().get("diffFile")
                outputs.files project.getProperties().get("newFile")

//                inputs.files project.getExtensions().findByName("oldFile"), project.getExtensions().findByName("diffFile")
//                outputs.files project.getExtensions().findByName("newFile")
            }
        }
    }

}