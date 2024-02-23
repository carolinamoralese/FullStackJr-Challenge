package com.example.Prueba.Controllers;

import com.example.Prueba.ApiConsumer;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/v1")
public class ApiController {
    @GetMapping("/anime")
    public String getAnimes() throws JSONException {
        ApiConsumer apiConsumer = new ApiConsumer();
        return apiConsumer.getApiAnimes();
    }

}
