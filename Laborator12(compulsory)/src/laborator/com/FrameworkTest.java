package laborator.com;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Method;

public class FrameworkTest extends Component {
    private File loadFile(){
        JFileChooser openFileChooser = new JFileChooser();
        openFileChooser.setCurrentDirectory(new File("d:\\classes"));
        openFileChooser.setFileFilter(new FileNameExtensionFilter("Class files","class"));
        int returnValue = openFileChooser.showOpenDialog(this);
        return openFileChooser.getSelectedFile();
    }
    public static void main(String[] args) throws Exception {
        FrameworkTest frameworkTest = new FrameworkTest();
        File file = frameworkTest.loadFile();
        String fullPath = file.getAbsolutePath();
        System.out.println(fullPath);
        MyClassLoader cl = new MyClassLoader();
        int dotsFullPath=0;
        StringBuilder stringBuilderFullPath = new StringBuilder(fullPath);
        for(int index=0;index<stringBuilderFullPath.length();index++)
        {
            if(stringBuilderFullPath.charAt(index)=='\\')
            {
                //inlocuim backslash cu punct;
                stringBuilderFullPath.setCharAt(index,'.');
                dotsFullPath++;
            }
        }
        int dotsUrl=0;
        int dotsClassName=0;
        StringBuilder urlPath;
        StringBuilder classPath;
        String[] array = stringBuilderFullPath.toString().split(".");
        System.out.println("words");
        System.out.println(array[0]);
        while(dotsUrl<dotsFullPath)
        {
            urlPath = new StringBuilder();

        }
        int passed = 0, failed = 0;
        for (Method m : Class.forName(args[0]).getMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",
                            m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }
}
