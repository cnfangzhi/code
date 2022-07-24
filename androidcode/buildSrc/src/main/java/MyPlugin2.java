import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.tasks.bundling.Zip;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MyPlugin2 implements Plugin<Project> {

    @Override
    public void apply(Project target) {
        target.afterEvaluate(project -> {
            System.out.println(project.getTasks().getByName("packageDebug"));
            Map<String, Class<?>> type = new HashMap<>();
            type.put("type", Zip.class);
            Zip zipDebug2 = (Zip) target.task(type, "zipDebug2");
            zipDebug2.setArchiveName("outputs5.zip");
            zipDebug2.setDestinationDir(new File(target.getBuildDir().getAbsolutePath()+"/custom"));
            zipDebug2.from(target.getTasks().getByName("packageDebug").getOutputs().getFiles());
        });
    }

}
