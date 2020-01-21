package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.sun.jna.Native;
import com.sun.jna.Library;
import java.io.*;

import com.example.demo.lib.Moves;
import com.example.demo.lib.ExtMoves;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        DemoApplication cmd=new DemoApplication();
        try {
            System.out.println("begin run");
            cmd.CmdTestDll();
            System.out.println("after run");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CmdTestDll() throws IOException {

        Moves input = new Moves();
        ExtMoves outPut = new ExtMoves();
        String filePath = "C:\\Users\\kangzhijie\\Desktop\\engine\\config.txt";
        CmdTestDll.testDll.Init(filePath);
//        CmdTestDll.testDll.CollectMoves(input, outPut);
        System.out.printf("outPut num::" + outPut.num + "\n");

        // 读取lib文件
        String inputFile = "C:\\Users\\kangzhijie\\Desktop\\engine\\lib\\d3.lib";
        String outputFile = "C:\\Users\\kangzhijie\\Desktop\\engine\\lib\\2.lib";
        CmdTestDll.testDll.Scan(input, inputFile, outputFile);

//        File file = new File(fileName);
//        FileInputStream fi = new FileInputStream(file);
//        ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
//        byte[] b = new byte[1024];
//        int n = 0;
//        while ((n = fi.read(b)) != -1) {
//            bos.write(b, 0, n);
//        }
//        fi.close();
//        byte[] inputFile = bos.toByteArray();
//        byte[] outFile = new byte[1024];
//        CmdTestDll.testDll.Scan(input, fileName, fileName1);
    }
}



interface CmdTestDll extends Library {
    CmdTestDll testDll  = (CmdTestDll)Native.loadLibrary("enginedll",CmdTestDll.class);

    void Init(String filePath);
    void CollectMoves(Moves input,ExtMoves output);
//    void Scan(Moves input, byte[] inputFile, byte[] outPutFile);
    void Scan(Moves input, String inputFile, String outPutFile);

}


//    Process process;
//    public void CmdTest() throws IOException {
//        //process=Runtime.getRuntime().exec("cmd /k start C:\\Users\\kangzhijie\\Desktop\\YIXIN18\\pbrain-Yixin2018.exe");
//        process=Runtime.getRuntime().exec("cmd /k ");
//
//        final OutputStream outs = process.getOutputStream();
//        final InputStream ins = process.getInputStream();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread(){
//            public void run() {
//                try {
//                    outs.write("C:\\Users\\kangzhijie\\Desktop\\YIXIN18\\pbrain-Yixin2018.exe\n".getBytes());
//                    outs.flush();
//                    Thread.sleep(1000);
//                    outs.write("start 15\n".getBytes());
//                    outs.flush();
//                    Thread.sleep(1000);
//                    //outs.write("BOARD\n10,10,1\n10,11,2\n11,11,1\n9,10,2\nDONE\n".getBytes());
//                    System.out.println("时间board::"+System.currentTimeMillis());
//                    outs.write("BOARD\n".getBytes());
//                    outs.write("10,10,1\n".getBytes());
//                    outs.write("10,11,2\n".getBytes());
//                    outs.write("11,11,1\n".getBytes());
//                    outs.write("9,10,2\n".getBytes());
//                    outs.write("DONE\n".getBytes());
//                    outs.flush();
//
//
//                }catch (Exception e){
//                    System.out.println(e);
//                }
//            }
//            public void run1() {
//                try {
//                    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(outs));
//                    bw.write("start\r");
//                    bw.newLine();
//
//                    bw.write("echo ok");
//                    bw.newLine();
//
//                    bw.flush();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//        new Thread() {
//            public void run() {
//                try {
//                    BufferedReader br=new BufferedReader(new InputStreamReader(ins));
//                    String cmdout="";
//
//                    while ((cmdout=br.readLine())!=null) {
//                        System.out.println("时间2::"+System.currentTimeMillis());
//                        System.out.println(cmdout);
//                    }
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//
//    }
//}