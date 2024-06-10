package api.mrdelivery.util.constants;

import static api.mrdelivery.util.constants.Permission.ACCOUNTANT_CREATE;
import static api.mrdelivery.util.constants.Permission.ACCOUNTANT_DELETE;
import static api.mrdelivery.util.constants.Permission.ACCOUNTANT_READ;
import static api.mrdelivery.util.constants.Permission.ACCOUNTANT_UPDATE;
import static api.mrdelivery.util.constants.Permission.ADMIN_CREATE;
import static api.mrdelivery.util.constants.Permission.ADMIN_DELETE;
import static api.mrdelivery.util.constants.Permission.ADMIN_READ;
import static api.mrdelivery.util.constants.Permission.ADMIN_UPDATE;
import static api.mrdelivery.util.constants.Permission.CLERK_CREATE;
import static api.mrdelivery.util.constants.Permission.CLERK_DELETE;
import static api.mrdelivery.util.constants.Permission.CLERK_READ;
import static api.mrdelivery.util.constants.Permission.CLERK_UPDATE;
import static api.mrdelivery.util.constants.Permission.CLIENT_READ;
import static api.mrdelivery.util.constants.Permission.RIDER_CREATE;
import static api.mrdelivery.util.constants.Permission.RIDER_DELETE;
import static api.mrdelivery.util.constants.Permission.RIDER_READ;
import static api.mrdelivery.util.constants.Permission.RIDER_UPDATE;
import static api.mrdelivery.util.constants.Permission.STACKHOLDER_CREATE;
import static api.mrdelivery.util.constants.Permission.STACKHOLDER_DELETE;
import static api.mrdelivery.util.constants.Permission.STACKHOLDER_READ;
import static api.mrdelivery.util.constants.Permission.STACKHOLDER_UPDATE;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {

    USER(Collections.emptySet()),
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_CREATE,
                    ADMIN_DELETE)),
    CLERK(
            Set.of(
                    CLERK_READ,
                    CLERK_UPDATE,
                    CLERK_CREATE,
                    CLERK_DELETE)),
    ACCOUNTANT(
            Set.of(
                    ACCOUNTANT_READ,
                    ACCOUNTANT_UPDATE,
                    ACCOUNTANT_CREATE,
                    ACCOUNTANT_DELETE)),
    STACKHOLDER(
            Set.of(
                    STACKHOLDER_READ,
                    STACKHOLDER_UPDATE,
                    STACKHOLDER_CREATE,
                    STACKHOLDER_DELETE)),
    RIDER(
            Set.of(
                    RIDER_READ,
                    RIDER_UPDATE,
                    RIDER_CREATE,
                    RIDER_DELETE)),
    CLIENT(
            Set.of(CLIENT_READ,
                    CLERK_UPDATE,
                    CLERK_CREATE,
                    CLERK_DELETE));

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
