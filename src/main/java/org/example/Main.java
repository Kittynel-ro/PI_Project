package org.example;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static org.example.GenerateQRCode.*;
import static org.example.ReadQRcode.readQRcode;

public class Main {
    public static void main(String args[]) throws WriterException, IOException, NotFoundException
    {
        File file = new File("Studenti.txt");
        GUI gui = new GUI(file);
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String  path  =  "src/main/java/Quote.png";
        String  charset  =  "UTF-8";
        Map<EncodeHintType,  ErrorCorrectionLevel>  hintMap  =  new  HashMap<EncodeHintType,  ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION,  ErrorCorrectionLevel.L);
        System.out.println("Data  stored  in  the  QR  Code  is:  \n"+  readQRcode(path,  charset,  hintMap));
    }
}