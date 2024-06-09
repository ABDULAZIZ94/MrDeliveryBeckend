package api.mrdelivery.abdaziz.apimrdelivery.user;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.ADMIN_READ;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.ADMIN_UPDATE;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.CLERK_CREATE;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.CLERK_DELETE;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.CLERK_READ;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.CLERK_UPDATE;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.CLIENT_READ;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.RIDER_CREATE;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.RIDER_DELETE;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.RIDER_READ;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.RIDER_UPDATE;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.STACKHOLDER_CREATE;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.STACKHOLDER_DELETE;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.STACKHOLDER_READ;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.STACKHOLDER_UPDATE;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.ACCOUNTANT_CREATE;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.ACCOUNTANT_DELETE;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.ACCOUNTANT_READ;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.ACCOUNTANT_UPDATE;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.ADMIN_CREATE;
import static api.mrdelivery.abdaziz.apimrdelivery.user.Permission.ADMIN_DELETE;

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
