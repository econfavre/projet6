package com.projet_6.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.projet_6.entity.Topo;

@Controller
public class MyFileUploadController {

	@RequestMapping(value = "/newtopo")
	public String homePage() {

		return "newtopo";
	}

	// GET: Show upload form page.
	@RequestMapping(value = "/newtopo", method = RequestMethod.GET)
	public String uploadOneFileHandler(Model model) {

		Topo topo = new Topo();
		model.addAttribute("topo", topo);

		return "newtopo";
	}

	// POST: Do Upload
	@RequestMapping(value = "/newtopo", method = RequestMethod.POST)
	public String uploadOneFileHandlerPOST(HttpServletRequest request, //
			Model model, //
			@ModelAttribute("topo") Topo topo) {

		return this.doUpload(request, model, topo);

	}

	private String doUpload(HttpServletRequest request, Model model, //
			Topo topo) {

		String topoDescription = topo.getTopoDescription();
		System.out.println("Description: " + topoDescription);

		// Root Directory.
		String uploadRootPath = request.getServletContext().getRealPath("upload");
		System.out.println("uploadRootPath=" + uploadRootPath);

		File uploadRootDir = new File(uploadRootPath);
		// Create directory if it not exists.
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		MultipartFile[] fileDatas = topo.getFileDatas();
		//
		List<File> uploadedFiles = new ArrayList<File>();
		List<String> failedFiles = new ArrayList<String>();

		for (MultipartFile fileData : fileDatas) {

			// Client File Name
			String name = fileData.getOriginalFilename();
			System.out.println("Client File Name = " + name);

			if (name != null && name.length() > 0) {
				try {
					// Create the file at server
					File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);

					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(fileData.getBytes());
					stream.close();
					//
					uploadedFiles.add(serverFile);
					System.out.println("Write file: " + serverFile);
				} catch (Exception e) {
					System.out.println("Error Write file: " + name);
					failedFiles.add(name);
				}
			}
		}
		model.addAttribute("topodescription", topoDescription);
		model.addAttribute("uploadedFiles", uploadedFiles);
		model.addAttribute("failedFiles", failedFiles);
		return "seeresultupload";
	}

}