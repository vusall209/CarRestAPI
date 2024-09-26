package az.restaipcar.contoller;

import az.restaipcar.entity.Car;
import az.restaipcar.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v2/car")
@RequiredArgsConstructor
public class CarContoller {
    private final CarService carService;

    @PostMapping("/create")
    public Car carCreat(@RequestBody Car car) {
        return carService.create(car);
    }

    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable int id){
        return carService.getById(id);
    }

    @PutMapping("/{id}")
    public Car create(@PathVariable int id,@RequestBody Car carUpdate){
        return carService.carUpdate(id,carUpdate);
    }


}
