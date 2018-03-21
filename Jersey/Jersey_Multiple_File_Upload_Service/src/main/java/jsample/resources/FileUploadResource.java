package jsample.resources;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/upload")
public class FileUploadResource {

	/**
	 * 
	 * Curl command for testing this API -
	 * 
	 * curl -v -F "file=@file1.PNG" -F "fileDescription=file 1" -F "file=@file2.PNG"
	 * -F "fileDescription=file 2"
	 * http://localhost:8080/Jersey_Multiple_File_Upload_Service/rest/upload/file
	 * 
	 */

	public static final String UPLOAD_DIR_PATH = "D:/temp/";

	@POST
	@Path("/file")
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	public Response uploadFile(@FormDataParam("file") List<FormDataBodyPart> bodyParts,
			@FormDataParam("file") List<FormDataContentDisposition> fileMetaData,
			@FormDataParam("fileDescription") List<String> fileDescription) throws Exception {

		try {
			for (int i = 0; i < bodyParts.size(); i++) {
				InputStream fileInputStream = bodyParts.get(i).getEntityAs(InputStream.class);
				String temp = fileMetaData.get(i).getFileName();
				String fileName = new String(temp.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

				Files.copy(fileInputStream, Paths.get(UPLOAD_DIR_PATH + fileName), StandardCopyOption.REPLACE_EXISTING);
			}

		} catch (IOException e) {
			e.printStackTrace();
			return Response.ok("There is an error while uploading file.").build();
		}
		return Response.ok("File with descriptions '" + fileDescription + "' is successfully uploaded.").build();
	}
}