package org.example;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.example.GenerateQRCode.generateQRcode;

public class Main {
    public static void main(String args[]) throws WriterException, IOException, NotFoundException
    {
        //data that we want to store in the QR code
        String str= "Hinoveanu Razvan";
        //path where we want to get QR Code
        String path = "Quote.png";
        //Encoding charset to be used
        String charset = "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        //generates QR code with Low level(L) error correction capability
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        //invoking the user-defined method that creates the QR code
        generateQRcode(str, path, charset, hashMap, 200, 200);//increase or decrease height and width accodingly
        //prints if the QR code is generated
        System.out.println("QR Code created successfully.");
    }
}