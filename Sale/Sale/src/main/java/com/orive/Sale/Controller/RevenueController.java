package com.orive.Sale.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orive.Sale.Dto.RevenueDto;
import com.orive.Sale.Entity.RevenueEntity;
import com.orive.Sale.Service.RevenueService;



@RestController
@RequestMapping(value = "revenue")
@CrossOrigin(origins = "*")
public class RevenueController {

	 private static final Logger logger = LoggerFactory.getLogger(RevenueController.class);
		
		@Autowired
		private RevenueService revenueService;
		
		// Create a new WorkSheet
			  @PostMapping("/create/Revenue")
			  // @PreAuthorize("hasRole('client_admin')")
			  public ResponseEntity<RevenueDto> createSale(@RequestBody RevenueDto saleDto) {
				  RevenueDto createdWorkSheet = revenueService.createRevenue(saleDto);
			      logger.info("Created Revenue with id: {}", createdWorkSheet.getRevenueId());
			      return new ResponseEntity<>(createdWorkSheet, HttpStatus.CREATED);
			  }

			  
			  // Get all WorkSheet  
			  @GetMapping("/get/Revenue")
			  // @PreAuthorize("hasRole('client_admin')")
			  public ResponseEntity<List<RevenueDto>> getAllSale() {
			      List<RevenueDto> workSheet = revenueService.getAllRevenue();
			      logger.info("Retrieved {} Revenue from the database", workSheet.size());
			      return new ResponseEntity<>(workSheet, HttpStatus.OK);
			  }

			  // Get WorkSheet by ID
			  @GetMapping("/get/{revenueId}")
			    // @PreAuthorize("hasRole('client_admin')|| hasRole('client_user')")
			  public ResponseEntity<RevenueDto> getSaleId(@PathVariable Long revenueId) {
			      Optional<RevenueDto> workSheet = revenueService.getRevenueId(revenueId);
			      if (workSheet.isPresent()) {
			          logger.info("Retrieved Revenue with ID: {}", revenueId);
			          return new ResponseEntity<>(workSheet.get(), HttpStatus.OK);
			      } else {
			          logger.warn("Revenue with ID {} not found", revenueId);
			          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			      }
			  }
			  
			  
			  
			  
			  // Update WorkSheet by ID
			  @PutMapping("/update/{revenueId}")
			  // @PreAuthorize("hasRole('client_admin')")
			  public ResponseEntity<RevenueDto> updateSale(@PathVariable Long revenueId, @RequestBody RevenueDto saleDto) {
				  RevenueDto updatedWorkSheet = revenueService.updateRevenue(revenueId, saleDto);
			      if (updatedWorkSheet != null) {
			          logger.info("Updated Revenue with ID: {}", revenueId);
			          return new ResponseEntity<>(updatedWorkSheet, HttpStatus.OK);
			      } else {
			          logger.warn("Revenue with ID {} not found for update", updatedWorkSheet);
			          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			      }
			  }
			  
			  // Delete WorkSheet by ID
			  @DeleteMapping("/delete/{revenueId}")
			  // @PreAuthorize("hasRole('client_admin')")
			  public ResponseEntity<Void> deleteSale(@PathVariable Long revenueId) {
				  revenueService.deleteRevenue(revenueId);
			      logger.info("Deleted Revenue with ID: {}", revenueId);
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  }
				    
				    @GetMapping("/count/Revenue")
				    // @PreAuthorize("hasRole('client_admin')")
				    public long countSale()
				    {
				    	return revenueService.countRevenue();
				    }
				    
				    @GetMapping("/revenue/total-net")
				    public Double getTotalNetRevenueForMonth(@RequestParam int month) {
				        return revenueService.getTotalNetRevenueForMonth(month);
				    }

				    @GetMapping("/revenue/net-in-month")
				    public List<RevenueEntity> getNetRevenuesInMonth(@RequestParam String startDate, @RequestParam String endDate) {
				        LocalDate start = LocalDate.parse(startDate);
				        LocalDate end = LocalDate.parse(endDate);
				        return revenueService.getNetRevenuesInMonth(start, end);
				    }	
				    
				    @GetMapping("/total-money-added")
				    public String getTotalMoneyAddedInBank(@RequestParam String moneyAddedBankName) {
				        Optional<Double> totalMoneyAdded = revenueService.getTotalMoneyAddedInBank(moneyAddedBankName);
				        return totalMoneyAdded.map(String::valueOf).orElse("Bank not found or no revenue added yet.");
				    }
				    
				    @GetMapping("/total-sales")
				    public String getTotalSalesForProductInYear(@RequestParam int year, @RequestParam String productName) {
				        Optional<Double> totalSales = revenueService.getTotalSalesForProductInYear(year, productName);
				        return totalSales.map(String::valueOf).orElse("Product not found or no sales recorded for the year.");
				    }
				    
				    @GetMapping("/profitLoss/{currentMonth}")
				    public ResponseEntity<String> calculateProfitOrLossMessageForMonth(@PathVariable int currentMonth) {
				        String profitLossMessage = revenueService.calculateProfitOrLossMessageForMonth(currentMonth);
				        return new ResponseEntity<>(profitLossMessage, HttpStatus.OK);
				    }
				    
				    @GetMapping("/netrevenuepercentage")
				    public ResponseEntity<Double> getNetRevenuePercentage() {
				        Double netRevenuePercentage = revenueService.calculateNetRevenuePercentage();
				        return new ResponseEntity<>(netRevenuePercentage, HttpStatus.OK);
				    }
				    
				    @GetMapping("/totalNetRevenue")
				    public ResponseEntity<Double> getTotalNetRevenue() {
				        Double totalNetRevenue = revenueService.calculateTotalNetRevenue();
				        return new ResponseEntity<>(totalNetRevenue, HttpStatus.OK);
				    }
				    
				    
				    
}

