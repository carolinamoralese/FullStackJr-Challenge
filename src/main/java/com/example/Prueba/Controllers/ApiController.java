package com.example.Prueba.Controllers;

import com.example.Prueba.ApiConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ApiController {
    @GetMapping("/anime")
    public String getAnimes() {
        ApiConsumer apiConsumer = new ApiConsumer();
        return apiConsumer.getApiAnimes();
    }

    @GetMapping("/anime/{id}")
    public String getAnimeById(@PathVariable Integer id) {
        ApiConsumer apiConsumer = new ApiConsumer();
        return apiConsumer.getApiAnimeById(id);
    }


}
