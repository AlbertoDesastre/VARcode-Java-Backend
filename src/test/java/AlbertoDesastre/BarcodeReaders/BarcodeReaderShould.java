package AlbertoDesastre.BarcodeReaders;

import org.junit.Assert;
import org.junit.Test;


public class BarcodeReaderShould {
    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionIfPathProvidedDoesntEndWithImageFormat() throws Exception {
        BarcodeReader.read("D:/Users/ExampleUser/ExampleFolder/Barcodes/prueba1234");
    }
    @Test(expected = Exception.class)
    public void readTheFilePathFirstAndThrowExceptionIfItDoesntExists() throws Exception{
        BarcodeReader.read("Brejejeje");
    }
    @Test()
    public void readCorrectlyTheGivenBarcode() throws Exception{
        Assert.assertEquals("prueba1234", BarcodeReader.read("D:/Users/ExampleUser/ExampleFolder/Barcodes/prueba1234.png"));
    }
}