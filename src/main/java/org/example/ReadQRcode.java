package org.example;
import  java.io.FileInputStream;    
import  java.io.FileNotFoundException;    
import  java.io.IOException;    
import  java.util.HashMap;    
import  java.util.Map;    
import  javax.imageio.ImageIO;    
import  com.google.zxing.BinaryBitmap;    
import  com.google.zxing.EncodeHintType;    
import  com.google.zxing.MultiFormatReader;    
import  com.google.zxing.NotFoundException;    
import  com.google.zxing.Result;    
import  com.google.zxing.WriterException;    
import  com.google.zxing.client.j2se.BufferedImageLuminanceSource;    
import  com.google.zxing.common.HybridBinarizer;    
import  com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;    
public  class  ReadQRcode {
//user-defined  method  that  reads  the  QR  code    
public  static  String  readQRcode(String  path,  String  charset,  Map  map)  throws  FileNotFoundException,  IOException,  NotFoundException    
        {    
        BinaryBitmap  binaryBitmap  =  new  BinaryBitmap(new  HybridBinarizer(new  BufferedImageLuminanceSource(ImageIO.read(new  FileInputStream(path)))));    
        Result  rslt  =  new  MultiFormatReader().decode(binaryBitmap);    
        return  rslt.getText();    
        }

}