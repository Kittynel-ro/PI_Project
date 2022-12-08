package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class GenerateQRCode
{
    //static function that creates QR Code  

    private static final String qcip = "src/main/java/Quote.png";
    static void generateQRCode(String text, int width, int height, String filePath)
            throws Exception {
        QRCodeWriter qcwobj = new QRCodeWriter();
        BitMatrix bmobj = qcwobj.encode(text, BarcodeFormat.QR_CODE, width, height);
        Path pobj = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bmobj, "PNG", pobj);
    }
}