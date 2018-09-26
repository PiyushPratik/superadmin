package ai.talentify.SuperAdmin;

import javax.servlet.annotation.WebServlet;

import org.json.JSONObject;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ai.talentify.suepradmin.restutils.MD5Utils;
import ai.talentify.suepradmin.restutils.RestUtility;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("tfy_vaadin")
public class Talentify extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();

		/*
		 * What we need to do here is add two field s 1. a username 2. a passord 3. A
		 * button to submit
		 * 
		 * Once we are done with this we will try to call the rest API from our serer to
		 * do authetication.
		 * 
		 * 
		 * Once all of this seems making sense we will try to fix look and feel of out
		 * universe to make it similar to
		 */

		final TextField name = new TextField();
		name.setCaption("Username");

		final PasswordField password = new PasswordField();
		password.setCaption("Password");

		Button button = new Button("Login");
		button.addClickListener(e -> {
			RestUtility util = new RestUtility();
			String json = util.postRequest("https://sales.talentify.in/istar/rest/auth/login?login=sales",
					"email=" + name.getValue() + "&password=" + MD5Utils.toMd5(password.getValue()));
			layout.addComponent(new Label(json.toString()));
		});
		layout.addComponents(name, password, button);
		setContent(layout);
	}

	@WebServlet(urlPatterns = "/*", name = "TalentifyServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = Talentify.class, productionMode = false)
	public static class TalentifyServlet extends VaadinServlet {
	}
}
