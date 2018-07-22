package com.practice.java.design.patterns.chainofresponsibility;

public interface TradeEnrichment {

	public void enrichment(TradeAccount tradeAccount);
	
	public void setNextEnricher(TradeEnrichment nextEnricher);
}
