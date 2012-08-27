package com.utils.file;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(ImageHandler.class);

    public void resize(String source, String target, int width, int height) throws IOException {

        BufferedImage sourceImage = resizeSourceImage(source,width,height);
        BufferedImage newImage = drawImage(width, height, sourceImage);
        if(newImage!=null) {
            ImageIO.write(newImage, "jpg", new File(target));
        }
    }

    private BufferedImage resizeSourceImage(String source, double width,double height) throws IOException {
        double targetRate = (height/width) * 100;
        File file = new File(source);
        logger.debug(" source image length =" + file.length());
        BufferedImage image = ImageIO.read(file);
        double srcWidth = image.getWidth(null);
        double srcHeight = image.getHeight(null);
        logger.debug(" source image width = " + srcWidth);
        logger.debug(" source image height = " + srcHeight);
        double srcRate = (srcHeight/srcWidth)*100;
        if(srcRate == targetRate){
            return image;
        }
        BufferedImage bufferedImage=null;
        if(srcRate>targetRate) {
            bufferedImage =  new BufferedImage((int)(srcHeight/(height/width)),
                    (int)srcHeight,
                    BufferedImage.TYPE_INT_RGB);
        }
        if(srcRate<targetRate) {
            bufferedImage =  new BufferedImage((int)srcWidth,
                    (int)(srcWidth*(height/width)),
                    BufferedImage.TYPE_INT_RGB);
        }
        bufferedImage = this.drawImage(bufferedImage.getWidth(null),bufferedImage.getHeight(null),image);

        return bufferedImage;
    }

    private BufferedImage drawImage(int width, int height, Image image)  {
        BufferedImage bufferedImage = new BufferedImage(width,
                height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g2D = bufferedImage.createGraphics();
        g2D.setColor(Color.white);
        g2D.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        if((image.getWidth(null) < width) || (image.getHeight(null) <height)){
            g2D.drawImage(image, (width - image.getWidth(null)) / 2, (height - image.getHeight(null)) / 2,null);
        }else {
            g2D.drawImage(image, 0, 0,width,height, null);
        }
        g2D.dispose();
        return bufferedImage;
    }
    
}
