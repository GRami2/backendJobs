package apis.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apis.com.entities.Sector;
import apis.com.service.SectorService;

@RestController
@RequestMapping("/sector")
@CrossOrigin(origins = "http://localhost:4200")
public class SectorController {
	
	@Autowired
    private SectorService sectorService;

    @PostMapping("/create")
    public ResponseEntity<Sector> createSector(@RequestBody Sector sector) {
        Sector createdSector = sectorService.createSector(sector);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSector);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Sector>> getAllSectors() {
        List<Sector> sectors = sectorService.getAllSectors();
        return ResponseEntity.ok(sectors);
    }

    @GetMapping("/sector/{id}")
    public ResponseEntity<Sector> getSectorById(@PathVariable Long id) {
        Sector sector = sectorService.getSectorById(id);
        return ResponseEntity.ok(sector);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Sector> updateSector(@PathVariable Long id, @RequestBody Sector sector) {
        Sector updatedSector = sectorService.updateSector(id, sector);
        return ResponseEntity.ok(updatedSector);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSector(@PathVariable Long id) {
        sectorService.deleteSector(id);
        return ResponseEntity.noContent().build();
    }
}
