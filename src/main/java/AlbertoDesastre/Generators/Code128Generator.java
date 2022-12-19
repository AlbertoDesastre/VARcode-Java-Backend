package AlbertoDesastre.Generators;

import AlbertoDesastre.Helpers.FileVerificator;
import AlbertoDesastre.ENUMS.ImageFormat;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;

import java.nio.file.Paths;

public class Code128Generator {
    public static void generateFrom(String barcodeString, ImageFormat imageFormat,
                                       String pathWhereTheCodeWillBeCreated,
                                       Integer width, Integer height) throws Exception {
        // Si el barcodeString provisto SOLO contiene letras o SOLO contiene números salta el error.
        if (barcodeString.matches("[a-zA-Z]+")
            || barcodeString.matches("[0-9]+")
            || barcodeString.matches("[!¡¿@?ªº,._&%#$~|¬]+")
            || barcodeString.length() < 8  ) throw new IllegalArgumentException("barcodeString must contain numbers, letters, symbols and be 8 characters long");

        // Si el barcode no incluye letras y números al mismo tiempo tira error.
        // Esta validación tiene un bug conocido. Le intento meter barcodeStrings que NO contengan símbolos y no salta la Exception.
        if (!barcodeString.matches("[a-zA-Z0-9-!¡¿@?ªº,._&%#$~|¬]+")) throw new IllegalArgumentException("barcode must have letters and numbers, and symbols");

        if(imageFormat == null || width == null || height == null) throw new NullPointerException("You must provide an ENUM ImageFormat valid, such as ImageFormat.JPG or ImageFormat.PNG." +
                "You also have to provide a height and width, and they must be Integers, never Strings.");

        // Verification and creation of final Path
        FileVerificator.isAValidPath(pathWhereTheCodeWillBeCreated);
        String imagePath = pathWhereTheCodeWillBeCreated +  barcodeString + "." + imageFormat.getString();
        // In case a barcode already exists with this name it's deleted
        FileVerificator.deleteFileIfAlreadyExists(imagePath);
        // Actual creation of Barcode
        Code128Writer barcodeWriter = new Code128Writer();
        BitMatrix matrix = barcodeWriter.encode(barcodeString, BarcodeFormat.CODE_128, width, height);
        MatrixToImageWriter.writeToPath(matrix, imageFormat.getString(), Paths.get(imagePath));

        FileVerificator.doesThisFileExists(imagePath);
        FileVerificator.checkImageHeightAndWidth(imagePath, width, height);
        System.out.println("Everything was succesfull and the barcode was created, you can find it here: " +
                imagePath);
    }
}
