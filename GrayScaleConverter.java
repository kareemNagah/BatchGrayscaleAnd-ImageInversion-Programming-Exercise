/**
 * A program to create new images that are photographic negatives ( inverted images)
 * 
 * @author (Kareem Nagah) 
 * @version ( september 23, 2022)
 */
import edu.duke.*;
import java.io.*;

public class GrayScaleConverter {
    //I started with the image I wanted (inImage)
    public ImageResource makeGray(ImageResource inImage) {
        //I made a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        //for each pixel in outImage
        for (Pixel p: outImage.pixels()) {
                //look at the corresponding pixel in inImage
                Pixel inPixel = inImage.getPixel(p.getX(),p.getY());
                //compute inPixel's red + inPixel's blue + inPixel's green
                //divide that sum by 3 (call it average)
                int avr = (inPixel.getRed() + inPixel.getBlue() +inPixel.getGreen())/3 ;
                //set pixel's red to average
                p.setRed(avr);
                //set pixel's green to average
                p.setGreen(avr);
                //set pixel's blue to average
                p.setBlue(avr);
            }
            //outImage is your answer
            return(outImage);
        }

    public void selectAndConvertAndSave() {
       DirectoryResource dr = new DirectoryResource();
       for (File f : dr.selectedFiles()) {
              ImageResource ir = new ImageResource(f);
              ImageResource grayImage = makeGray(ir);
              String fName =ir.getFileName();
              String newName = "Gray-" + fName ;
              grayImage.setFileName(newName);
              grayImage.draw();
              grayImage.save();
        }
        }
    }