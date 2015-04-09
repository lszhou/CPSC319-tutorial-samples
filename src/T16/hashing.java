package matrix;

/**
 * Typically, hash functions could be classified as follows
 * based on the operations they apply:
 * 
 * - Addition Hashing
 * - Bit Opt Hashing: DJB, ELF (Unix System Hashing)
 * - Multiplication Hashing: BKDR, java.lang.String hashcode() algorithm 
 * - Division Hashing: CRC
 * - Hybrid Hashing: MD5 (for encryption instead of searching)
 * 
 * Here is a good reference for the evaluation:
 * <a href="http://www.burtleburtle.net/bob/hash/doobs.html">
 * 
 * @author lszhou
 *
 */

public class hashing {
	
	/**
	 * Addition Hashing
	 * 
	 * @param key   Given String
	 * @param prime Arbitrary prime number
	 * @return integer hash value
	 */
	static int additiveHash(String key, int prime)
	{
	   int hash, i;
	   for (hash = key.length(), i = 0; i < key.length(); i++)
	    hash += key.charAt(i);
	   return (hash % prime);
	}
	
	/**
	 * Multiplication Hashing: BKDR
	 */
	static long BKDRHash(String str) {
		long seed = 31; // 131 1313 13131 131313 etc is also a good choice
		long hash = 0;
		for (int i = 0; i < str.length(); i++) {
			hash = (hash * seed) + str.charAt(i);
		}
		return hash;
	}
	
	/**
	 * Bit Operation Hashing
	 */
	public long DJBHash(String str) {
		long hash = 5381;
		for (int i = 0; i < str.length(); i++) {
			hash = ((hash << 5) + hash) + str.charAt(i);
		}
		return hash;
	}
	
	

}
