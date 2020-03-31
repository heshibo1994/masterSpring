package com.smart.web;

import com.smart.UserService;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")

public class UserController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	@RequestMapping(path = "/register")
	public String register(){
		return "user/register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView createUser(User user) {
		userService.createUser(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/createSuccess");
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(path = "/handle1")
	public String handle1(@RequestParam("userName")String name,
						  @RequestParam("password")String password,
						  @RequestParam("realName")String realName){
		return "success";
	}

	@RequestMapping(path = "/handle41")
	public String handle41(@RequestBody String requestBody){
		return "success";
	}

	@ResponseBody
	@RequestMapping(path = "/handle2/{imageId}")
	public byte[] handle42(@PathVariable("imageId") String imageId) throws Exception{
		System.out.println("load image of"+imageId);
		ClassPathResource res = new ClassPathResource("/image.jpg");
		byte[] fileData = FileCopyUtils.copyToByteArray(res.getInputStream());
		return  fileData;
	}

	@RequestMapping(path = "/handle91")
	public String handle91 (@Valid @ModelAttribute("user") User user,
							BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			return "/user/register3";
		}else{
			return "success";
		}

	}

}
