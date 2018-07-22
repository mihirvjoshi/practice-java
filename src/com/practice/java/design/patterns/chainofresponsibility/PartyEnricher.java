package com.practice.java.design.patterns.chainofresponsibility;

public class PartyEnricher implements TradeEnrichment {

	TradeEnrichment enricher;

	@Override
	public void enrichment(TradeAccount tradeAccount) {

		System.out.println("Enriching The Trading Parties");
		
		if(enricher != null)
			this.enricher.enrichment(tradeAccount); // call next enrichment
	}

	@Override
	public void setNextEnricher(TradeEnrichment nextEnricher) {
		this.enricher = nextEnricher;
	}

}
