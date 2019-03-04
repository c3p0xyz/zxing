package com.liu;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ZxingQRCode {

    public static void main(String[] args) {

        int width = 200;
        int height = 200;
        String content = "http://61.187.123.167:9005/a/login";
        String format = "jpg";

        Map hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN,2);

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE,width,height,hints);
            Path file = new File("D://中国纸业.jpg").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix,format,file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
