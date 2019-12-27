package org.humki.baiduueditor.util;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

public class ImageUtil {

    /**
     * 判断是否是真的图片
     */
    public static boolean isRealImage(File file) {
        try (ImageInputStream iis = ImageIO.createImageInputStream(file)) {
            Iterator iter = ImageIO.getImageReaders(iis);
            if (!iter.hasNext()) {// 文件不是图片
                System.out.println("此文件不为图片文件");
                return false;
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 判断是否是真的图片
     */
    public static boolean isRealImage(byte[] bytes) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes)) {
            BufferedImage read = ImageIO.read(bais);
            return read != null;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 判断是否是真的图片
     */
    public static boolean isRealImage(MultipartFile upfile) {
        try (InputStream is = upfile.getInputStream()) {
            BufferedImage read = ImageIO.read(is);
            return read != null;
        } catch (IOException e) {
            return false;
        }
    }


}
