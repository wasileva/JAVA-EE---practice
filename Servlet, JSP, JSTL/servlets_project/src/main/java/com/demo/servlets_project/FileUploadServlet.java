package com.demo.servlets_project;


import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload")
public class FileUploadServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
       ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
       List<FileItem> files;
        try {
            files = fileUpload.parseRequest(req);          
            for(FileItem item : files){
                item.write(new File("C:\\Users\\crimd\\Documents\\NetBeansProjects\\servlets_project\\" + item.getName()));    
            }
            resp.getWriter().write("<h1>The file uploaded sucessfully</h1>");
        } catch (FileUploadException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
