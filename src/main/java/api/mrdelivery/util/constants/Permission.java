package api.mrdelivery.util.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    CLERK_READ("CLERK:read"),
    CLERK_UPDATE("CLERK:update"),
    CLERK_CREATE("CLERK:create"),
    CLERK_DELETE("CLERK:delete"),
    ACCOUNTANT_READ("accountant:read"),
    ACCOUNTANT_UPDATE("accountant:update"),
    ACCOUNTANT_CREATE("accountant:create"),
    ACCOUNTANT_DELETE("accountant:delete"),
    STACKHOLDER_READ("stackholder:read"),
    STACKHOLDER_UPDATE("stackholder:update"),
    STACKHOLDER_CREATE("stackholder:create"),
    STACKHOLDER_DELETE("stackholder:delete"),
    RIDER_READ("rider:read"),
    RIDER_UPDATE("rider:update"),
    RIDER_CREATE("rider:create"),
    RIDER_DELETE("rider:delete"),
    CLIENT_READ("client:read"),
    CLIENT_UPDATE("client:update"),
    CLIENT_CREATE("client:create"),
    CLIENT_DELETE("client:delete");

    @Getter
    private final String permission;
}
