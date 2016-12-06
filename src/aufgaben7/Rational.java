/**
 * 
 */
package aufgaben7;

import java.math.BigInteger;

/**
 * @author Sören Wirries
 *
 */
public class Rational extends Number {
	
	public BigInteger zaehler;
	public BigInteger nenner;
	
	
	public Rational(BigInteger zaehler, BigInteger nenner){
		this.nenner = nenner;
		this.zaehler = zaehler;
	}
	
	public Rational add(Rational r){
		
		BigInteger newNenner = this.nenner.multiply(r.nenner);
		BigInteger newZaehler = this.nenner.multiply(r.zaehler).add(this.zaehler.multiply(r.nenner));
		
		return shorter(newZaehler, newNenner);
		
	}
	
	public boolean isInteger(){
		
		return this.zaehler.mod(this.nenner).equals(BigInteger.ZERO);
		
	}
	
	public Rational subtract(Rational r){
		
		BigInteger newNenner = this.nenner.multiply(r.nenner);
		BigInteger newZaehler = this.nenner.multiply(r.zaehler).subtract(this.zaehler.multiply(r.nenner));
		
		return shorter(newZaehler, newNenner);
		
	}
	
	
	
	public Rational divide(Rational r){
		
		BigInteger newZaehler = this.zaehler.multiply(r.nenner);
		BigInteger newNenner = this.nenner.multiply(r.zaehler);
		
		return shorter(newZaehler, newNenner);
		
	}
	
	public Rational multiply(Rational r){
		
		BigInteger newZaehler = this.zaehler.multiply(r.zaehler);
		BigInteger newNenner = this.nenner.multiply(r.nenner);
		
		return shorter(newZaehler, newNenner);
	}
	
	private Rational shorter(BigInteger zaehler, BigInteger nenner){
		BigInteger teiler = nenner.gcd(zaehler);
		
		nenner = nenner.divide(teiler);
		zaehler = zaehler.divide(teiler);
		
		return new Rational(zaehler, nenner);
		
	}
	
	public String toString(){
		return this.zaehler + "/" + this.nenner;
	}

	/* (non-Javadoc)
	 * @see java.lang.Number#doubleValue()
	 */
	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Number#floatValue()
	 */
	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Number#intValue()
	 */
	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Number#longValue()
	 */
	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
