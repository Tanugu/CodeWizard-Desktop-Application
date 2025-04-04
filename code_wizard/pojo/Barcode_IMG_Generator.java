/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code_wizard.pojo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

/**
 *
 * @author tanug
 */
public class Barcode_IMG_Generator {
    public static void createImage(String image_name,String myString)
    {
        try
        {
            Code128Bean code128=new Code128Bean();
            code128.setHeight(15f);
            
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            BitmapCanvasProvider canvas=new BitmapCanvasProvider(baos,"image/x-png",300,BufferedImage.TYPE_BYTE_BINARY,false,0);
                    
            code128.generateBarcode(canvas,myString);
            canvas.finish();
            
            String userdir=System.getProperty("user.dir");
            System.out.println("user dir is:"+userdir);
            FileOutputStream fos=new FileOutputStream(userdir+"\\Barcode\\"+image_name);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception in barcode gen:"+e.getMessage());
        }
    }}
//    String outputDir = userdir + File.separator + "Barcode";
//            File outputDirectory = new File(outputDir);
//            
//            // Create the directory if it doesn't exist
//            if (!outputDirectory.exists()) {
//                outputDirectory.mkdirs();
//            }
//
//            // Write the barcode image to a file
//            try (FileOutputStream fos = new FileOutputStream(outputDir + File.separator + imageName)) {
//                fos.write(baos.toByteArray());
//                fos.flush();
//            }
//        }
//         catch (Exception e) {
//            System.out.println("Exception in barcode generation: " + e.getMessage());
//        }

    
    
        
    
 