
/**
 * A program to create new images that are photographic negatives ( inverted images)
 * 
 * @author (Kareem Nagah) 
 * @version ( september 23, 2022)
 */
import edu.duke.*;
import java.io.*;
public class ImageInversion {
 
    public ImageResource makeInversion(ImageResource inImage) {
        //I made a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        //for each pixel in outImage
        for (Pixel p: outImage.pixels()) {
                //look at the corresponding pixel in inImage
                Pixel inPixel = inImage.getPixel(p.getX(),p.getY());
                //invert  a pixel’s red, blue, and green components are modified 
                //to be the exact opposite within the 0 to 255 range. 
                int redInvert = 255 - inPixel.getRed();
                int blueInvert = 255 - inPixel.getBlue();
                int greenInvert = 255 - inPixel.getGreen();
                //set pixel's red to redInvert
                p.setRed(redInvert);
                //set pixel's green to blueInvert
                p.setGreen(blueInvert);
                //set pixel's blue to greenInvert
                p.setBlue(greenInvert);
            }
            //outImage is your answer
            return(outImage);
        }

    public void selectAndConvertAndSave() {
       DirectoryResource dr = new DirectoryResource();
       for (File f : dr.selectedFiles()) {
              ImageResource ir = new ImageResource(f);
              ImageResource grayImage = makeInversion(ir);
              String fName =ir.getFileName();
              String newName = "inverted-" + fName ;
              grayImage.setFileName(newName);
              grayImage.draw();
              grayImage.save();
        }
    
    
    
    }   
}
