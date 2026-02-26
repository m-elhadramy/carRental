package app.car_rental.api.controllers;

import app.car_rental.api.services.MenuService;
import app.car_rental.data.entities.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/my-menus")
    public ResponseEntity<List<SysMenu>> getUserMenus() {
        return ResponseEntity.ok(menuService.getUserMenus());
    }
}
