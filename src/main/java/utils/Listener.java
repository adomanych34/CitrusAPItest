package utils;

import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static utils.RestPath.filePath;

public class Listener implements ITestListener {
    private Logger logger;
    private Logger loggerForInfo = new LoggerInfoConfig(Listener.class.getName()).loggerConfig();
    private static ByteArrayOutputStream context;
    public static PrintStream contextPrint;

    public void onTestStart(ITestResult result) {
        loggerForInfo.info("Tets " + result.getName() + " starts");
        context = new ByteArrayOutputStream();
        contextPrint = new PrintStream(context, true);

        try {
            logger = new LoggerFileConfig(result.getName()).loggerConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSuccess(ITestResult result) {
        loggerForInfo.info("Test " + result.getName() + " is success");
        logger.debug(context);
        attach(result.getName());

    }

    public void onTestFailure(ITestResult result) {
        loggerForInfo.error("Test " + result.getName() + " failed");
        logger.fatal(result.getName() + "Failed", result.getThrowable());
        attach(result.getName());

    }

    private void attach(String fileName) {
        try {
            addFile(filePath + fileName + ".log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "My attach", type = "text/plain")
    private byte[] addFile(String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }


}