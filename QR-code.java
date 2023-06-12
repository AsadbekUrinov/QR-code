import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the text to encode as a QR code: ");
        String data = scanner.nextLine();
        
        System.out.print("Enter the filename to save the QR code as (e.g., qr_code.png): ");
        String filename = scanner.nextLine();
        
        generateQRCode(data, filename);
        System.out.println("QR code generated and saved as " + filename);
    }
    
    public static void generateQRCode(String data, String filename) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        int width = 300;
        int height = 300;
        
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height);
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int color = bitMatrix.get(x, y) ? 0x000000 : 0xFFFFFF;
                    image.setRGB(x, y, color);
                }
            }
            
            File outputFile = new File(filename);
            ImageIO.write(image, "png", outputFile);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }
}
