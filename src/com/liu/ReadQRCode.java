package com.liu;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadQRCode {

    public static void main(String[] args) {

        try {
            File file = new File("D://中国纸业.jpg");
            MultiFormatReader formatReader = new MultiFormatReader();
            BufferedImage bufferedImage = ImageIO.read(file);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
            Result result = formatReader.decode(binaryBitmap, hints);
            System.out.println("二维码："+result);
            System.out.println("二维码类型: "+result.getBarcodeFormat());
            System.out.println("二维码内容: "+result.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
