package com.esprit.microservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class StockService {
	@Autowired
	private StockRepository StockRepository;
	public Stock addStock(Stock stock) {
		return StockRepository.save(stock);
	}
	
	public Stock updateStock(int id, Stock newStock) {
		if (StockRepository.findById(id).isPresent()) {
			Stock existingStock = StockRepository.findById(id).get();
			existingStock.setQuantite(newStock.getQuantite());
			existingStock.setDescription(newStock.getDescription());
			existingStock.setType(newStock.getType());

			return StockRepository.save(existingStock);
		} else
			return null;
	}
	
	public String deleteStock(int id) {
		if (StockRepository.findById(id).isPresent()) {
			StockRepository.deleteById(id);
			return "stock supprimé";
		} else
			return "stock non supprimé";
	}
}
