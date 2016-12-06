/**
 * 
 */
package aufgaben7_test;

import java.math.BigInteger;

/**
 * @author Sören Wirries
 *
 */
public class Rational extends Number {

	final public BigInteger nenner;
	final public BigInteger zaehler;
	
	
	public Rational(BigInteger zaehler, BigInteger nenner){
		this.nenner = nenner;
		this.zaehler = zaehler;
	}
	
	public Rational(int zaehler, int nenner){
		this.nenner = new BigInteger(""+nenner);
		this.zaehler = new BigInteger(String.valueOf(zaehler));
	}
	
	public Rational add(Rational r){
		
		Rational ergebnis = new Rational(
				this.zaehler.multiply(r.nenner).add(this.nenner.multiply(r.zaehler)),
				this.nenner.multiply(r.nenner)
				);
		//ergebnis.nenner = this.nenner.multiply(r.nenner);
		//ergebnis.zaehler = this.zaehler.multiply(r.nenner).add(this.nenner.multiply(r.zaehler));
		/**
		 *r erg nenner = r1 nenner * r2 nenner
		 *r erg zaehler = r1 zaehler * r2 nenner + r2 nenner * r1 zaehler
		 *
		 *retrun r erg
		 */
		return ergebnis.kuerzen();
	}
	
	public Rational subtract(Rational r){
		Rational ergebnis = new Rational(
				this.zaehler.multiply(r.nenner).subtract(this.nenner.multiply(r.zaehler)),
				this.nenner.multiply(r.nenner)
				);
		//ergebnis.nenner = this.nenner.multiply(r.nenner);
		//ergebnis.zaehler = this.zaehler.multiply(r.nenner).subtract(this.nenner.multiply(r.zaehler));
		/**
		 *r erg nenner = r1 nenner * r2 nenner
		 *r erg zaehler = r1 zaehler * r2 nenner - r2 nenner * r1 zaehler
		 *
		 *retrun r erg
		 */
		return ergebnis.kuerzen();
	}
	
	public Rational multiply(Rational r){
		Rational ergebnis = new Rational(
				this.zaehler.multiply(r.zaehler),
				this.nenner.multiply(r.nenner)
				);
		
		//ergebnis.zaehler = this.zaehler.multiply(r.zaehler);
		//ergebnis.nenner = this.nenner.multiply(r.nenner);
		
		return ergebnis.kuerzen();
	}
	
	public Rational divide(Rational r){
		Rational ergebnis = new Rational(
				this.zaehler.multiply(r.nenner),
				this.nenner.multiply(r.zaehler)
				);
		
		//ergebnis.zaehler = this.zaehler.multiply(r.nenner);
		//ergebnis.nenner = this.nenner.multiply(r.zaehler);
		
		return ergebnis.kuerzen();
	}
	
	public boolean isInteger(){
		
		if(zaehler.mod(nenner).equals(BigInteger.ZERO)){
			return true;
		}else{
			return false;
		}
		/**
		 * wenn nenner = zaehler
		 * wenn nenner = 1
		 * wenn zaehler mod nenner = 0
		 */
		
	}
	
	private Rational kuerzen(){
		BigInteger ggT = zaehler.gcd(nenner);
		
		BigInteger kZaehler = this.zaehler.divide(ggT);
		BigInteger kNenner = this.nenner.divide(ggT);
		
		/**
		 *  wie oft passt zaehler in nenner -> ggT bei BigInt = gcd
		 * 	
		 */
		Rational rational = new Rational(kZaehler,kNenner);
		
		return rational;
	}
	
	
	public String toString(){
		
		String ergebnis = this.zaehler + "/" + this.nenner;
		return ergebnis;
	}
	
	
	
	
	
	/*
	 * 34
	 * --
	 * 45
	 * 34/91
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
