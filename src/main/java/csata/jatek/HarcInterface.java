package csata.jatek;
/**
 * 
 * Harcokat reprezenatlo interface
 *
 */
public interface HarcInterface {
	public Class<?> getJatekosTipus1();

	public Class<?> getJatekosTipus2();

	/**
	 * Eldonti ki nyerte a csatat
	 * @param jatekos1 Egyik jatekos
	 * @param jatekos2 Masik jatekos
	 * @return vesztes jatekos
	 */
	public Jatekos csataz(Jatekos jatekos1, Jatekos jatekos2);
}
