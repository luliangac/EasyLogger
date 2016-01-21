package cn.luliang.easylogger.core.util;

import cn.luliang.easylogger.core.Constants;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by luliang on 16/1/19.
 */
public class JarUtil {

    private static int DEFAULT_BUFFER_SIZE = 4 * 1024;

    public static File extractJarFile(String localDest, String jarFilePath, String suffix) throws IOException {

        JarFile jarFile = new JarFile(jarFilePath);
        for (Enumeration<JarEntry> enums = jarFile.entries(); enums.hasMoreElements();) {
            JarEntry entry = (JarEntry) enums.nextElement();
            String fileName = localDest + File.separator + entry.getName();
            File f = new File(fileName);
            if(f.exists()) {
                continue;
            }
            if (!entry.isDirectory() && entry.getName().endsWith(suffix)) {
                f.getParentFile().mkdirs();
                InputStream is = jarFile.getInputStream(entry);
                FileOutputStream fos = new FileOutputStream(f);
                try {
                    copyStream(is, fos);
                } finally {
                    fos.close();
                    is.close();
                }
            }
        }
        jarFile.close();
        return null;
    }

    private static void copyStream(InputStream is, OutputStream out) throws IOException {
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        int n = 0;
        while (-1 != (n = is.read(buffer))) {
            out.write(buffer, 0, n);
        }
    }

    public static void main(String[] args) throws Exception {

        String jarPath = JarUtil.class.getClassLoader().getResource(Constants.LOGBACK_CORE_JAR).toURI().toString();
        jarPath = jarPath.substring(jarPath.indexOf(":") + 1);
        JarFile jarFile = new JarFile(jarPath);
        for (Enumeration<JarEntry> enums = jarFile.entries(); enums.hasMoreElements();) {
            JarEntry entry = (JarEntry) enums.nextElement();
            System.out.println(entry.getName());
        }

    }


}
