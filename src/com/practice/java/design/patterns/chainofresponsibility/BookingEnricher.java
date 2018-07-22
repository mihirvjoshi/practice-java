package com.practice.java.design.patterns.chainofresponsibility;

public class BookingEnricher implements TradeEnrichment {

	TradeEnrichment enricher;

	@Override
	public void enrichment(TradeAccount tradeAccount) {

		System.out.println("Enriching The Trade Booked");

		if(enricher != null)
			this.enricher.enrichment(tradeAccount); // call next enrichment
	}

	@Override
	public void setNextEnricher(TradeEnrichment nextEnricher) {
		this.enricher = nextEnricher;
	}

}
