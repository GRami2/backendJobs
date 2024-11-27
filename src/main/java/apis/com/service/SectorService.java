package apis.com.service;

import java.util.List;

import apis.com.entities.Sector;

public interface SectorService {
	
	 	public Sector createSector(Sector sector);
	 	public List<Sector> getAllSectors();
	 	public Sector getSectorById(Long id);
	 	public Sector updateSector(Long id, Sector sector);
	 	public void deleteSector(Long id);
}
