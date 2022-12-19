package AlbertoDesastre;

import AlbertoDesastre.ENUMS.ImageFormat;
import AlbertoDesastre.Generators.Code128Generator;
import org.junit.Test;

public class Code128GeneratorShould {
    @Test(expected = NullPointerException.class)
    public void throwExceptionWhenNotGettingBarcodeString() throws Exception {
         Code128Generator.generateFrom(null, ImageFormat.JPG, "C:/Users", 400,200);
    }
    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenStringIsEmpty() throws Exception {
        Code128Generator.generateFrom("",ImageFormat.JPG, "C:/Users", 400,200);
    }
    @Test(expected = Exception.class)
    public void throwExceptionWhenStringIsNot8characterLong() throws Exception{
        Code128Generator.generateFrom("12ab#4", ImageFormat.JPG, "C:/Users", 400,200 );
    }
    @Test(expected = NullPointerException.class)
    public void throwExceptionWhenNotGettinWidthOrHeight() throws Exception {
        Code128Generator.generateFrom("abc123abc", ImageFormat.JPG, "C:/Users", null,null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenStringDoesntContainNumbers() throws Exception {
        Code128Generator.generateFrom("abcdEfg",ImageFormat.JPG, "C:/Users", 400,200);
    }
    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenStringDoesntContainLetters() throws Exception {
        Code128Generator.generateFrom("12345",ImageFormat.JPG, "C:/Users", 400,200);
    }
    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenStringDoesntContainLettersAndNumbers() throws Exception {
      Code128Generator.generateFrom("@@@",ImageFormat.JPG, "C:/Users", 400,200);
    }
    /*
    Este test devuelve TRUE si el barcode tiene letras y números.
    Según yo es redundante con el test que devuelve IllegalArgumentException si no es así
      @Test()
    public void workWhenStringContainsLettersAndNumbers() throws Exception {
        Assert.assertEquals(true,Code128Generator.generateFrom("a12nmdabs2", ImageFormat.JPG, "C:/Users", 400,200));
    }
     */

    @Test(expected = NullPointerException.class)
    public void throwExceptionWhenNotProvidingImageFormat() throws Exception {
        Code128Generator.generateFrom("1dab2314", null, "C:/Users", 400,200);
    }
    @Test(expected = Exception.class)
    public void throwExceptionIfPathDoesntExists() throws Exception {
        Code128Generator.generateFrom("123abc", ImageFormat.JPG, "C:/NonExisting/Paths", 400,200);
    }

    /*
    Este test devuelve TRUE si el path existe. Según yo es redundante con el test que devuelve Exception si no existe
      @Test()
    public void returnTrueIfPathExists() throws Exception {
       Assert.assertEquals(true,Code128Generator.generateFrom("123abc", ImageFormat.JPG, "C:/Users", 400,200));
    }
     */
    @Test(expected = Exception.class)
    public void throwExceptionWhenPathProvidedDoesntIncludeTheFinalSlash() throws Exception {
        Code128Generator.generateFrom("123abc", ImageFormat.JPG, "D:/Users/ExampleUser/ExampleFolder/Barcodes", 400,200);
    }
    // Este test creo que me sobra, pero realmente sobra?
    /*
    Este test creo que definitivamente me sobra, ya que con la última comprobación de si se creó el archivo ya es suficiente
      @Test()
    public void returnPathIfIsCorrectlyCreated() throws Exception {
        Assert.assertEquals("D:/Users/ExampleUser/ExampleFolder/Barcodes/123abc.jpg",Code128Generator.generateFrom("123abc", ImageFormat.JPG, "D:/Users/ExampleUser/ExampleFolder/Barcodes/", 400,200));
    }
     */

    @Test()
    public void returnNothinIfEverythingIsSuccesful() throws Exception {
       Code128Generator.generateFrom("123abc!_", ImageFormat.JPG, "D:/Users/ExampleUser/ExampleFolder/Barcodes/", 400,200);
    }
}