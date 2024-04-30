package services;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Robo {

    // Esimerkki tallennettavasta datasta
    private List
RoboModel> dataList;
// Luo uuden robopalvelun ja alusta data
public Robo() {
    dataList = new ArrayList<>();
    dataList.add(new RoboModel("forward", 0)); // Esimerkkidata, oletetaan että aluksi robotti on eteen päin ja nopeus on 0
}

// Metodi hakee kaiken datan
@GetMapping("/data")
public List
RoboModel> getAllData() {
return dataList;
}
// Metodi lisää uuden datan
@PostMapping("/data")
public void addData(@RequestBody RoboModel data) {
    dataList.add(data);
}

// Metodi hakee yksittäisen datan id:n perusteella
@GetMapping("/data/{id}")
public RoboModel getData(@PathVariable("id") int id) {
    if (id >= 0 && id < dataList.size()) {
        return dataList.get(id);
    } else {
        throw new IllegalArgumentException("Invalid data id");
    }
}

// Metodi päivittää datan id:n perusteella
@PutMapping("/data/{id}")
public void updateData(@PathVariable("id") int id, @RequestBody RoboModel newData) {
    if (id >= 0 && id < dataList.size()) {
        dataList.set(id, newData);
    } else {
        throw new IllegalArgumentException("Invalid data id");
    }
}

// Metodi poistaa datan id:n perusteella
@DeleteMapping("/data/{id}")
public void deleteData(@PathVariable("id") int id) {
    if (id >= 0 && id < dataList.size()) {
        dataList.remove(id);
    } else {
        throw new IllegalArgumentException("Invalid data id");
    }
}
}

//Tässä koodissa on seuraavat toiminnot:

//- `getAllData()`: Palauttaa kaiken datan.
//- `addData(data)`: Lisää uuden datan.
//- `getData(id)`: Hakee yksittäisen datan id:n perusteella.
//- `updateData(id, newData)`: Päivittää datan id:n perusteella.
//- `deleteData(id)`: Poistaa datan id:n perusteella.

//Jokaisella metodilla on määritelty RESTful-endpoint, kuten `@GetMapping("/data"
