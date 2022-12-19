package AlbertoDesastre;

import AlbertoDesastre.BarcodeReaders.BarcodeReader;
import AlbertoDesastre.ENUMS.ImageFormat;
import AlbertoDesastre.Generators.Code128Generator;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println();
        Code128Generator.generateFrom("preview_123",
                ImageFormat.PNG, "D:/Users/ExampleUser/ExampleFolder/Barcodes/",
                400, 200);
        BarcodeReader.read("D:/Users/ExampleUser/ExampleFolder/Barcodes/preview_123.png");
    }
}
