package org.example.springexceptionhandlingtask20240516;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @GetMapping("{brand}")
    String getCarBrand(@PathVariable String brand) {
        if (!brand.equals("porsche")) {
            throw new IllegalArgumentException("Only 'porsche' allowed");
        }
        return brand;
    }
    @GetMapping
    String getAllCars() {
        throw new NoSuchElementException("No Cars found");
    }
//    For the IllegalArgumentException, typically you would use HttpStatus.BAD_REQUEST (400) because this exception indicates that the request is invalid.
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage illegalArgumentException(IllegalArgumentException ex) {
        //ex.printStackTrace();
        return new ErrorMessage(ex.getMessage());
    }

}
