package com.techtrend.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This displays the welcome screen that shows what will be happening in this chapter.
 *
 */
@Controller
public class WelcomeController {

    @RequestMapping("/")
    public String welcome() {
        return "index";
    }
    
    @RequestMapping("/ldrly")
	public String ldryIndex(){
		return "ldrly/ldrlyIndex";
	}
    @RequestMapping("/ldrly/sendState")
	public String sendState(){
		return "ldrly/sendState";
	}
    @RequestMapping("/ldrly/getLeaderBorder")
	public String ldryGetLeaderBoarder(){
		return "ldrly/getLeaderBoarder";
	}
    @RequestMapping("/ldrly/getState")
	public String ldryGetState(){
		return "ldrly/getState";
	}
    
    
}