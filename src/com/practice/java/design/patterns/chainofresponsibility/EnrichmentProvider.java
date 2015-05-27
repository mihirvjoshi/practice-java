package com.practice.java.design.patterns.chainofresponsibility;

public class EnrichmentProvider {

	TradeEnrichment firstEnricher;
	
	public EnrichmentProvider() {
		
		this.firstEnricher = new BookingEnricher();
		TradeEnrichment secondEnricher = new PartyEnricher();

		//set enrichment sequence here
		firstEnricher.setNextEnricher(secondEnricher);		
	}
	
	
	public static void main(String[] args) {
		
		EnrichmentProvider tradeEnrichmentProvider = new EnrichmentProvider();
		
		TradeAccount account = new TradeAccount();
		account.setTradeType(TradeType.BOOK);
		
		tradeEnrichmentProvider.firstEnricher.enrichment(account);
	}
}
