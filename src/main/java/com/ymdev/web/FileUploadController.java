package com.ymdev.web;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ymdev.models.File;
import com.ymdev.models.Pfe;
import com.ymdev.service.IFileService;
import com.ymdev.service.IFileStorageService;
import com.ymdev.service.IPfeService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping( "/file")
public class FileUploadController {
	
	@Autowired
	private IFileService service;
	
	@Autowired
	private IPfeService pfservice;
	
	@Autowired
	 private IFileStorageService storageService;
	
	@RequestMapping("/pfe_advancement/{pfeId}")
	public String FilesByPfe(@PathVariable long pfeId, Model model) {
		  String messageofliststate = "";
		try {
			List<Resource> uploadedfiles= new ArrayList<Resource>();
			List<File> files = service.getByPfe(pfeId);
   
			files.forEach(element -> {
				 Resource file = storageService.load(element.getName());
				 uploadedfiles.add(file);
				 });
			model.addAttribute("files", uploadedfiles);
		} catch (Exception e) {
			messageofliststate = "This pfe has no files yet, upload files to mark your work advancement. Your professor will appreciate that !";
			e.printStackTrace();
		}
		 model.addAttribute("messageofliststate", messageofliststate);
		Pfe pfe = pfservice.getById(pfeId);
		model.addAttribute("pfe",pfe);
		return "student_files";
	}

	@PostMapping("/upload/{pfeId}")
	  public String uploadFile(@ModelAttribute MultipartFile file, Model model, @PathVariable long pfeId) {
	    String message = "";
	    File uploadedfile = new File();
	   
	    try {
	      storageService.save(file);
	      System.out.println("after storage save");
	      System.out.println("fileName:" + file.getOriginalFilename());
	      uploadedfile.setName(file.getOriginalFilename());
	      uploadedfile.setPfe(pfservice.getById(pfeId));
	      service.saveOrUpdate(uploadedfile);
	      System.out.println("file saved successufuly");
	      message="file uploaded succefuly";
	    } catch (Exception e) {
	    	e.getStackTrace();
	      message = "fileExistAlready";
	    }
	    
	    String messageofliststate = "";
	  		try {
	  			List<Resource> uploadedfiles= new ArrayList<Resource>();
	  			List<File> files = service.getByPfe(pfeId);
	  			files.forEach(element -> {
	  				 Resource fileup = storageService.load(element.getName());
	  				 uploadedfiles.add(fileup);
	  				 });
	  			model.addAttribute("files", uploadedfiles);
	  		} catch (Exception e) {
	  			messageofliststate = "This pfe has no files yet, upload files to mark your work advancement. Your professor will appreciate that !";
	  			e.printStackTrace();
	  		}
	  	model.addAttribute("messageofliststate", messageofliststate);
	    model.addAttribute("pfe", pfservice.getById(pfeId));
	    model.addAttribute("message", message);
	    return "student_files";
	}

	
	@GetMapping("/getPfeFiles/{pfeId}")
	@ResponseBody
	  public String getpefFiles(@PathVariable long pfeId, Model model) {
		List<Resource> uploadedfiles= new ArrayList<Resource>();
		List<File> files = service.getByPfe(pfeId);
	   
	    files.forEach(element -> {
	    	 Resource file = storageService.load(element.getName());
	    	 uploadedfiles.add(file);
	    	 });
	    model.addAttribute("files", uploadedfiles);
	    return "student_files";
	}
	

    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
       
        Resource resource = storageService.load(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }


	
	@GetMapping("/getuploadedFile/{filename}")
	@ResponseBody
	  public Resource getuploadedFile(@PathVariable String filename) {
	    Resource file = storageService.load(filename);
	    return file;
	}
	

	@GetMapping("/getFile/{filename}")
	@ResponseBody
	  public File getFile(@PathVariable String filename) {
	    return service.loadFileUrl(filename);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<File> findAll () {
		List<File>  images =  service.getAll();
				images.forEach(element -> {
					service.loadFileUrl(element.getName());
		});
				return images;  
	}
	
	@RequestMapping(value="/getAllFiles", method=RequestMethod.GET)
	public List<File> getAllFiles () { 
				return service.getAll();  
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public File save (@RequestBody File file) {
		return service.saveOrUpdate(file);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public File update (@RequestBody File file) {
		return service.saveOrUpdate(file);
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public File getById (@PathVariable Long id) {
		return service.getById(id);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void delete (@PathVariable Long id) {
		storageService.delete(service.getById(id).getName());
		service.delete(id);
	
	}
	
	@RequestMapping(value="/deleteFile/{fileName}", method=RequestMethod.DELETE)
	public void deleteFile (@PathVariable String fileName) {
		storageService.delete(fileName);
	
	}
	
	@RequestMapping(value="/count", method=RequestMethod.GET)
	public long count() {
		return service.coutFiles();
	}
	
}