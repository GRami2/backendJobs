package apis.com.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apis.com.entities.Sector;
import apis.com.repository.SectorRepository;
import apis.com.service.SectorService;

@Service
public class SectorImpl implements SectorService {

	@Autowired
	private SectorRepository sectorRepository;

	@Override
	public Sector createSector(Sector sector) {
		return sectorRepository.save(sector);
	}

	@Override
	public List<Sector> getAllSectors() {
		return sectorRepository.findAll();
	}

	@Override
	public Sector getSectorById(Long id) {
		return sectorRepository.findById(id).orElseThrow(() -> new RuntimeException("Sector not found with ID: " + id));
	}

	@Override
	public Sector updateSector(Long id, Sector sector) {
		Sector existingSector = sectorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Sector not found with ID: " + id));
		existingSector.setName(sector.getName());
		return sectorRepository.save(existingSector);
	}

	@Override
	public void deleteSector(Long id) {
		if (!sectorRepository.existsById(id)) {
			throw new RuntimeException("Sector not found with ID: " + id);
		}
		sectorRepository.deleteById(id);
	}

}
