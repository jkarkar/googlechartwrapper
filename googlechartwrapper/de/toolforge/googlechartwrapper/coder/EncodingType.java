package de.toolforge.googlechartwrapper.coder;

/**
 * 	
 * @author steffan
 *
 */
public enum EncodingType{
		
		
		SimpleEncoding('s',1),
		ExtendedEncoding('e',2),
		TextEncoding('t',3),
		TextEncodingWithDataScaling('t',4);
		
		private final char prefix;
		private final int rank;
	
		EncodingType(char prefix, int rank){
			this.prefix = prefix;
			this.rank = rank;
		}
		/**
		 * 
		 * @return prefix e.g 's' or 'e'
		 */
		public char getPrefix(){
			return this.prefix;
		}
		
		/**
		 * The api needs s: ... or e: ..., so we deliver the full prefix
		 * 
		 * @return complete prefix
		 */
		public String getCompletePrefix(){
			return this.prefix + ":";
		}
		
		/**
		 * Every EncodingType has a rank in addition of the possibly values.
		 * 
		 * @return rank
		 */
		public int getRank(){
			return this.rank;
		}

}
