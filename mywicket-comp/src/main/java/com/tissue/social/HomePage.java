package com.tissue.social;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1l;

    public static class LoginForm extends Form<String> {

        private static final long serialVersionUID = 7747055281008833705L;

        private TextField<String> usernameField;
        private PasswordTextField passwordField;
        private Label loginStatus;

        public LoginForm() {
            super("loginForm");

            usernameField = new TextField<String>("username", Model.of(""));
            passwordField = new PasswordTextField("password", Model.of(""));
            loginStatus = new Label("loginStatus", Model.of(""));

            add(usernameField);
            add(passwordField);
            add(loginStatus);
        }

        @Override
        protected void onSubmit() {
            String username = usernameField.getDefaultModelObjectAsString();
            String password = passwordField.getDefaultModelObjectAsString();
            if(username.equals("test") && password.equals("test")) {
                loginStatus.setDefaultModelObject("Congratulations!");
            } else {
                loginStatus.setDefaultModelObject("Wrong username or password!");
            }
        }

    }

    public HomePage() {
        Form<?> form = new LoginForm();
        setVersioned(false);
        add(form);

        Page page = form.getPage();
        System.out.println(page);

        add(new Label("message1", "jfa"));
        add(new Link<String>("test1") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                setResponsePage(Test1Page.class);
            }

        });
    }

}
