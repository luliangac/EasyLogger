package cn.luliang.easylogger.core.classloader;

import cn.luliang.easylogger.core.Constants;
import cn.luliang.easylogger.core.util.JarUtil;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 加载logger的class loader.
 * Created by luliang on 16/1/14.
 */
public class EasyLoggerClassLoader extends ClassLoader {

    private static String BASE_PATH = "/tmp";

    private ConcurrentHashMap<String, Class<?>> classes = new ConcurrentHashMap<String, Class<?>>();

    public EasyLoggerClassLoader() {

        resourcePrepare();
    }

    // 负责准备资源;
    private void resourcePrepare(){
        try {
            JarUtil.extractJarFile(BASE_PATH, BASE_PATH + File.separator + Constants.LOGBACK_CORE_JAR, ".class");
            JarUtil.extractJarFile(BASE_PATH, BASE_PATH + File.separator + Constants.LOGBACK_CLASSIC_JAR, ".class");
            JarUtil.extractJarFile(BASE_PATH, BASE_PATH + File.separator + Constants.SLF4J_JAR, ".class");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {

        // First, check if the class has already been loaded

        Class c = null;
        // findLoadedClass
        if(classes.containsKey(name)) {
            return classes.get(name);
        }

        if(name.startsWith(Constants.CLASSIC_PREFIX) || name.startsWith(Constants.CORE_PREFIX)
                || name.startsWith(Constants.SLF4J_PREFIX)) {
            c = findClass(name);
        } else {
            // parent AppClassLoader load the class;
            return super.loadClass(name, resolve);
        }

        if (resolve) {

            resolveClass(c);

        }

        return c;

    }

    public Class<?> findClass(String name) throws ClassNotFoundException {

        // 去加载jar包中的class;
        if(name == "" || name == null) {
            return null;
        }

        String namePath = name.replace(".", "/");
        String classPath = BASE_PATH + File.separator + namePath + ".class";
        InputStream is = null;
        ByteArrayOutputStream os = null;
        try {
            is = new FileInputStream(new File(classPath));
            os = new ByteArrayOutputStream();
            int b = 0;
            while ((b = is.read()) != -1) {
                os.write(b);
            }
            byte[] bytes = os.toByteArray();
            os.flush();
            Class clazz = defineClass(name, bytes, 0, bytes.length);
            classes.put(name, clazz);
            return clazz;
        } catch (Exception e) {
//            e.printStackTrace();
        }finally{
            try {
                if(os!=null)
                    os.close();
                if(is!=null)
                    is.close();
            } catch (IOException e1) {
                os=null;
                is = null;
            }
        }
        return null;
    }
}
