package app.car_rental.api.services;

import app.car_rental.data.entities.SysMenu;
import app.car_rental.data.repositories.SysMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MenuService {

    private final SysMenuRepository sysMenuRepository;

    @Autowired
    public MenuService(SysMenuRepository sysMenuRepository) {
        this.sysMenuRepository = sysMenuRepository;
    }

    public List<SysMenu> getUserMenus() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Convertir les rôles utilisateur en Set pour recherche O(1)
        Set<String> userRoles = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        List<SysMenu> menus = sysMenuRepository.findByParentIsNullOrderByOrdreAsc();

        List<SysMenu> result = new ArrayList<>();

        for (SysMenu menu : menus) {
            if (!isAccessible(menu, userRoles)) {
                continue;
            }
            // Filtrer les enfants par rôle
            List<SysMenu> filteredChildren = menu.getChildren().stream()
                    .filter(child -> isAccessible(child, userRoles))
                    .collect(Collectors.toList());
            menu.setChildren(filteredChildren);
            result.add(menu);
        }

        return result;
    }

    private boolean isAccessible(SysMenu menu, Set<String> userRoles) {
        if (menu.getRoles() == null || menu.getRoles().isEmpty()) {
            return true;
        }
        for (String role : menu.getRoles()) {
            if (userRoles.contains(role)) {
                return true;
            }
        }
        return false;
    }
}
