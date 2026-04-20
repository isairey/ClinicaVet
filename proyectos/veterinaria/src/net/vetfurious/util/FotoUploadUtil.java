package net.vetfurious.util;

import java.io.File;

import org.apache.commons.fileupload.FileItem;

public class FotoUploadUtil {
	
	public File subirArchivo(FileItem item, String folderFotos)
	{
		File file=new File(item.getName());
		File folderFotosExisting = new File(folderFotos); 
		
		if ( ! folderFotosExisting.exists() )
		{
			folderFotosExisting.mkdirs();
		}
		try {
			item.write(new File(folderFotos,file.getName()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;	
		}
		
		return file;	
	}

}
