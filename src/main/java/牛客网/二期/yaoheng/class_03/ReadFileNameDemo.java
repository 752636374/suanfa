package 牛客网.二期.yaoheng.class_03;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadFileNameDemo {

    public static void main(String[] args) {

        printFileName("/Users/yaoheng5/Desktop/项目文档/项目文档/东莞/白衣可涵形象资源");
        System.out.println("--------");
//        printFileName("/Users/yaoheng5/Desktop/项目文档/项目文档/东莞/男生小铄形象资源");
    }

    private static void printFileName(String name) {
        File folder = new File(name); // 指定文件夹路径

        List<String> onlines = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles(); // 获取文件夹中的文件列表
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) { // 判断是否为文件
                        String fileName = file.getName(); // 获取文件名
                        if(fileName.contains("online")){
                            onlines.add(fileName);
                        }else {
                            list.add(fileName);
                        }
                    }
                }
            }
        }

        printList(onlines);
        printList(list);
    }

    private static void printList(List<String> onlines) {
        for(String s:onlines){
            System.out.println(s);
        }
    }
}
