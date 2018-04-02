package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import beans.Associate;
import dao.AssociateDao;

@Controller
public class AssociateController {
	
	

		@RequestMapping(value = "/loginhere", method = RequestMethod.GET)
		public ModelAndView from() {
			System.out.println("at get method controller");
			ModelAndView modelAndView = new ModelAndView("showMessage");
			return modelAndView;
		}

		@Autowired
		private AssociateDao associatedao;
		public void setLoginDao(AssociateDao associatedao) {
			this.associatedao = associatedao;
		}

		ModelAndView modelAndView;
	
/*		@RequestMapping(value = "/submituser", method = RequestMethod.POST)

		public ModelAndView userEntry(@ModelAttribute("associate") Associate associate, HttpServletRequest request,
				HttpServletResponse response, HttpSession session) {
			System.out.println("at post method controller:::: submit user");
		
				String usertype = request.getParameter("clarity");

				String userid = request.getParameter("userid");
				return modelAndView;}
*/
		
		
		
		@RequestMapping(value = "/submituser", method = RequestMethod.GET)		
		public  ModelAndView userEntry() {
				System.out.println("at get method controller");
				 modelAndView = new ModelAndView("showMessage");
				return modelAndView;
			}


		
		/*@RequestMapping(value = "/submituser", method = RequestMethod.GET)
		@ResponseBody
		public  String userEntry() {
			System.out.println("at post method controller:::: submit user");
			ModelAndView modelAndView = new ModelAndView("showMessagGHF");
			return "hello how r u?";				
		}*/
		 






}