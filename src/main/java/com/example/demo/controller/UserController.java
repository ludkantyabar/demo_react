package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @Operation(summary = "Crear un nuevo usuario")
    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @Operation(summary = "Listar todos los usuarios")
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
    @Operation(summary = "Obtener un usuario por ID")
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @Operation(summary = "Actualizar un usuario existente")
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @Operation(summary = "Eliminar un usuario por ID")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }
}