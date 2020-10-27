import lombok.SneakyThrows;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Create by wl on 2020/9/1
 */
public class MyClassloader extends ClassLoader{

    @SneakyThrows
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        FileInputStream fileInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            fileInputStream=new FileInputStream(new File(name));
            byteArrayOutputStream=new ByteArrayOutputStream();
            int i;
            while ((i=fileInputStream.read())!=-1){
                byteArrayOutputStream.write(i);
            }
            byte[] classByte=byteArrayOutputStream.toByteArray();
           return defineClass(name,classByte,0,classByte.length);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            fileInputStream.close();
            byteArrayOutputStream.close();
        }
        return super.findClass(name);
    }

    public static void main(String[] args) {
        ClassLoader classLoader=new MyClassloader();
        try {
            classLoader.loadClass("C:/test.class");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
