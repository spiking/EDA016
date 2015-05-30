package Mandelbrot;

public class Complex {
	double re, im;

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public double getRe() {
		return re;
	}

	public double getIm() {
		return im;
	}

	/*
	 * Istället för att räkna absolutbeloppet med hjälp av rot jämför vi
	 * istället talet i kvadrat med 4 (istället för 2)
	 */
	public double getAbs2() {
		return (re * re) + (im * im);
	}

	public void add(Complex c) {
		re += c.re;
		im += c.im;
	}

	/*
	 * Multiplicerar detta komplexa tal med ett komplext tal c enligt formel.
	 */
	public void mul(Complex c) {
		double temp = re * c.re - im * c.im;
		im = re * c.im + im * c.re;
		re = temp;
	}
}
