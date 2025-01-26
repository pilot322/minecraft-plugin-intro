import java.io.*;
import java.nio.file.*;

public class McScriptInjector {
    public static void injectScript(String mcscriptPath, String templatePath, String outputPath) throws IOException {
        // Read the .mcscript file
        String scriptContent = new String(Files.readAllBytes(Paths.get(mcscriptPath)));

        // Transform .mcscript into Java-compatible code
        String transformedCode = transformScript(scriptContent);

        // Read the Java template
        String templateContent = new String(Files.readAllBytes(Paths.get(templatePath)));

        // Inject the transformed code into the template
        String finalSource = templateContent.replace("// INJECTED_CODE_PLACEHOLDER", transformedCode);

        // Write the final source code to the output file
        Files.write(Paths.get(outputPath), finalSource.getBytes());

        System.out.println("Code injected successfully into " + outputPath);
    }

    private static String transformScript(String scriptContent) {
        // Transform /commands to Bukkit.dispatchCommand
        StringBuilder javaCode = new StringBuilder();
        for (String line : scriptContent.split("\n")) {
            if (line.trim().startsWith("/")) {
                String command = line.trim().substring(1); // Remove leading '/'
                javaCode.append("Bukkit.dispatchCommand(Bukkit.getConsoleSender(), \"")
                        .append(command).append("\");\n");
            } else {
                javaCode.append(line).append("\n");
            }
        }
        return javaCode.toString();
    }

    public static void main(String[] args) throws IOException {
        injectScript("../script.mcscript", "PluginTemplate.java", "MySpigotPlugin.java");
    }
}
