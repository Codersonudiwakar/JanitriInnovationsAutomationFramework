package com.Janitri.Innovations.utils;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class ReportGenerator {

	 public static void copyTestNGReport() {
	        String sourcePath = "test-output/index.html";
	        LocalDateTime now = LocalDateTime.now();
	        String filenameTimestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
	        String destFileName = "JanitriInnovationsTestReports" + filenameTimestamp + ".html";
	        String destPath = "Reports/" + destFileName;
	        try {
	            Files.createDirectories(Paths.get("report"));
	            Files.copy(Paths.get(sourcePath), Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
