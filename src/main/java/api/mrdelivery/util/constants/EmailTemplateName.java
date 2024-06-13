package api.mrdelivery.util.constants;

import lombok.Getter;

@Getter
public enum EmailTemplateName {

    ACTIVATE_ACCOUNT("comfirmation_template"),
    RESET_PASSWORD("resetpwd_template");

    private final String name;
    EmailTemplateName(String name) {
        this.name = name;
    }
}
