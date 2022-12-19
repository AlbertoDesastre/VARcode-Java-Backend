package AlbertoDesastre.Helpers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public abstract class FileVerificator {
    public static void isAValidPath(String pathToBeValidated) throws Exception{
        File computerPath = new File(pathToBeValidated);
        if(!computerPath.exists()) throw new Exception("The path provided doesn't exists, and therefore the barcode can't be created");
        if(!pathToBeValidated.endsWith("/")) throw new Exception("The path provided must include '/' at the end");
        /*
        System.out.println(pathIncludesFinalSlash);
        System.out.println(pathWhereTheCodeWillBeCreated);
        ¿Por qué esta validación no me funcionaba como debería? Le pasaba un path con un "/" y me tiraba la Exception
        if(pathIncludesFinalSlash != "/") throw new Exception("The path provided must include '/' at the end");
         */
    }
    public static void doesThisFileExists(String imagePath) throws Exception{
        File computerPath = new File(imagePath);
        if(!computerPath.exists()) throw new Exception("The file you are looking for doesn't exists.");

    }
    //No se como testear esto con JUnit 4
    public static void deleteFileIfAlreadyExists(String imagePath){
        File computerPath = new File(imagePath);
        if(computerPath.exists()) {
            computerPath.delete();
        }
    }
    public static void checkImageHeightAndWidth(String imagePath, Integer desiredWidth, Integer desiredHeight) throws Exception{
        BufferedImage image = ImageIO.read(new File(imagePath));
        Integer actualWidth = image.getWidth();
        Integer actualHeight = image.getHeight();

        if(!actualHeight.equals(desiredHeight) && !actualWidth.equals(desiredWidth)) {
            System.out.println("Desired width --> " + desiredWidth + " Desired width --> " + desiredHeight);
            System.out.println("Actual Width --> " + actualWidth + " Actual Height -->" + actualHeight);
            throw new Exception("The barcode generated doesn't have the desired dimensions");
        }
    }

}
