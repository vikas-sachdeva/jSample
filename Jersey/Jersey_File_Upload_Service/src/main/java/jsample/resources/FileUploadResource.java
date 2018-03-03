package jsample.resources;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/upload")
public class FileUploadResource {

	/**
	 * 
	 * Curl command for testing this API -
	 * 
	 * curl -v -F "file=@myFile.PNG" -F "fileDescription=file for testing"
	 * http://localhost:8080/Jersey_File_Upload_Service/rest/upload/file
	 * 
	 */

	public static final String UPLOAD_DIR_PATH = "D:/temp/";

	@POST
	@Path("/file")
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	public Response uploadFile(@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition fileMetaData,
			@FormDataParam("fileDescription") String fileDescription) throws Exception {
		try {
			String fileName = fileMetaData.getFileName();
			Files.copy(fileInputStream, Paths.get(UPLOAD_DIR_PATH + fileName), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
			return Response.ok("There is an error while uploading file.").build();
		}
		return Response.ok("File with description '" + fileDescription + "' is successfully uploaded.").build();
	}
}