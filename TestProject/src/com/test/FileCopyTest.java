package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyTest {
	
	public static void main(String args[])
    {
		
		
        File srcFolder = new File("/home/bob/Desktop/eauction-application-documents/excel-lot-document-files/EVT-c8f2f4-10-04-2017-01/LT-5e77f3-10-04-2017-01/EX_LT_DOC_ID-28f77e-10-04-2017-01");
        File destFolder = new File("/home/bob/Desktop/eauction-application-documents/excel-lot-document-files/EVT-302022-10-04-2017-01/LT-c204a8-10-04-2017-01/EX_LT_DOC_ID-25ec04-10-04-2017-01 ");
        
        //"/home/bob/Desktop/eauction-application-documents/excel-lot-document-files/EVT-8c849f-10-04-2017-01/LT-9ce254-10-04-2017-01/EX_LT_DOC_ID-dcad5b-10-04-2017-01"

        if(!srcFolder.exists())
        {

              System.out.println("Directory does not exist.");
               //just exit
             System.exit(0);
        }
        else{

               try{
                    copyDirectory(srcFolder,destFolder);
                          }
               catch(IOException e)
                {
                        e.printStackTrace();
                        //error, just exit
                            System.exit(0);
                    }
            }
        System.out.println("Done");
    }

    public static void copyDirectory(File src , File target) throws IOException 
    {
        if (src.isDirectory()) 
        {
                if (!target.exists()) 
            {
                    target.mkdirs();
                }

                String[] children = src.list();
                for (int i=0; i<children.length; i++) 
            {
                     copyDirectory(new File(src, children[i]),new File(target, children[i]));
                }
        }
        // if Directory exists then only files copy
        else 
        {

                InputStream in = new FileInputStream(src);
                OutputStream out = new FileOutputStream(target);

                // Copy the bits from instream to outstream
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) 
            {
                        out.write(buf, 0, len);
            }
            in.close();
                out.close();

            }


    }    

}
