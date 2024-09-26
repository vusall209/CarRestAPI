package az.restaipcar.service;

import az.restaipcar.entity.Car;
import az.restaipcar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Car create(Car car) {
        return carRepository.save(car);
    }

    public Optional<Car> getById(int id) {
        return carRepository.findById(id);
    }

    public Car carUpdate(int id, Car carUpdate) {
        Car existingCar=carRepository.findById(id)
                .orElseThrow(()->new RuntimeException("ID:"+id+" olan bir masin qarajda yoxdu"));

        existingCar.setBrand(carUpdate.getBrand());
        existingCar.setModel(carUpdate.getModel());
        existingCar.setYear(carUpdate.getYear());
        return carRepository.save(existingCar);
    }
}
