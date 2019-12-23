package com;

import java.io.*;

/**
 * TODO
 *
 * @Author FJJ
 * @Date 2018/12/16
 */
public class CopySvnFiles {


    public static void main(String[] args) {

        try {
           // copy2Process4Monitor();
//            copy2Process4Metrics();
            copy2Process4Zpaas();
        }
        catch (Exception e) {

            System.out.println();
            e.printStackTrace();

        }

    }

    public static void copy2Process4Zpaas() {

        try {
            String path = "E:/paasFile.TXT";
            File file = new File(path);

            String sourcePath = "E:\\hunanbendi";

            String trunkPath = "E:\\vision\\1624996\\branches\\PaaS_Layer\\ZCM\\01Core\\code\\zcm-paas2ctch";

            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String s = "";
            while ((s = br.readLine()) != null) {

                if (!s.endsWith("/") && (s.trim().endsWith(".java") || s.trim().endsWith(".xml"))) {

                    File oldFile = new File(sourcePath + s.substring(s.indexOf("/src")));

                    String fullPath = trunkPath + s.substring(s.indexOf("/src"));

                    File newFile = new File(fullPath);

                    File dir = newFile.getParentFile();
                    if (!dir.exists()) {
                        newFile.getParentFile().mkdirs();
                    }

                    System.out.println(fullPath);
                    copyFile(oldFile, newFile);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copy2Process4Monitor() {

        try {
            String path = "F:/1.TXT";
            File file = new File(path);

            String sourcePath = "E:\\monitring\\zcm-monitor";

            String trunkPath = "E:\\processTrunk\\1614182\\branches\\PaaS_Layer\\ZCM\\01Core\\code\\zcm-monitor";

            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String s = "";
            while ((s = br.readLine()) != null) {

                if (!s.endsWith("/") && (s.trim().endsWith(".java") || s.trim().endsWith(".xml"))) {

                    File oldFile = new File(sourcePath + s.substring(s.indexOf("/src")));

                    String fullPath = trunkPath + s.substring(s.indexOf("/src"));

                    File newFile = new File(fullPath);

                    File dir = newFile.getParentFile();
                    if (!dir.exists()) {
                        newFile.getParentFile().mkdirs();
                    }

                    System.out.println(fullPath);
                    copyFile(oldFile, newFile);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void copy2Process4Metrics() {

        try {
            String path = "F:/1.TXT";
            File file = new File(path);

            String sourcePath = "E:\\monitring\\zcm-metrics";

            String trunkPath = "E:\\processTrunk\\1562784\\branches\\PaaS_Layer\\ZCM\\01Core\\code\\zcm-metrics";

            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String s = "";
            while ((s = br.readLine()) != null) {

                if (!s.endsWith("/") && (s.trim().endsWith(".java") || s.trim().endsWith(".xml"))) {

                    File oldFile = new File(sourcePath + s.substring(s.indexOf("/src")));

                    String fullPath = trunkPath + s.substring(s.indexOf("/src"));

                    File newFile = new File(fullPath);

                    File dir = newFile.getParentFile();
                    if (!dir.exists()) {
                        newFile.getParentFile().mkdirs();
                    }

                    System.out.println(fullPath);
                    copyFile(oldFile, newFile);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void copyFile(File sourceFile, File targetFile) throws Exception {
        try {
            if ((null == sourceFile) || !sourceFile.exists()) {
                return;
            }
            //目标路径不存在则建目录
            targetFile.getParentFile().mkdirs();

            BufferedInputStream inBuff = null;
            BufferedOutputStream outBuff = null;
            try {
                // 新建文件输入流并对它进行缓冲
                inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

                // 新建文件输出流并对它进行缓冲
                outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

                // 缓冲数组
                byte[] b = new byte[1024 * 8];
                int len;
                while ((len = inBuff.read(b)) != -1) {
                    outBuff.write(b, 0, len);
                }
                // 刷新此缓冲的输出流
                outBuff.flush();
            }
            finally {
                // 关闭流
                if (inBuff != null) {
                    inBuff.close();
                }
                if (outBuff != null) {
                    outBuff.close();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
