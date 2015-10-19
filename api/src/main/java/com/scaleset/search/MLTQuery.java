package com.scaleset.search;

/** 
 * More like this query
 * 
 * @author sfellah
 *
 */
public class MLTQuery extends Query {

	protected String[] id;
	private String likeText;
    private float percentTermsToMatch = -1;
    private int minTermFreq = -1;
    private int maxQueryTerms = -1;
    private String[] stopWords = null;
    private int minDocFreq = -1;
    private int maxDocFreq = -1;
    private int minWordLen = -1;
    private int maxWordLen = -1;
    private float boostTerms = -1;
    private float boost = -1;
	public String[] getId() {
		return id;
	}
	public void setId(String... id) {
		this.id = id;
	}
	public String getLikeText() {
		return likeText;
	}
	public void setLikeText(String likeText) {
		this.likeText = likeText;
	}
	public float getPercentTermsToMatch() {
		return percentTermsToMatch;
	}
	public void setPercentTermsToMatch(float percentTermsToMatch) {
		this.percentTermsToMatch = percentTermsToMatch;
	}
	public int getMinTermFreq() {
		return minTermFreq;
	}
	public void setMinTermFreq(int minTermFreq) {
		this.minTermFreq = minTermFreq;
	}
	public int getMaxQueryTerms() {
		return maxQueryTerms;
	}
	public void setMaxQueryTerms(int maxQueryTerms) {
		this.maxQueryTerms = maxQueryTerms;
	}
	public String[] getStopWords() {
		return stopWords;
	}
	public void setStopWords(String... stopWords) {
		this.stopWords = stopWords;
	}
	public int getMinDocFreq() {
		return minDocFreq;
	}
	public void setMinDocFreq(int minDocFreq) {
		this.minDocFreq = minDocFreq;
	}
	public int getMaxDocFreq() {
		return maxDocFreq;
	}
	public void setMaxDocFreq(int maxDocFreq) {
		this.maxDocFreq = maxDocFreq;
	}
	public int getMinWordLen() {
		return minWordLen;
	}
	public void setMinWordLen(int minWordLen) {
		this.minWordLen = minWordLen;
	}
	public int getMaxWordLen() {
		return maxWordLen;
	}
	public void setMaxWordLen(int maxWordLen) {
		this.maxWordLen = maxWordLen;
	}
	public float getBoostTerms() {
		return boostTerms;
	}
	public void setBoostTerms(float boostTerms) {
		this.boostTerms = boostTerms;
	}
	public float getBoost() {
		return boost;
	}
	public void setBoost(float boost) {
		this.boost = boost;
	}
	
	
}
