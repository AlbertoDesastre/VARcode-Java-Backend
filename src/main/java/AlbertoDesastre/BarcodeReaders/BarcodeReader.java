package AlbertoDesastre.BarcodeReaders;

import AlbertoDesastre.Helpers.FileVerificator;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BarcodeReader {
    public static String read(String pathToImage) throws Exception{
        //Si el PATH no termina con ".jpg", ".jpeg", ".png", fuera.
        if(!pathToImage.endsWith(".jpg") && !pathToImage.endsWith(".jpeg") && !pathToImage.endsWith(".png"))
           throw new IllegalArgumentException("The provided path should end with either jpg, jpeg, or png.");
        //Tira exception si no encuentra el archivo indicado.
        FileVerificator.doesThisFileExists(pathToImage);

        BufferedImage bufferedImage = ImageIO.read(Files.newInputStream(Paths.get(pathToImage)));
        BinaryBitmap bitMap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
        Result result = new MultiFormatReader().decode(bitMap);
        String barcodeText = result.getText();

         return barcodeText;
    }
}

